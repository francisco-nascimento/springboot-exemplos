package br.ifpe.web2.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;

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
	private Categoria categoria;
	private double preco;
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
