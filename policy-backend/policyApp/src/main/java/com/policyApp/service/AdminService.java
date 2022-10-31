package com.policyApp.service;

import java.util.List;
import java.util.Optional;

import com.policyApp.model.Admin;
import com.policyApp.model.ClientEntity;

public interface AdminService {
	
	List<ClientEntity> getAllClients();
	void createClient(ClientEntity clientEntity);
	Optional<ClientEntity> getClientById(int clientId);
	ClientEntity updateClientById(int clientId, ClientEntity clientEntity);
	void deleteClientById(int clientId);
	void deleteAll();
	boolean validateAdmin(Admin admin);

}
