
package com.korber.inventory.factory;

import java.util.List;

import com.korber.inventory.entity.InventoryBatch;

public interface InventoryHandler {
	
    public List<InventoryBatch> getBatches(Long productId);
    
    public void updateStock(Long productId, int quantity);
    
}
