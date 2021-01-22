package br.com.zup.casadocodigo.livro;

import java.time.LocalDate;

import javax.validation.constraints.Future;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;

import br.com.zup.casadocodigo.autor.Autor;
import br.com.zup.casadocodigo.autor.AutorRepository;
import br.com.zup.casadocodigo.categoria.Categoria;
import br.com.zup.casadocodigo.categoria.CategoriaRepository;
import br.com.zup.casadocodigo.validacao.ExisteObjeto;
import br.com.zup.casadocodigo.validacao.ValorUnico;

public class CadastroLivroDTO {

	@NotBlank
	@ValorUnico(Classe = Livro.class, campo = "titulo")
	private String titulo;

	@NotBlank
	@Size(max = 500)
	private String resumo;

	@NotBlank
	private String sumario;

	@NotNull
	@Min(value = 20)
	private Double preco;

	@NotNull
	@Min(value = 100)
	private Integer paginas;

	@NotBlank
	@ValorUnico(Classe = Livro.class, campo = "isbn")
	private String isbn;

	@Future
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
	@NotNull
	private LocalDate dataPublicacao;

	@NotNull
	@ExisteObjeto(Classe = Categoria.class, campo = "id")
	private Long idCategoria;

	@NotNull
	@ExisteObjeto(Classe = Autor.class, campo = "id")
	private Long idAutor;

	public CadastroLivroDTO(@NotBlank String titulo, @NotBlank @Size(max = 500) String resumo, @NotBlank String sumario,
			@NotNull @Min(20) Double preco, @NotNull @Min(100) Integer paginas, @NotBlank String isbn,
			@NotNull Long idCategoria, @NotNull Long idAutor) {
		super();
		this.titulo = titulo;
		this.resumo = resumo;
		this.sumario = sumario;
		this.preco = preco;
		this.paginas = paginas;
		this.isbn = isbn;
		this.idCategoria = idCategoria;
		this.idAutor = idAutor;
	}

	public void setdataPublicacao(LocalDate dataPublicacao) {
		this.dataPublicacao = dataPublicacao;
	}

	public Livro converter(CategoriaRepository categoriaRepository, AutorRepository autorRepository) {
		Categoria categoria = categoriaRepository.getOne(idAutor);
		Autor autor = autorRepository.getOne(idAutor);

		return new Livro(titulo, resumo, sumario, preco, paginas, isbn, dataPublicacao, categoria, autor);
	}
}
