package com.gama.academy.radarfarma.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
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

import com.gama.academy.radarfarma.model.Cliente;
import com.gama.academy.radarfarma.repository.ClienteRepository;

@RestController
@RequestMapping("/clientes")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ClienteController {
	
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	
	@GetMapping("/all")
	public ResponseEntity<List<Cliente>> getAllClientes() {
		return ResponseEntity.ok(clienteRepository.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Cliente> getClienteById(@PathVariable Long id) {

		return clienteRepository.findById(id).map(response -> ResponseEntity.ok(response))
				.orElse(ResponseEntity.notFound().build());
	}
	
	@GetMapping("/nome/{nome}")
	public ResponseEntity<List<Cliente>> getClienteByNome(@Valid @PathVariable String nome) {
		return ResponseEntity.ok(clienteRepository.findAllByNomeContainingIgnoreCase(nome));
	}
	
	@PostMapping
	public ResponseEntity<Cliente> postCliente(@Valid @RequestBody Cliente cliente){
		return ResponseEntity.status(HttpStatus.CREATED).body(clienteRepository.save(cliente));
	}
	
	@PutMapping
	public ResponseEntity<Cliente> putCliente(@Valid @RequestBody Cliente cliente ){
		return clienteRepository.findById(cliente.getId())
				.map(response -> ResponseEntity.ok().body(clienteRepository.save(cliente)))
				.orElse(ResponseEntity.notFound().build());
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> deleteProduto(@PathVariable Long id) {
		return clienteRepository.findById(id)
				.map(resposta -> {
					clienteRepository.deleteById(id);
					return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
				})
				.orElse(ResponseEntity.notFound().build());
	}
	
	

}
