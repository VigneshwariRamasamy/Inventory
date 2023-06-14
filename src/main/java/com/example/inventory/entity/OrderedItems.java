package com.example.inventory.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Builder;

@Entity

@Table(name="orderedItems")
@Builder
public class OrderedItems {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name="product_code")
	private String skuCode;
	
	@Column(name="price")
	private String price;
	
	
	@Column(name="quantity")
	private String quantity;


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getSkuCode() {
		return skuCode;
	}


	public void setSkuCode(String skuCode) {
		this.skuCode = skuCode;
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


	public OrderedItems(Integer id, String skuCode, String price, String quantity) {
	
		this.id = id;
		this.skuCode = skuCode;
		this.price = price;
		this.quantity = quantity;
	}


	public OrderedItems() {
		super();
	}


	@Override
	public String toString() {
		return "OrderedItems [id=" + id + ", skuCode=" + skuCode + ", price=" + price + ", quantity=" + quantity + "]";
	}
	
	

}
