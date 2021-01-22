package br.com.zup.casadocodigo.livro;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.zup.casadocodigo.autor.AutorRepository;
import br.com.zup.casadocodigo.categoria.CategoriaRepository;

@RestController
@RequestMapping("/livro")
public class LivroController {

	@Autowired
	private AutorRepository autorRepository;

	@Autowired
	private LivroRepository livroRepository;

	@Autowired
	private CategoriaRepository categoriaRepository;

	@PostMapping
	@Transactional
	public void cadastrar(@RequestBody @Valid CadastroLivroDTO livroDTO) {

		Livro livro = livroDTO.converter(categoriaRepository, autorRepository);
		livroRepository.save(livro);

	}

	@GetMapping
	public List<LivroDTO> listar() {

		List<Livro> livros = livroRepository.findAll();
		return LivroDTO.converter(livros);
	}

	@GetMapping("/{id}")
	public ResponseEntity<LivroDetalhadoDTO> detalharLivro(@PathVariable Long id) {

		try {
			Livro possivelLivro = livroRepository.getOne(id);
			return ResponseEntity.ok(new LivroDetalhadoDTO(possivelLivro));
		} catch (Exception e) {
			return ResponseEntity.notFound().build();
		}
	}

}
