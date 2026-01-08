
package com.korber.inventory.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.korber.inventory.entity.InventoryBatch;

@Repository
public interface InventoryBatchRepository extends JpaRepository<InventoryBatch, Long> {
	
    List<InventoryBatch> findByProductIdOrderByExpiryDateAsc(Long productId);
    
}
