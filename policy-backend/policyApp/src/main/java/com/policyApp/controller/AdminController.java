package com.policyApp.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.policyApp.model.Admin;
import com.policyApp.model.ClientEntity;
import com.policyApp.service.AdminService;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/api/policy")
@CrossOrigin(origins = "*")
public class AdminController {
	
	private final AdminService adminService;
	
	@GetMapping("/clients")
	public ResponseEntity<List<ClientEntity>> getAllClients() {
		List<ClientEntity> clientList = new ArrayList<>();
		clientList.addAll(adminService.getAllClients());
		if(clientList.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		
		return new ResponseEntity<>(clientList, HttpStatus.OK);
		
	}
	
	@GetMapping("/clients/{id}")
	public ResponseEntity<ClientEntity> getClientById(@PathVariable("id") int id) {
		Optional<ClientEntity> clientData = adminService.getClientById(id);
		return clientData.map(
				clientEntity -> new ResponseEntity<>(clientEntity, HttpStatus.OK))
				.orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND)
				);
	}
	
	@GetMapping("/admin/login")
	public boolean adminLogin(@RequestBody Admin admin) {
		if(adminService.validateAdmin(admin)) {
			return true;
		} else {
			return false;
		}
	}
	
	@GetMapping("/admin/login/{userId}/{password}")
	public ResponseEntity<?> adminLoginTest(@PathVariable("userId") String userId, @PathVariable("password") String password) {
		Admin admin = new Admin(userId, password);
		if(adminService.validateAdmin(admin)) {
			return ResponseEntity.ok("The user is validated");
		} else {
			return ResponseEntity.ok("Invalid User");
		}
	}
	
	@PostMapping("/clients")
	public ResponseEntity<ClientEntity> createUser(@RequestBody ClientEntity clientEntity) {
		adminService.createClient(clientEntity);
		return new ResponseEntity<>(clientEntity, HttpStatus.CREATED);
	}
	
	@PutMapping("clients/{id}")
	public ResponseEntity<ClientEntity> updateClientById(@PathVariable("id") int id, @RequestBody ClientEntity clientEntity) {
		
		ClientEntity client = adminService.updateClientById(id, clientEntity);
		if(client != null) {
			return new ResponseEntity<>(client, HttpStatus.OK);
		}
		else
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);	
	}
	
	@DeleteMapping("/clients/{id}")
	public ResponseEntity<?> deleteClientById(@PathVariable("id") int id) {
		adminService.deleteClientById(id);
		return ResponseEntity.ok("Deleted client [ " + id + " ] successfully...");
	}
	
	@DeleteMapping("/clients")
	public ResponseEntity<?> deleteAllClients() {
		adminService.deleteAll();
		return ResponseEntity.ok("All clients deleted successfully...");
	}

}
