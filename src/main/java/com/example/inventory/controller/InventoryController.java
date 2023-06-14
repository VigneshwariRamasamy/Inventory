package com.example.inventory.controller;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.inventory.dto.InventoryDTO;
import com.example.inventory.entity.Inventory;
import com.example.inventory.service.InventoryService;

@RestController
@RequestMapping("/api/inventory")
public class InventoryController {
	
private static final Logger logger = LoggerFactory.getLogger(InventoryController.class);
	
	
	@Autowired
	private InventoryService service;
	

	@PostMapping("/add")
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<String> registerUser(@RequestBody InventoryDTO inventoryDTO) {		
	
			service.saveusers(inventoryDTO);
//		
		return new ResponseEntity<>("Products ordered successfully", HttpStatus.OK);
//		}
//		catch (Exception e) {
//			System.out.println("jii");
//		}
		

	}
	@GetMapping("/get")
	@ResponseStatus(HttpStatus.OK)
	public List<Inventory> list() {
		return service.getAll();
	}

	@GetMapping("/product/{id}")
	@ResponseStatus(HttpStatus.OK)
	public Optional<Inventory> findRegistrationById(@PathVariable Integer id) {
		return service.getuserById(id);
	}

	@DeleteMapping
	@ResponseStatus(HttpStatus.OK)
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	@ResponseBody
	public String deleteUserdetails(@PathVariable Integer id) {
		service.deleteUser(id);
		return "student has been deleted successfully";
	}

	@PutMapping("/update")
	public String updateRegistration(@RequestBody Inventory inventory) {
		service.updateuser(inventory);
		return "User details updated successfully";
	}

}
