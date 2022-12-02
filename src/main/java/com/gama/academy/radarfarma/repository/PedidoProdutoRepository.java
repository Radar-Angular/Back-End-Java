package com.gama.academy.radarfarma.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gama.academy.radarfarma.model.PedidoProduto;

@Repository
public interface PedidoProdutoRepository extends JpaRepository<PedidoProduto, Long> {

}
