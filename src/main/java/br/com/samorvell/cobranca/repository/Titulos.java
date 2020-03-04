package br.com.samorvell.cobranca.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.samorvell.cobranca.model.Titulo;

public interface Titulos extends JpaRepository<Titulo, Long>{
		//repositorio de acesso ao banco utilizando jpa
	
	public List<Titulo> findByDescricaoContaining(String descricao);
	//containing igual a like no select na base de dados na query
}
