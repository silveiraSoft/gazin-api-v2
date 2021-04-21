package com.adalbertosn.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.adalbertosn.domain.exception.EntidadeEmUsoException;
import com.adalbertosn.domain.exception.EntidadeNaoEncontradaException;
import com.adalbertosn.domain.exception.NegocioException;
import com.adalbertosn.domain.model.Desenvolvedor;
import com.adalbertosn.domain.repository.DesenvolvedorRepository;
@Service
public class CadastroDesenvolvedorService {
	@Autowired
	private DesenvolvedorRepository desenvolvedorRepository;
	
	public Desenvolvedor salvar(Desenvolvedor desenvolvedor) {
		 
		
		//try {
			//Desenvolvedor desenvolvedorExistente = desenvolvedorRepository.findByNome(desenvolvedor.getNome());
			Desenvolvedor desenvolvedorExistente = desenvolvedorRepository.findByNome(desenvolvedor.getNome());
			
			//System.out.print(desenvolvedorExistente);
			//return desenvolvedorRepository.salvar(desenvolvedor);
			
			if(desenvolvedorExistente != null && !desenvolvedorExistente.equals(desenvolvedor)) {
				throw new NegocioException("Já existe um desenvolvedro cadastrado com este nome.");
			}
			
			return desenvolvedorRepository.salvar(desenvolvedor);
		/*
		}catch(Exception e) {
			throw new NegocioException("Já existe um desenvolvedro cadastrado com este nome.");
		}*/
	}
	
	public void excluir(Long desenvolvedorId) {
		try {
			desenvolvedorRepository.remover(desenvolvedorId);
			
		} catch (EmptyResultDataAccessException e) {
			throw new EntidadeNaoEncontradaException(
				String.format("Não existe um cadastro de desenvolvedor com código %d", desenvolvedorId));
		//
		} catch (DataIntegrityViolationException e) {
			throw new EntidadeEmUsoException(
				String.format("Desenvolvedor de código %d não pode ser removida, pois está em uso", desenvolvedorId));
		}
	}
}
