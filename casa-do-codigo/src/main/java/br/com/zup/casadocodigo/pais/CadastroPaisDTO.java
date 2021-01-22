package br.com.zup.casadocodigo.pais;

import javax.validation.constraints.NotBlank;

import br.com.zup.casadocodigo.validacao.ValorUnico;

public class CadastroPaisDTO {
	
	@NotBlank
	@ValorUnico(Classe = Pais.class, campo = "nome")
	private String nome;
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}

	public Pais converter() {
		return new Pais(nome);
	}
	
}
