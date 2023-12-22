package com.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.backend.model.Client;
import com.backend.repository.ClientRepository;

@CrossOrigin(origins = "http://localhost:3000")// para exibição na API
@RestController
public class ClienteController {

	@Autowired
	private ClientRepository clientRepository;

	// get all clients rest api
	@GetMapping("/clients")
	public List<Client> getAllClients() {
		return clientRepository.findAll();

	}

	// get client by id rest api
	@GetMapping("/clients/{id}")
	public Client getClientById(@PathVariable Long id) {
		return clientRepository.findById(id).get();
	}

	// create client rest api
	@PostMapping("/clients")
	public Client createClient(@RequestBody Client client) {
		return clientRepository.save(client);
	}

	// update client rest api
	@PutMapping("/clients/{id}")
	public Client updateClient(@PathVariable Long id, @RequestBody Client clientDetails) {
		Client client = clientRepository.findById(id).get();

		client.setName(clientDetails.getName());
		client.setEmail(clientDetails.getEmail());
		client.setCpf(clientDetails.getCpf());
		client.setRenda(clientDetails.getRenda());

		return clientRepository.save(client);
	}

	// delete client rest api
	@DeleteMapping("/clients/{id}")
	public void deleteClient(@PathVariable Long id) {
		clientRepository.deleteById(id);
	}
}
