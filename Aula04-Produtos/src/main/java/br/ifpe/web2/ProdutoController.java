package br.ifpe.web2;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ProdutoController {

	@GetMapping("/exibir")
	public String exibirForm(Produto produto) {
		return "form-produto";
	}
	
	@PostMapping("/salvarProduto")
	public String salvarProduto(Produto produto) {
		System.out.println(produto);
		return "form-produto";
	}
}
