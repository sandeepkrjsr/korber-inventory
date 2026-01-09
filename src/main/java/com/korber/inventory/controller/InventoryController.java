
package com.korber.inventory.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.korber.inventory.dto.InventoryResponse;
import com.korber.inventory.dto.InventoryUpdateRequest;
import com.korber.inventory.service.InventoryService;

@RestController
@RequestMapping("/inventory")
public class InventoryController {

    private final InventoryService service;
    
    InventoryController(InventoryService service) {
		this.service = service;
	}

    @GetMapping("/{productId}")
    public InventoryResponse getBatches(@PathVariable Long productId) {
        return service.getBatches(productId);
    }

    @PostMapping("/update")
    public void updateStock(@RequestBody InventoryUpdateRequest request) {
        service.updateStock(request.getProductId(), request.getQuantity());
    }

}
