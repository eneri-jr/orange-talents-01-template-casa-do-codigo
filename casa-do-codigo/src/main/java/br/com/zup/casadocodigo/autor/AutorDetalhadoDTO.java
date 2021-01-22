package br.com.zup.casadocodigo.autor;

public class AutorDetalhadoDTO {

	private String nome;
	private String descricao;

	public AutorDetalhadoDTO(Autor autor) {
		this.nome = autor.getNome();
		this.descricao = autor.getDescricao();
	}

	public String getNome() {
		return nome;
	}

	public String getDescricao() {
		return descricao;
	}

}
