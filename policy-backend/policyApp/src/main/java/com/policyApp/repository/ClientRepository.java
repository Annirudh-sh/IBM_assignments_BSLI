package com.policyApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.policyApp.model.ClientEntity;

@Repository
public interface ClientRepository extends JpaRepository<ClientEntity, Integer> {

}