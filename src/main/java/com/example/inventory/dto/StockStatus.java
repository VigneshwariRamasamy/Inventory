package com.example.inventory.dto;

import lombok.Builder;

@Builder
public class StockStatus {

	private String skuCode;
	
    private boolean isInStock;

    
	@Override
	public String toString() {
		return "StockStatus [skuCode=" + skuCode + ", isInStock=" + isInStock + "]";
	}

	public String getSkuCode() {
		return skuCode;
	}

	public void setSkuCode(String skuCode) {
		this.skuCode = skuCode;
	}

	public boolean isInStock() {
		return isInStock;
	}

	public void setInStock(boolean isInStock) {
		this.isInStock = isInStock;
	}

	public StockStatus(String skuCode, boolean isInStock) {
		
		this.skuCode = skuCode;
		this.isInStock = isInStock;
	}

	public StockStatus() {
		
	}

	
}
