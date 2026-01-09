package com.korber.inventory.dto;

import java.util.List;

public class InventoryReserveResponse {

    private Long productId;
    private String productName;
    private List<Long> reservedBatchIds;
    
	public Long getProductId() {
		return productId;
	}
	public void setProductId(Long productId) {
		this.productId = productId;
	}
	
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	
	public List<Long> getReservedBatchIds() {
		return reservedBatchIds;
	}
	public void setReservedBatchIds(List<Long> reservedBatchIds) {
		this.reservedBatchIds = reservedBatchIds;
	}

}
