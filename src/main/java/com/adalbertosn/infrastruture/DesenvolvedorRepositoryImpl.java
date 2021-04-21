package com.adalbertosn.infrastruture;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
//import javax.persistence.Query;
//import javax.persistence.Query;
import javax.persistence.TypedQuery;

//import org.springframework.boot.autoconfigure.data.jpa.JpaRepositoriesAutoConfiguration;
import org.springframework.dao.EmptyResultDataAccessException;
//import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.adalbertosn.domain.model.Desenvolvedor;
import com.adalbertosn.domain.repository.DesenvolvedorRepository;
@Component
public class DesenvolvedorRepositoryImpl /*extends JpaRepositories(Desenvolvedor,Id)*/ implements DesenvolvedorRepository{
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
	
	public Desenvolvedor findByNome(String nome) {
		TypedQuery<Desenvolvedor> query =  manager.createQuery("Select d from Desenvolvedor d where nome = :nome", Desenvolvedor.class);
		query.setParameter("nome", nome);
		List<Desenvolvedor> desenvolvedores = query.getResultList();
		if(desenvolvedores.size()>0) {
			return (Desenvolvedor)desenvolvedores.get(0);
		}else {
			return null;
		}
		
	}

}
