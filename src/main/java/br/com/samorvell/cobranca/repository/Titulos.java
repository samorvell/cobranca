package br.com.samorvell.cobranca.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.samorvell.cobranca.model.Titulo;

public interface Titulos extends JpaRepository<Titulo, Long>{

}
