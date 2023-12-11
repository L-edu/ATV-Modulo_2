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
		modelAndView.addObject("reservas", reservaRepository.findAll());
		modelAndView.addObject("reserva", new Reserva());
		return modelAndView;
	}

	@GetMapping("/{id}")
	public ModelAndView detalhes(@PathVariable Long id) {
		ModelAndView modelAndView = new ModelAndView("views/reservas/detalhes.html");
		modelAndView.addObject("reserva", reservaRepository.getReferenceById(id));
		return modelAndView;

	}

	@GetMapping("/cadastrar")
	public ModelAndView cadastrar() {
		ModelAndView modelAndView = new ModelAndView("views/reservas/cadastro.html");

		modelAndView.addObject("reserva", new Reserva());
		modelAndView.addObject("usuario", usuarioRepository.findAll());
		modelAndView.addObject("pacote", pacoteRepository.findByDestino("destino"));
		return modelAndView;
	}

	@GetMapping("/{id}/editar")
	public ModelAndView editar(@PathVariable Long id) {
		ModelAndView modelAndView = new ModelAndView("views/reservas/cadastro.html");

		modelAndView.addObject("reserva", reservaRepository.getReferenceById(id));
		modelAndView.addObject("usuario", usuarioRepository.findAll());
		modelAndView.addObject("pacote", pacoteRepository.findByDestino("destino"));

		return modelAndView;
	}

	@PostMapping({ "/cadastrar", "/{id}/editar" })
	public String salvar(Reserva reserva) {
		reservaRepository.save(reserva);

		return "redirect:/reservas";
	}

	@GetMapping("/{id}/excluir")
	public String excluir(@PathVariable Long id) {
		reservaRepository.deleteById(id);

		return "redirect:/reservas";
	}
}
