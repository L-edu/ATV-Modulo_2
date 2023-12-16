package com.btour.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.btour.model.Usuario;
import com.btour.repository.UsuarioRepository;

@Controller
@RequestMapping("/usuarios")
public class UsuarioController {

	@Autowired
	private UsuarioRepository usuarioRepository;

	@GetMapping
	public ModelAndView usuario() {
		ModelAndView modelAndView = new ModelAndView("views/usuarios/index.html");
		List<Usuario> usuarios = usuarioRepository.findAll();
		modelAndView.addObject("usuarios", usuarios);
		return modelAndView;
	}

	@GetMapping("/cadastrar")
	public ModelAndView cadastrar() {
		ModelAndView modelAndView = new ModelAndView("views/usuarios/create");
		modelAndView.addObject("usuarios", new Usuario());
		return modelAndView;
	}

	@PostMapping({"/cadastrar", "/{id}/editar"})
	public ModelAndView cadastrar(Usuario usuario) {
		ModelAndView modelAndView = new ModelAndView("redirect:/usuarios");
		usuarioRepository.save(usuario);
		return modelAndView;
	}

	@GetMapping("/{id}/excluir")
	public ModelAndView excluir(@PathVariable Long id) {
		ModelAndView modelAndView = new ModelAndView("redirect:/usuarios");
		usuarioRepository.deleteById(id);
		return modelAndView;
	}
}
