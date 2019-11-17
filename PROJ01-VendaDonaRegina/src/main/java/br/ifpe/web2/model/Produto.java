package br.ifpe.web2.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/*
 * @OneToOne - simples
 * @OneToMany - múltiplo
 * @ManyToOne - simples
 * @ManyToMany - múltiplo
 */

@Entity
public class Produto {

	@Id @GeneratedValue(strategy =GenerationType.AUTO)
	private Integer codigo;
	@NotBlank(message = "Nome deve ser preenchido")
	private String nome;
	@ManyToOne
	@NotNull(message = "Categoria deve ser selecionada")
	private Categoria categoria;
	@DecimalMin(value = "0.01", message = "Preço mínimo: R$ 0,01")
	private double preco;
	@Min(value = 0, message = "Estoque mínimo: 0 unidades")
	private int estoque;
	@Lob
	private byte[] imagem;
	
	public Integer getCodigo() {
		return codigo;
	}
	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Categoria getCategoria() {
		return categoria;
	}
	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	public double getPreco() {
		return preco;
	}
	public void setPreco(double preco) {
		this.preco = preco;
	}
	public int getEstoque() {
		return estoque;
	}
	public void setEstoque(int estoque) {
		this.estoque = estoque;
	}
	public byte[] getImagem() {
		return imagem;
	}
	public void setImagem(byte[] imagem) {
		this.imagem = imagem;
	}
	
	
}
