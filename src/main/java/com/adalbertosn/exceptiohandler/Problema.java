package com.adalbertosn.exceptiohandler;

import java.time.LocalDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
@JsonInclude(Include.NON_NULL)
public class Problema {
	private Integer status;
	private LocalDateTime dataHora;
	private String titulo;
	private List<Campo> campos;
			
	@Getter
	@Setter
	public static class Campo {
		
		private String nome;
		private String mensagem;
		
		public Campo(String nome2, String mensagem) {
			// TODO Auto-generated constructor stub
			//super();
			this.nome = nome2;
			this.mensagem = mensagem;
		}
		
	}
}
