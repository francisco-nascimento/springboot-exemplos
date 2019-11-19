package br.ifpe.web2.model;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ProdutoDAO extends JpaRepository<Produto, Integer> {

	List<Produto> findByNomeContainingIgnoreCase(String nomeProduto, Sort sort);
	
	List<Produto> findByPrecoBetween(double menor, double maior);
	
	Page<Produto> findByCategoriaIsNull(Pageable pageable);
	
	List<Produto> findByNomeStartingWithAndEstoqueGreaterThan(
			String nome, int estoque);

	Page<Produto> findByCategoriaInAndPrecoBetweenOrderByPrecoDesc(
			List<Categoria> categorias,
			double precoMin, double precoMax, 
			Pageable pageable);
}
