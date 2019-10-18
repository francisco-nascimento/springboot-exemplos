package br.ifpe.web2;

public class Produto {

	private String nome;
	private double preco;
	private int quantidade;
	
	@Override
	public String toString() {
		return "Produto [nome=" + nome 
				+ ", preco=" + preco 
				+ ", quantidade=" + quantidade + "]";
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public double getPreco() {
		return preco;
	}
	public void setPreco(double preco) {
		this.preco = preco;
	}
	public int getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	
}
