package com.adalbertosn.domain.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
//import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.sun.istack.NotNull;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class Desenvolvedor {
	@EqualsAndHashCode.Include
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank
	@Size(max = 255)
	@Column(nullable=false,length = 255)
	private String nome;
	
	@NotBlank
	@Column(nullable=false,length = 1)
	private String sexo;
	
	@Max(value = 100)
	@Min(value = 10)
	@Column(nullable=false)
	private Integer idade;
	
	@NotBlank
	@Size(max = 255)
	@Column(nullable=false,length = 255)
	private String hobby;
	
	@NotNull
	//@Pattern(regexp = "/([0-9]){4}-([0-9]){2}-([0-9]){2}/")
	@Column(nullable=false)
	private LocalDate dataNascimento;
	
	
	
}
