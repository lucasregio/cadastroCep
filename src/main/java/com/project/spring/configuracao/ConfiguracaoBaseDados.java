package com.project.spring.configuracao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.project.spring.model.FaixaCep;
import com.project.spring.model.Loja;
import com.project.spring.repository.FaixaCepRepository;
import com.project.spring.service.LojaService;

@Configuration
@Profile("desenvolvimento")
public class ConfiguracaoBaseDados {

	@Autowired
	private FaixaCepRepository faixaCepRepository;
	
	@Autowired
	private LojaService lojaService;

	@Bean
	CommandLineRunner carregarBanco() {
		return args -> {

			FaixaCep cep = new FaixaCep();
			cep.setFaixaInicio(100D);
			cep.setFaixaFim(200D);
			Loja loja = new Loja();
			loja.setCodigoLoja("LOJA_PINHEIROS");

			cep.setCodigoLoja(loja);
			faixaCepRepository.save(cep);

			FaixaCep cep1 = new FaixaCep();
			cep1.setFaixaInicio(201D);
			cep1.setFaixaFim(300D);
			Loja loja1 = new Loja();
			loja1.setCodigoLoja("LOJA_JARDINS");

			cep1.setCodigoLoja(loja1);
			faixaCepRepository.save(cep1);
		};
	}

	
	
}
