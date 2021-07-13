package com.project.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.spring.model.FaixaCep;
import com.project.spring.repository.FaixaCepRepository;

@Service
public class FaixaCepService {

	@Autowired
	private FaixaCepRepository faixaCepRepository;
	
	public FaixaCep salvarFaixa(FaixaCep faixaCep) {
		return faixaCepRepository.save(faixaCep);
	}

	public FaixaCep verificaFaixas(FaixaCep faixaCep) {
		return faixaCepRepository.verificaFaixas(faixaCep.getFaixaInicio(), faixaCep.getFaixaFim());
	}
}
