package br.com.samorvell.cobranca.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import br.com.samorvell.cobranca.model.StatusTitulo;
import br.com.samorvell.cobranca.model.Titulo;
import br.com.samorvell.cobranca.repository.Titulos;

//Camada de serivços, onde entram todas as regras de negocio
@Service
public class CadastroTituloService {

	@Autowired
	private Titulos titulos;

	public void salvar(Titulo titulo) {
		try {
			titulos.save(titulo);
		} catch (DataIntegrityViolationException e) { //exception de baixo nivel voltado para banco de dados, foi mudado para IllegalArgumentException para poder subir o nivel e passar para tela
			throw new IllegalArgumentException("Formado de data inválido!");
		}
	}

	public void excluir(Long codigo) {
		titulos.deleteById(codigo);

	}

	public String receber(Long codigo) {
		Optional<Titulo> tituloOptional = titulos.findById(codigo);
		
		Titulo titulo = null;
		if(tituloOptional.isPresent()) {
			
			//Essa linha tira o objeto (nesse caso, o titulo) do encapsulamento do Optional
			titulo = tituloOptional.get();
			
			titulo.setStatus(StatusTitulo.RECEBIDO);
			titulos.save(titulo);
			
			return StatusTitulo.RECEBIDO.getDescricao();
		}
		return null;
		
		
		
		
	}

}
