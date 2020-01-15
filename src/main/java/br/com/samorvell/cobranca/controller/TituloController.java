package br.com.samorvell.cobranca.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.com.samorvell.cobranca.model.StatusTitulo;
import br.com.samorvell.cobranca.model.Titulo;
import br.com.samorvell.cobranca.repository.Titulos;

@Controller
@RequestMapping("/titulos")
public class TituloController {
	
	
	@Autowired //injesão de dependencias para autoamticamente criar as tabelas na base
	private Titulos titulos;
	
	
	//@@RequestMapping para efetuar as solicitações de request e disptchers para o navegador
	@RequestMapping("/novo")
	public ModelAndView novo() {
		ModelAndView mv = new ModelAndView("cadastrotitulo");		 
		return mv;
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView salvar(Titulo titulo) {
			titulos.save(titulo);		
			ModelAndView mv = new ModelAndView("cadastrotitulo");
			mv.addObject("mensagem", "Título salvo com sucesso!");
			return mv;
	}
	
	@RequestMapping
	public ModelAndView  pesquisar() {
		List<Titulo>todosTitulos = titulos.findAll();
		ModelAndView mv = new ModelAndView("PesquisaTitulos");
		mv.addObject("titulos", todosTitulos);
		return mv;
	}
	
	@ModelAttribute("todosStatusTitulo")
	public List<StatusTitulo> todosStatusTitulo(){
		return Arrays.asList(StatusTitulo.values());
	}
	

}
