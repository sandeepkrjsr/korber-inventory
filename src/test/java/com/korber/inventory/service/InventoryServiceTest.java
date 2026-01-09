package com.korber.inventory.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

import java.util.List;

import com.korber.inventory.dto.InventoryResponse;
import com.korber.inventory.entity.InventoryBatch;
import com.korber.inventory.factory.InventoryHandler;
import com.korber.inventory.factory.InventoryHandlerFactory;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

class InventoryServiceTest {

    @Mock
    private InventoryHandlerFactory factory;

    @Mock
    private InventoryHandler handler;

    @InjectMocks
    private InventoryService inventoryService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void shouldReturnInventoryBatches() {
        Long productId = 101L;

        List<InventoryBatch> mockBatches = List.of(
                new InventoryBatch(1L, productId, "ProductA", 10, null),
                new InventoryBatch(2L, productId, "ProductA", 5, null)
        );

        // Fix: factory returns mocked handler
        when(factory.getHandler()).thenReturn(handler);

        // Mock handler method
        when(handler.getBatches(productId)).thenReturn(mockBatches);

        InventoryResponse result = inventoryService.getBatches(productId);

        assertEquals(2, result.getBatches().size());
        verify(factory, times(1)).getHandler();
        verify(handler, times(1)).getBatches(productId);
    }

    @Test
    void shouldUpdateInventory() {
        Long productId = 101L;
        int quantity = 5;

        when(factory.getHandler()).thenReturn(handler);
        doNothing().when(handler).updateStock(productId, quantity);

        inventoryService.updateStock(productId, quantity);

        verify(factory, times(1)).getHandler();
        verify(handler, times(1)).updateStock(productId, quantity);
    }

    @Test
    void shouldThrowExceptionIfFactoryFails() {
        Long productId = 101L;

        // Factory returns null to simulate failure
        when(factory.getHandler()).thenReturn(null);

        // Calling service should throw NullPointerException
        assertThrows(NullPointerException.class, () -> inventoryService.getBatches(productId));

        verify(factory, times(1)).getHandler();
    }
    
}