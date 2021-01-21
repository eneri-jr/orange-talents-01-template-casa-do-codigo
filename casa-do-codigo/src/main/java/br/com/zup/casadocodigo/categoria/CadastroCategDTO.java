package br.com.zup.casadocodigo.categoria;

import javax.validation.constraints.NotBlank;

public class CadastroCategDTO {

	@NotBlank
	private String nome;

	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}

	public Categoria converter() {
		return new Categoria(nome);
	}

}
