package com.example.inventory.service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.example.inventory.dto.InventoryDTO;
import com.example.inventory.dto.OrderedItemsDTO;
import com.example.inventory.dto.StockStatus;
import com.example.inventory.entity.Inventory;
import com.example.inventory.entity.OrderedItems;
import com.example.inventory.repository.InventoryRepository;
@Service

public class InventoryService {
	
	@Autowired
	private InventoryRepository inventoryRepository;
	
	@Autowired
	private WebClient webClient;

	public void saveusers(InventoryDTO inventoryDTO) {
		Inventory inventory = new Inventory();
		inventory.setId(inventoryDTO.getId());
		inventory.setInventoryNumber(inventoryDTO.getInventoryNumber());
		List<OrderedItems> orderedItemsDto=inventoryDTO.getOrderedItemsDTO()
				.stream()
				.map(this::orderList)
				.toList();				
		inventory.setOrderedItems(orderedItemsDto);
		
		
		List<String> skuCode=inventory.getOrderedItems()
				.stream()
				.map(t -> t.getSkuCode()).toList();
		
		//call stock service
		StockStatus[] result=webClient.get().uri("http://localhost:8083/api/stock",
				uriBuilder->uriBuilder.queryParam("skuCode", skuCode).build())
				.retrieve().bodyToMono(StockStatus[].class)
				.block(); 
		boolean response=Arrays.stream(result).allMatch(stocks->stocks.isInStock());
		
	if(response) {
		inventoryRepository.save(inventory);
	}
	else {
		throw new IllegalArgumentException("Product is not in stock,Please try again later");
	}
	}

	private OrderedItems orderList(OrderedItemsDTO orderedItemsDto) {
		OrderedItems orderedItems=new OrderedItems();	
		orderedItems.setSkuCode(orderedItemsDto.getSkuCode());
		orderedItems.setPrice(orderedItemsDto.getPrice());
		orderedItems.setQuantity(orderedItemsDto.getQuantity());
		return orderedItems;
		
	}

	public List<Inventory> getAll() {
		return inventoryRepository.findAll();
	}

	public Optional<Inventory> getuserById(Integer id) {
		return inventoryRepository.findById(id);
	}

	public Inventory updateuser(Inventory purchase) {
		return inventoryRepository.saveAndFlush(purchase);
	}

	public void deleteUser(Integer id) {
		inventoryRepository.deleteById(id);
	}
}
