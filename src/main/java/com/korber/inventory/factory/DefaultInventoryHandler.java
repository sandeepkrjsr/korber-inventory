
package com.korber.inventory.factory;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.korber.inventory.dto.InventoryReserveResponse;
import com.korber.inventory.entity.InventoryBatch;
import com.korber.inventory.repository.InventoryBatchRepository;

@Component
public class DefaultInventoryHandler implements InventoryHandler {

    private final InventoryBatchRepository repository;

    public DefaultInventoryHandler(InventoryBatchRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<InventoryBatch> getBatches(Long productId) {
        return repository.findByProductIdOrderByExpiryDateAsc(productId);
    }

    @Override
    public InventoryReserveResponse updateStock(Long productId, int quantity) {
    	
        List<InventoryBatch> batches = repository.findByProductIdOrderByExpiryDateAsc(productId);

        List<Long> reservedBatchIds = new ArrayList<>();
        int remaining = quantity;

        for (InventoryBatch batch : batches) {
            if (remaining <= 0) break;

            int deduct = Math.min(batch.getQuantity(), remaining);
            batch.setQuantity(batch.getQuantity() - deduct);
            remaining -= deduct;
            
            reservedBatchIds.add(batch.getBatchId());
            
            repository.save(batch);
        }

        if (remaining > 0) {
            throw new IllegalStateException("Insufficient inventory for productId: " + productId);
        }
        
        InventoryReserveResponse response = new InventoryReserveResponse();
        response.setProductId(productId);
        response.setProductName(batches.get(0).getProductName());
        response.setReservedBatchIds(reservedBatchIds);

        return response;
        
    }
    
}
