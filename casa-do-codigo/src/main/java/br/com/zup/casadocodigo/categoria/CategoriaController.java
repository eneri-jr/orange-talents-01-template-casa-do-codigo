package br.com.zup.casadocodigo.categoria;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/categoria")
public class CategoriaController {
	
	@Autowired
	private CategoriaRepository categoriaRepository;

	@PostMapping
	@Transactional
	public void cadastrar(@RequestBody @Valid CadastroCategDTO categoriaDTO) {

		Categoria categoria = categoriaDTO.converter();
		categoriaRepository.save(categoria);

	}

}
