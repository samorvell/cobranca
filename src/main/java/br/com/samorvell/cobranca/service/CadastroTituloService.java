package br.com.samorvell.cobranca.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import br.com.samorvell.cobranca.model.Titulo;
import br.com.samorvell.cobranca.repository.Titulos;

@Service
public class CadastroTituloService {

	@Autowired
	private Titulos titulos;

	public void salvar(Titulo titulo) {
		try {
			titulos.save(titulo);
		} catch (DataIntegrityViolationException e) {
			throw new IllegalArgumentException("Formado de data inválido!");
		}
	}

	public void excluir(Long codigo) {
		titulos.deleteById(codigo);

	}

}
