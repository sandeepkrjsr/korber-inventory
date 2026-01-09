
package com.korber.inventory.factory;

import java.util.List;

import com.korber.inventory.dto.InventoryReserveResponse;
import com.korber.inventory.entity.InventoryBatch;

public interface InventoryHandler {
	
    public List<InventoryBatch> getBatches(Long productId);
    
    public InventoryReserveResponse updateStock(Long productId, int quantity);
    
}
