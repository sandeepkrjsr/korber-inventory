package com.korber.inventory.dto;

import java.util.List;

public class InventoryResponse {

    private Long productId;
    private String productName;
    private List<BatchResponse> batches;
    
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
	
	public List<BatchResponse> getBatches() {
		return batches;
	}
	public void setBatches(List<BatchResponse> batches) {
		this.batches = batches;
	}
    
}
