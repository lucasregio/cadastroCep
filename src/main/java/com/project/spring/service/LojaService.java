package com.project.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.spring.model.Loja;
import com.project.spring.repository.LojaRepository;

@Service
public class LojaService {

	@Autowired
	private LojaRepository lojaRepository;
	
	public Loja salvar(Loja loja) {
		return lojaRepository.save(loja);
	}

	public Loja findStoreByCod(String codigoLoja) {
		return lojaRepository.findByCodigoLoja(codigoLoja);
	}
}
