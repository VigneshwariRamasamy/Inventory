package com.example.inventory.dto;

public class OrderedItemsDTO {

	private Integer id;

	private String skuCode;

	private String price;

	private String quantity;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}



	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getQuantity() {
		return quantity;
	}

	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}

	public OrderedItemsDTO(Integer id, String skuCode, String price, String quantity) {
	
		this.id = id;
		this.skuCode = skuCode;
		this.price = price;
		this.quantity = quantity;
	}

	public String getSkuCode() {
		return skuCode;
	}

	public void setSkuCode(String skuCode) {
		this.skuCode = skuCode;
	}

	public OrderedItemsDTO() {
		
	}
	
}
