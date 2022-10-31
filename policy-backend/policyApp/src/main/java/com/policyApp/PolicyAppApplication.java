package com.policyApp;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.annotation.PostConstruct;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.policyApp.model.Admin;
import com.policyApp.model.ClientEntity;
import com.policyApp.repository.AdminRepository;
import com.policyApp.repository.ClientRepository;

import lombok.AllArgsConstructor;

@SpringBootApplication
@AllArgsConstructor
public class PolicyAppApplication {
	
	private final ClientRepository clientRepository;
	private final AdminRepository adminRepository;

	public static void main(String[] args) {
		SpringApplication.run(PolicyAppApplication.class, args);
	}
	
	@PostConstruct
	public void loadData() {
		List<ClientEntity> list = Stream.of(
				new ClientEntity("Taylor", "Swift", "taylor@swift.com", 22, "F", 1110001100, "220958"),
				new ClientEntity("Sam", "Smith", "sam@smith.com", 35, "M", 1010001199, "006789"),
				new ClientEntity("Stephen", "Curry", "steph@curry.com", 32, "M", 1210001100, "991176"),
				new ClientEntity("Demi", "Lovato", "demi@lovato.com", 26, "F", 1981101100, "821976")
		).collect(Collectors.toList());
		
		clientRepository.saveAll(list);
	}
	
	@PostConstruct
	public void loadAdmin() {
		List<Admin> list = Stream.of(
				new Admin("admin", "admin"),
				new Admin("admin1", "1234"),
				new Admin("admin2", "5678"),
				new Admin("admin3", "12345")
				).collect(Collectors.toList());
		
		adminRepository.saveAll(list);
	}

}
