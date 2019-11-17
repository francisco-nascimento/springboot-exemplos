package br.ifpe.web2.controller;

import java.io.IOException;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import br.ifpe.web2.model.CategoriaDAO;
import br.ifpe.web2.model.Produto;
import br.ifpe.web2.model.ProdutoDAO;

@Controller
public class ProdutoController {

	@Autowired
	private ProdutoDAO produtoDAO;
	@Autowired
	private CategoriaDAO categoriaDAO;
	
	@GetMapping("/listarProdutos")
	public String exibirLista(Model model) {
		model.addAttribute("lista", produtoDAO.findAll(Sort.by("nome")));
		return "produto/produto-list";
	}
	
	@GetMapping("/exibirFormProduto")
	public String exibirForm(Produto produto, Model model) {
		model.addAttribute("listaCategorias", this.categoriaDAO.findAll(Sort.by("nome")));
		return "produto/produto-form";
	}
	
	@PostMapping("/salvarProduto")
	public String salvarProduto(@Valid Produto produto, 			
			BindingResult result, Model model, 
			@RequestParam("fileProduto") MultipartFile file) {
		
		if (result.hasErrors()) {
			return exibirForm(produto, model);
		}
		try {
			produto.setImagem(file.getBytes());
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		this.produtoDAO.save(produto);
		return "redirect:/listarProdutos";
	}

	@GetMapping("/editarProduto")
	public String editarProduto(Integer codigo, Model model) {
		model.addAttribute("produto", this.produtoDAO.findById(codigo));
		model.addAttribute("listaCategorias", this.categoriaDAO.findAll(Sort.by("nome")));
		return "produto/produto-form";
	}

	@GetMapping("/removerProduto")
	public String removerProduto(Integer codigo) {
		this.produtoDAO.deleteById(codigo);
		return "redirect:/listarProdutos";
	}
	
	@GetMapping("/imagem/{idprod}")
	@ResponseBody
	public byte[] exibirImagen(@PathVariable("idprod") Integer idprod) {
		Produto produto = this.produtoDAO.getOne(idprod);
		return produto.getImagem();
	}


}
