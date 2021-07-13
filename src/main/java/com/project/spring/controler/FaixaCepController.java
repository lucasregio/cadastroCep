package com.project.spring.controler;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.project.spring.model.FaixaCep;
import com.project.spring.model.Loja;
import com.project.spring.repository.FaixaCepRepository;
import com.project.spring.service.FaixaCepService;
import com.project.spring.service.LojaService;
import com.project.spring.util.Range;

@Controller
@RestController
@RequestMapping("/cadastro-cep")
public class FaixaCepController {

	@Autowired
	private FaixaCepRepository faixaCepRepository;

	@Autowired
	private FaixaCepService faixaCepService;

	@Autowired
	private LojaService lojaService;

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> salvarFaixaCep(@RequestBody FaixaCep faixaCep) {
		List<FaixaCep> listFaixaCepBanco = faixaCepRepository.findAll();
		boolean includes = false;

		FaixaCep faixaExistente = faixaCepService.verificaFaixas(faixaCep);
		if(faixaExistente != null) {
			System.out.println("Filial existente mais próxima : " + faixaExistente.getCodigoLoja().getCodigoLoja());
		}
		
		for (FaixaCep faixaBD : listFaixaCepBanco) {
			if(faixaExistente == null) {
				includes = (faixaCep.getFaixaInicio() <= faixaBD.getFaixaInicio())
						&& (faixaCep.getFaixaFim() >= faixaBD.getFaixaFim());
				if(includes) {
					salvarFaixa(faixaCep);
				}
			}
		}
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(faixaCep.getId())
				.toUri();

		return ResponseEntity.created(uri).build();
	}

	public Loja buscarLoja(Loja codigoLoja) {

		lojaService.findStoreByCod(codigoLoja.getCodigoLoja());

		return codigoLoja;
	}

	private void salvarFaixa(FaixaCep faixaCep) {
		faixaCep = faixaCepService.salvarFaixa(faixaCep);
	}
}
