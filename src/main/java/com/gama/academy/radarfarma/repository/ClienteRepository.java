package com.gama.academy.radarfarma.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gama.academy.radarfarma.model.Cliente;

@Repository
public interface ClienteRepository  extends JpaRepository<Cliente, Long>{
	
	public List<Cliente> findAllByNomeContainingIgnoreCase(String nome);

}
