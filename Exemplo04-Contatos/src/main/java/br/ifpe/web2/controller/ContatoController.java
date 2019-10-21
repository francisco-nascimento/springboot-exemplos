package br.ifpe.web2.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import br.ifpe.web2.model.Contato;

@Controller
public class ContatoController {
	
	private List<Contato> contatos = new ArrayList<>();

	@GetMapping("/exibirContato")
	public String exibirForm(Contato contato) {
		return "contatos-form";
	}
	
	@PostMapping("/salvarContato")
	public String salvarContato(Contato contato) {
		this.contatos.remove(contato);
		this.contatos.add(contato);
		System.out.println(contato);
		return "redirect:/listarContatos";
	}
	
	@GetMapping("/listarContatos")
	public String listarContatos(Model model) {
		model.addAttribute("lista", contatos);
		return "contatos-list";
	}
	
	@GetMapping("/removerContato")
	public String removerContato(String email) {
		Contato contatoParaRemover = null;
		for(Contato cont : this.contatos) {
			if(cont.getEmail().equals(email)) {
				contatoParaRemover = cont;
			}
		}
		if (contatoParaRemover != null) {
			this.contatos.remove(contatoParaRemover);
		}
		return "redirect:/listarContatos";
	}
	
	@GetMapping("/editarContato")
	public String editarContato(String email, Model model) {
		Contato contatoParaEditar = null;
		for(Contato cont : this.contatos) {
			if(cont.getEmail().equals(email)) {
				contatoParaEditar = cont;
			}
		}
		model.addAttribute("contato", contatoParaEditar);
		return "contatos-form";
	}
}
