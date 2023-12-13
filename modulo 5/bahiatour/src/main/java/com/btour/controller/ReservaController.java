package com.btour.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
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

	@PostMapping("/cadastrar")
	public String cadastrar(@Validated @ModelAttribute("reservas") Reserva reserva, BindingResult result,
			ModelMap model) {

		if (result.hasErrors()) {
			return "reservas";
		}

		model.addAttribute("id", reserva.getId());
		model.addAttribute("dataInicio", reserva.getDataInicio());
		model.addAttribute("dataFim", reserva.getDataFim());
		model.addAttribute("qtdPessoa", reserva.getQtdPessoa());
		model.addAttribute("usuario", reserva.getUsuario());
		model.addAttribute("pacote", reserva.getPacote());

		reservaRepository.save(reserva);
		return "redirect:/reservas";
	}

	@GetMapping("/{id}/excluir")
	public String excluir(@PathVariable Long id) {
		reservaRepository.deleteById(id);

		return "redirect:/compras";
	}
}
