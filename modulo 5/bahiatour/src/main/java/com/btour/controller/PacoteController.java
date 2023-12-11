package com.btour.controller;

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
		modelAndView.addObject("pacotes",pacoteRepository.findAll());
		modelAndView.addObject("pacote", new Pacote());
		return modelAndView;
	}

	@PostMapping("/cadastrar")
	public String cadastrar(Pacote pacote) {
		pacoteRepository.save(pacote);
		return "redirect:/pacotes";
	}
	
	@GetMapping("/{id}/excluir")
	public String excluir(@PathVariable Long id) {
		pacoteRepository.deleteById(id);
		return "redirect:/pacotes";
	}
}
