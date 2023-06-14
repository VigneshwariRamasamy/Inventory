package com.example.inventory.dto;

import java.util.List;



public class InventoryDTO {

	private Integer id;
	
	private String inventoryNumber;
	
	private List<OrderedItemsDTO> orderedItemsDTO;

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

	public List<OrderedItemsDTO> getOrderedItemsDTO() {
		return orderedItemsDTO;
	}

	public void setOrderedItemsDTO(List<OrderedItemsDTO> orderedItems) {
		this.orderedItemsDTO = orderedItems;
	}

	public InventoryDTO(Integer id, String inventoryNumber, List<OrderedItemsDTO> orderedItems) {
		
		this.id = id;
		this.inventoryNumber = inventoryNumber;
		this.orderedItemsDTO = orderedItems;
	}

	public InventoryDTO() {
		
	}
	
	
}
