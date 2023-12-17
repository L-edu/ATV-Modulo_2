package com.btour.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SiteController {

	@GetMapping({ "/", "index" })
	public String home() {
		return "index";
	}

	@GetMapping({ "/destino" }) // nome que aparece na URL
	public String destino() {
		return "destino"; // nome da pagina destino.html
	}

	@GetMapping({ "/promocoes" })
	public String promocoes() {
		return "promo";
	}

	@GetMapping({ "/cadastro" })
	public String cadastro() {
		return "usuarios/create";
	}
}
