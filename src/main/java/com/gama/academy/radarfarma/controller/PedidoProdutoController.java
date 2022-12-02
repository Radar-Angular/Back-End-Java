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

import com.gama.academy.radarfarma.model.PedidoProduto;
import com.gama.academy.radarfarma.repository.PedidoProdutoRepository;

@RestController
@RequestMapping("/pedidoProdutos")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class PedidoProdutoController {

	
	@Autowired
	private PedidoProdutoRepository pedidoProdutoRepository;
	
	
	@GetMapping
	public ResponseEntity<List<PedidoProduto>> getAll() {
		return ResponseEntity.ok(pedidoProdutoRepository.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<PedidoProduto> getById(@PathVariable long id) {
		return pedidoProdutoRepository.findById(id)
				.map(resposta -> ResponseEntity.ok(resposta))
				.orElse(ResponseEntity.notFound().build());

	}

	@PostMapping
	public ResponseEntity<PedidoProduto> post(@Valid @RequestBody PedidoProduto pedidoProduto) {
		return ResponseEntity.status(HttpStatus.CREATED).body(pedidoProdutoRepository.save(pedidoProduto));
	}

	@PutMapping
	public ResponseEntity<PedidoProduto> put (@Valid @RequestBody PedidoProduto pedidoProduto) {
		
		 return pedidoProdutoRepository.findById(pedidoProduto.getId())
				.map(atualizar -> ResponseEntity.status(HttpStatus.CREATED).body(pedidoProdutoRepository.save(pedidoProduto)))
				.orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());

	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> delete(@PathVariable long id) {
		return pedidoProdutoRepository.findById(id)
				.map(resposta -> {
					pedidoProdutoRepository.deleteById(id);
					return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
				})
				.orElse(ResponseEntity.notFound().build());
	}
	
	
	
}
