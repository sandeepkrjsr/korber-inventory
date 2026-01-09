package com.korber.inventory.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.korber.inventory.dto.BatchResponse;
import com.korber.inventory.dto.InventoryResponse;
import com.korber.inventory.entity.InventoryBatch;
import com.korber.inventory.factory.InventoryHandlerFactory;

@Service
public class InventoryService {

    private final InventoryHandlerFactory factory;

    public InventoryService(InventoryHandlerFactory factory) {
        this.factory = factory;
    }

    public InventoryResponse getBatches(Long productId) {
    	
    	List<InventoryBatch> batches = factory.getHandler().getBatches(productId);

        List<BatchResponse> batchResponses = batches.stream()
        	.map(b -> {
        		BatchResponse br = new BatchResponse();
        		br.setBatchId(b.getBatchId());
        		br.setQuantity(b.getQuantity());
        		br.setExpiryDate(b.getExpiryDate());
        		return br;
        	}).toList();
        
        InventoryResponse response = new InventoryResponse();
        response.setProductId(productId);
        response.setProductName(batches.get(0).getProductName());
        response.setBatches(batchResponses);
        
        return response;
    }

    public void updateStock(Long productId, int quantity) {
        factory.getHandler().updateStock(productId, quantity);
    }
    
}

