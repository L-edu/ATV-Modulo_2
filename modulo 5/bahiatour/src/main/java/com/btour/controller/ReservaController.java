package com.btour.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.btour.model.Reserva;
import com.btour.repository.PacoteRepository;
import com.btour.repository.ReservaRepository;
import com.btour.repository.UsuarioRepository;

@Controller
@RequestMapping("/reservas")
public class ReservaController {

	@Autowired
	private UsuarioRepository usuarioRepository;
	@Autowired
	private PacoteRepository pacoteRepository;
	@Autowired
	private ReservaRepository reservaRepository;

	@GetMapping
	public ModelAndView reserva() {

		ModelAndView modelAndView = new ModelAndView("views/reservas/index.html");
		modelAndView.addObject("listaUsuario", usuarioRepository.findAll());
		modelAndView.addObject("listaPacote", pacoteRepository.findAll());
		modelAndView.addObject("reservas", reservaRepository.findAll());
		modelAndView.addObject("reserva", new Reserva());
		return modelAndView;
	}

	@GetMapping("/cadastrar")
	public ModelAndView cadastrar() {
		ModelAndView modelAndView = new ModelAndView("views/reservas/create");
		modelAndView.addObject("reserva", new Reserva());
		modelAndView.addObject("listaUsuario", usuarioRepository.findAll());
		modelAndView.addObject("listaPacote", pacoteRepository.findAll());
		return modelAndView;
	}

	@PostMapping({"/cadastrar", "/{id}/editar"})
	public ModelAndView cadastrar(Reserva reserva) {
		reservaRepository.save(reserva);
		ModelAndView modelAndView = new ModelAndView("redirect:/reservas");
		return modelAndView;
	}

	@GetMapping("/{id}/excluir")
	public ModelAndView excluir(@PathVariable Long id) {
		ModelAndView modelAndView = new ModelAndView("redirect:/reservas");
		reservaRepository.deleteById(id);
		return modelAndView;
	}
}
