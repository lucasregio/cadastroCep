package com.project.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.spring.model.Loja;

public interface LojaRepository extends JpaRepository<Loja, Integer> {
	
	public Loja findByCodigoLoja(String codigoLoja);

}
