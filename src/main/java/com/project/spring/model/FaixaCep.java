package com.project.spring.model;

import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Data;

@Entity
public @Data class FaixaCep {

	@Id
	@GeneratedValue
	private Integer id;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "CODIGO_LOJA")
	private Loja codigoLoja;
	
	@Column(name = "FAIXA_INICIO")
	private Double faixaInicio;
	
	@Column(name = "FAIXA_FIM")
	private Double faixaFim;
}
