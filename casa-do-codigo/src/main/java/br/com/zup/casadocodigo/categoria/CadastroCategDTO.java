package br.com.zup.casadocodigo.categoria;

import javax.validation.constraints.NotBlank;

import br.com.zup.casadocodigo.validacao.ValorUnico;

public class CadastroCategDTO {

	@NotBlank
	@ValorUnico(Classe = Categoria.class, campo = "nome")
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
