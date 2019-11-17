package br.ifpe.web2.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
public class Categoria {

	@Id @GeneratedValue
	private Integer codigo;
	@Column(length = 50)
	@NotBlank(message = "Nome da categoria deve ser preenchido")
	@Size(min = 3, max = 50, message = "Nome da categoria deve ter entre 3 e 50 letras")
	private String nome;
	
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
	
	
}
