package br.com.zup.casadocodigo.livro;

import java.time.format.DateTimeFormatter;

import br.com.zup.casadocodigo.autor.AutorDetalhadoDTO;

public class LivroDetalhadoDTO {

	private String titulo;
	private String resumo;
	private String sumario;
	private Double preco;
	private Integer paginas;
	private String isbn;
	private String dataPublicacao;
	private AutorDetalhadoDTO autor;

	public LivroDetalhadoDTO(Livro livro) {
		super();
		this.titulo = livro.getTitulo();
		this.resumo = livro.getResumo();
		this.sumario = livro.getSumario();
		this.preco = livro.getPreco();
		this.paginas = livro.getPaginas();
		this.isbn = livro.getIsbn();
		this.dataPublicacao = livro.getDataPublicacao().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		this.autor = new AutorDetalhadoDTO(livro.getAutor());
	}

	public String getTitulo() {
		return titulo;
	}

	public String getResumo() {
		return resumo;
	}

	public String getSumario() {
		return sumario;
	}

	public Double getPreco() {
		return preco;
	}

	public Integer getPaginas() {
		return paginas;
	}

	public String getIsbn() {
		return isbn;
	}

	public String getDataPublicacao() {
		return dataPublicacao;
	}

	public AutorDetalhadoDTO getAutor() {
		return autor;
	}

}
