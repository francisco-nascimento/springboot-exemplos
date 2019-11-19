package br.ifpe.web2.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import br.ifpe.web2.model.Produto;
import br.ifpe.web2.model.ProdutoDAO;

@Controller
public class VendaController {

	@Autowired
	private ProdutoDAO produtoDAO;
	
	@GetMapping("/exibirProdutosVenda")
	public String exibirProdutos(Model model) {
		PageRequest page = PageRequest.of(0, 15);
		model.addAttribute("listaProdutos", this.produtoDAO.findAll(page));
//		model.addAttribute("listaProdutos", this.produtoDAO.findByPrecoBetween(1, 3));
		return "vendas/produto-search";
	}
	
	@PostMapping("/pesquisarProdutos")
	public String pesquisarProdutos(String nomeProduto, Model model) {
		
		List<Produto> resultado = this.produtoDAO
			.findByNomeContainingIgnoreCase(nomeProduto, Sort.by("nome"));
		model.addAttribute("listaProdutos", resultado);
		return "vendas/produto-search";
	}

}
