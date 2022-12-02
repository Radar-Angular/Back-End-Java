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

import com.gama.academy.radarfarma.model.Pedido;
import com.gama.academy.radarfarma.repository.PedidoRepository;

@RestController
@RequestMapping("/pedidos")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class PedidoController {

	@Autowired
	private PedidoRepository pedidoRepository;

	@GetMapping("/all")
	public ResponseEntity<List<Pedido>> getAll() {
		return ResponseEntity.ok(pedidoRepository.findAll());
	}

	@GetMapping("/{id}")
	public ResponseEntity<Pedido> getPedidoById(@PathVariable long id) {
		return pedidoRepository.findById(id).map(resposta -> ResponseEntity.ok(resposta))
				.orElse(ResponseEntity.notFound().build());

	}

	@PostMapping
	public ResponseEntity<Pedido> postPedido(@Valid @RequestBody Pedido pedido) {
		return ResponseEntity.status(HttpStatus.CREATED).body(pedidoRepository.save(pedido));
	}
	
	@PutMapping
	public ResponseEntity<Pedido> putPedido(@Valid @RequestBody Pedido pedido) {
		
		 return pedidoRepository.findById(pedido.getId())
				.map(atualizar -> ResponseEntity.status(HttpStatus.CREATED).body(pedidoRepository.save(pedido)))
				.orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());

	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deletePedido(@PathVariable long id) {
		return pedidoRepository.findById(id)
				.map(resposta -> {
					pedidoRepository.deleteById(id);
					return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
				})
				.orElse(ResponseEntity.notFound().build());
	}

}
