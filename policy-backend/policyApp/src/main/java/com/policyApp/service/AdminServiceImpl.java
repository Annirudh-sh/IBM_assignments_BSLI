package com.policyApp.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.policyApp.exception.ClientNotFoundException;
import com.policyApp.model.Admin;
import com.policyApp.model.ClientEntity;
import com.policyApp.repository.AdminRepository;
import com.policyApp.repository.ClientRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class AdminServiceImpl implements AdminService {
	
	private final ClientRepository clientRepository;
	private final AdminRepository adminRepository;

	@Override
	public List<ClientEntity> getAllClients() {
		List<ClientEntity> clientList = clientRepository.findAll();
		if(clientList.isEmpty()) {
			throw new ClientNotFoundException("No Client Found... [ Please add clients first]");
		}

		return clientList;
	}

	@Override
	public void createClient(ClientEntity clientEntity) {
		clientRepository.save(new ClientEntity(
				clientEntity.getFirstName(),
				clientEntity.getLastName(),
				clientEntity.getEmail(), 
				clientEntity.getAge(),
				clientEntity.getGender(), 
				clientEntity.getContactNo(),
				UUID.randomUUID().toString())
				);

	}

	@Override
	public Optional<ClientEntity> getClientById(int clientId) {
		Optional<ClientEntity> client = clientRepository.findById(clientId);
		if(!client.isPresent()) {
			throw new ClientNotFoundException("No client found with id: [ " + clientId + " ], Please enter correct ID");
		}
		
		return client;
	}

	@Override
	public ClientEntity updateClientById(int clientId, ClientEntity clientEntity) {
		
		Optional<ClientEntity> clientData = clientRepository.findById(clientId);
		if(!clientData.isPresent()) {
			throw new ClientNotFoundException("No client found with id: [ " + clientId + " ], Please enter correct ID");
		}
		ClientEntity client = clientData.get();
		client.setFirstName(clientEntity.getFirstName());
		client.setLastName(clientEntity.getLastName());
		client.setEmail(clientEntity.getEmail());
		client.setAge(clientEntity.getAge());
		client.setGender(clientEntity.getGender());
		client.setContactNo(clientEntity.getContactNo());
		client.setPolicyNo(clientEntity.getPolicyNo());
		
		return clientRepository.save(client);
	}

	@Override
	public void deleteClientById(int clientId) {
		Optional<ClientEntity> clientData = clientRepository.findById(clientId);
		if(!clientData.isPresent()) {
			throw new ClientNotFoundException("No client found with id: [ " + clientId + " ], Please enter correct ID");
		}
		clientRepository.deleteById(clientId);

	}

	@Override
	public void deleteAll() {
		clientRepository.deleteAll();

	}

	@Override
	public boolean validateAdmin(Admin admin) {
		final Admin user = adminRepository.findByUserName(admin.getUserName());
		
		if(user != null && user.getPassword().equals(admin.getPassword())) {
			return true;
		} else {
			return false;
		}
	}

}
