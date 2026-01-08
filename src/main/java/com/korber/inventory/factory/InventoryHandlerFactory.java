
package com.korber.inventory.factory;

import org.springframework.stereotype.Component;

@Component
public class InventoryHandlerFactory {

    private final InventoryHandler inventoryHandler;

    public InventoryHandlerFactory(InventoryHandler inventoryHandler) {
        this.inventoryHandler = inventoryHandler;
    }

    public InventoryHandler getHandler() {
        return inventoryHandler;
    }
    
}