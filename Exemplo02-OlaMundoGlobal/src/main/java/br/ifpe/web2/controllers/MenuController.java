package br.ifpe.web2.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MenuController {

	// http://localhost:8080/port
	@GetMapping("/port")
	public String exibirPortugues(Model model) {
		model.addAttribute("mensagem", "Olá Mundo");
		return "hello_world";
	}
	
	@GetMapping("/ing")
	public String exibirIngles(Model model) {
		model.addAttribute("mensagem", "Hello World");
		return "hello_world";
	}

	@GetMapping("/ale")
	public String exibirAlemao(Model model) {
		model.addAttribute("mensagem", "Hallo Welt");
		return "hello_world";
	}

}
