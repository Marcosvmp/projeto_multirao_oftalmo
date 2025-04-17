package com.multirao.oftalmo.controllers;

import java.util.List;
import java.util.Optional;

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
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import com.multirao.oftalmo.models.Client;
import com.multirao.oftalmo.repository.ClientRepository;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping(value = "/client")
public class ClientController {
    @Autowired
    ClientRepository clientRepository;

    @PostMapping
    public String save(@RequestBody Client client)

    {
        clientRepository.save(client);
        return "SALVO COM SUCESSO!";
    }

    @GetMapping
    public List<Client> findAll() {
        List<Client> result = clientRepository.findAll();
        return result;
    }

    @GetMapping(value = "/{id}")
    public Client findById(@PathVariable Long id) {
        Client result = clientRepository.findById(id).get();
        return result;
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        clientRepository.deleteById(id);
    }
}
