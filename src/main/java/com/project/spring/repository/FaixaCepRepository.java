package com.project.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.project.spring.model.FaixaCep;

public interface FaixaCepRepository extends JpaRepository<FaixaCep, Integer> {
	@Query(value = "SELECT * FROM FAIXA_CEP where ?1  and ?2 between FAIXA_INICIO and FAIXA_FIM;", nativeQuery = true)
	FaixaCep verificaFaixas(double inicio, double fim);
}
