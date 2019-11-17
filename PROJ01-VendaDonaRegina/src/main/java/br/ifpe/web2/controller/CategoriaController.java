package br.ifpe.web2.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import br.ifpe.web2.model.Categoria;
import br.ifpe.web2.model.CategoriaDAO;

@Controller
public class CategoriaController {
	
	@Autowired
	private CategoriaDAO categoriaDAO;

	@GetMapping("/listarCategorias")
	public String exibirLista(Model model) {
		model.addAttribute("lista", categoriaDAO.findAll(Sort.by("nome")));
		return "categoria/categoria-list";
	}
	
	@GetMapping("/exibirFormCategoria")
	public String exibirForm(Categoria categoria) {
		return "categoria/categoria-form";
	}
	
	@PostMapping("/salvarCategoria")
	public String salvarCategoria(@Valid Categoria categoria, BindingResult br) {
		if (br.hasErrors()) {
			return exibirForm(categoria);
		}
		this.categoriaDAO.save(categoria);		
		return "redirect:/listarCategorias";
	}

	@GetMapping("/editarCategoria")
	public String editarCategoria(Integer codigo, Model model) {
		model.addAttribute("categoria", this.categoriaDAO.findById(codigo));
		return "categoria/categoria-form";
	}
	
	@GetMapping("/removerCategoria")
	public String removerCategoria(Integer codigo) {
		this.categoriaDAO.deleteById(codigo);
		return "redirect:/listarCategorias";
	}

}
