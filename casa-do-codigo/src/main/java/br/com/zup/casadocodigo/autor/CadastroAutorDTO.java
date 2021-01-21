package br.com.zup.casadocodigo.autor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import br.com.zup.casadocodigo.categoria.Categoria;
import br.com.zup.casadocodigo.validacao.ValorUnico;

public class CadastroAutorDTO {

	@NotBlank
	private String nome;

	@NotBlank
	@Email
	@ValorUnico(Classe = Autor.class, campo = "email")
	private String email;

	@NotBlank
	@Size(max = 400)
	private String descricao;

	public CadastroAutorDTO(@NotBlank String nome, @NotBlank @Email String email,
			@NotBlank @Size(max = 400) String descricao) {
		super();
		this.nome = nome;
		this.email = email;
		this.descricao = descricao;
	}

	public Autor converter() {
		return new Autor(nome, email, descricao);
	}

	public String getNome() {
		return nome;
	}

	public String getEmail() {
		return email;
	}

	public String getDescricao() {
		return descricao;
	}

}
