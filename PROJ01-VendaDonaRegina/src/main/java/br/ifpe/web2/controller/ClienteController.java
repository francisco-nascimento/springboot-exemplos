package br.ifpe.web2.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import br.ifpe.web2.model.Cliente;
import br.ifpe.web2.model.ClienteDAO;

@Controller
public class ClienteController {

	@Autowired
	private ClienteDAO clienteDAO;
	
	@GetMapping("/listarClientes")
	public String exibirLista(Model model) {
		model.addAttribute("lista", this.clienteDAO.findAll(Sort.by("nomeCompleto")));
		return "cliente/cliente-list";
	}
	
	@GetMapping("/exibirFormCliente")
	public String exibirForm(Cliente cliente) {
		return "cliente/cliente-form";
	}
	
	@PostMapping("/salvarCliente")
	public String salvarCliente(@Valid Cliente cliente, BindingResult br) {
		if (br.hasErrors()) {
			return this.exibirForm(cliente);
		}
		this.clienteDAO.save(cliente);
		return "redirect:/listarClientes";
	}

	@GetMapping("/editarCliente")
	public String editarCliente(Integer codigo, Model model) {
		model.addAttribute("cliente", this.clienteDAO.findById(codigo));
		return "cliente/cliente-form";
	}

	@GetMapping("/removerCliente")
	public String removerCliente(Integer codigo) {
		this.clienteDAO.deleteById(codigo);
		return "redirect:/listarClientes";
	}

}
