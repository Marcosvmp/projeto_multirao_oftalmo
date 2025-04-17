package com.multirao.oftalmo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.multirao.oftalmo.models.Client;

public interface ClientRepository extends JpaRepository<Client, Long> {

}
