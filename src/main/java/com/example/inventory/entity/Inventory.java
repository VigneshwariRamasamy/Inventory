package com.example.inventory.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;


@Entity

@Table(name="inventory")

public class Inventory {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name="inventory_no")
	private String inventoryNumber;
	
	@OneToMany(cascade = CascadeType.ALL)
	private List<OrderedItems> orderedItems;
	public Inventory() {
		
	}

	public Inventory(Integer id, String inventoryNumber, List<OrderedItems> orderedItems) {
		
		this.id = id;
		this.inventoryNumber = inventoryNumber;
		this.orderedItems = orderedItems;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getInventoryNumber() {
		return inventoryNumber;
	}

	public void setInventoryNumber(String inventoryNumber) {
		this.inventoryNumber = inventoryNumber;
	}

	public List<OrderedItems> getOrderedItems() {
		return orderedItems;
	}

	public void setOrderedItems(List<OrderedItems> orderedItems) {
		this.orderedItems = orderedItems;
	}

	
}
