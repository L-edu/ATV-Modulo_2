package com.btour.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.btour.model.Pacote;
import com.btour.repository.PacoteRepository;

@Controller
@RequestMapping("/pacotes")
public class PacoteController {
	
	@Autowired
	private PacoteRepository pacoteRepository;
	
	
	@GetMapping
	public ModelAndView pacote() {
		ModelAndView modelAndView = new ModelAndView("views/pacotes/index.html");
		List<Pacote> pacotes = pacoteRepository.findAll();
		modelAndView.addObject("pacotes", pacotes);
		return modelAndView;
	}

	@GetMapping("/cadastrar")
	public ModelAndView cadastrar() {
		ModelAndView modelAndView = new ModelAndView("views/pacotes/create");
		modelAndView.addObject("pacotes", new Pacote());
		return modelAndView;
	}

	@PostMapping({"/cadastrar", "/{id}/editar"})
	public ModelAndView cadastrar(Pacote pacote) {
		ModelAndView modelAndView = new ModelAndView("redirect:/pacotes");
		pacoteRepository.save(pacote);
		return modelAndView;
	}

	@GetMapping("/{id}/excluir")
	public ModelAndView excluir(@PathVariable Long id) {
		ModelAndView modelAndView = new ModelAndView("redirect:/pacotes");
		pacoteRepository.deleteById(id);
		return modelAndView;
	}
}
