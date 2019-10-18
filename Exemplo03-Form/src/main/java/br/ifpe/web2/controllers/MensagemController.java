package br.ifpe.web2.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import br.ifpe.web2.model.Mensagem;

@Controller
public class MensagemController {

	@GetMapping("/exibirForm")
	public String exibirForm(Mensagem mensagem) {
		return "form-mensagem";
	}
	
	@PostMapping("/salvarMensagem")
	public String salvarMensagem(Mensagem mensagem) {
		System.out.println(mensagem);
		return "form-mensagem";
	}
}
