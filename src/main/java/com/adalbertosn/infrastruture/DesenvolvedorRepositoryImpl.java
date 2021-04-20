package com.adalbertosn.infrastruture;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.adalbertosn.domain.model.Desenvolvedor;
import com.adalbertosn.domain.repository.DesenvolvedorRepository;
@Component
public class DesenvolvedorRepositoryImpl implements DesenvolvedorRepository{
	@PersistenceContext
	private EntityManager manager;
	
	@Override
	public List<Desenvolvedor> listar() {
		return manager.createQuery("from Desenvolvedor", Desenvolvedor.class).getResultList();
		//return manager.createQuery("Select nome, sexo, idade, hobby, dataNascimento from Desenvolvedor", Desenvolvedor.class).getResultList();
	}
	
	@Override
	public Desenvolvedor buscar(Long id) {
		return manager.find(Desenvolvedor.class, id);
	}
	
	@Transactional
	@Override
	public Desenvolvedor salvar(Desenvolvedor desenvolvedor) {
		return manager.merge(desenvolvedor);
	}
	
	@Transactional
	@Override
	public void remover(Long desenvolvedorId) {
        Desenvolvedor desenvolvedor = buscar(desenvolvedorId);
		
		if (desenvolvedor == null) {
			throw new EmptyResultDataAccessException(1);
		}
		manager.remove(desenvolvedor);
	}

}
