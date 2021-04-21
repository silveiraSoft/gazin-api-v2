package com.adalbertosn.domain.repository;

import java.util.List;

//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.stereotype.Repository;

import com.adalbertosn.domain.model.Desenvolvedor;
/*
@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long>{

}
*/
public interface DesenvolvedorRepository{
	List<Desenvolvedor> listar();
	Desenvolvedor buscar(Long id);
	Desenvolvedor salvar(Desenvolvedor desenvolvedor);
	void remover(Long desenvolvedorId);
	Desenvolvedor findByNome(String nome);
}
