package com.korber.inventory.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.korber.inventory.entity.InventoryBatch;
import com.korber.inventory.factory.InventoryHandlerFactory;

@Service
public class InventoryService {

    private final InventoryHandlerFactory factory;

    public InventoryService(InventoryHandlerFactory factory) {
        this.factory = factory;
    }

    public List<InventoryBatch> getBatches(Long productId) {
        return factory.getHandler().getBatches(productId);
    }

    public void updateStock(Long productId, int quantity) {
        factory.getHandler().updateStock(productId, quantity);
    }
    
}

