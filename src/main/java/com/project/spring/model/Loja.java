package com.project.spring.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class Loja {

	@Id
	@GeneratedValue
	private Integer id;
	
	@Column(name = "CODIGO_LOJA")
	private String codigoLoja;
}
