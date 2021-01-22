package br.com.zup.casadocodigo.livro;

import java.util.ArrayList;
import java.util.List;

public class LivroDTO {

	private Long id;
	private String nome;

	public Long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}
	
	public LivroDTO(Long id, String nome) {
		super();
		this.id = id;
		this.nome = nome;
	}

	public static List<LivroDTO> converter(List<Livro> livros){
		List<LivroDTO> livrosDTO = new ArrayList<LivroDTO>();
		
		for (Livro livro : livros) {
			livrosDTO.add(new LivroDTO(livro.getId(), livro.getTitulo()));
		}
		
		return livrosDTO;
	}

}
