package br.com.zup.casadocodigo.categoria;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import br.com.zup.casadocodigo.autor.Autor;
import br.com.zup.casadocodigo.autor.CadastroAutorDTO;

@Component
public class InvalidaNomeDuplicadoValidator implements Validator{

	@Autowired
	private CategoriaRepository categoriaRepository;
	
	@Override
	public boolean supports(Class<?> clazz) {
		return CadastroCategDTO.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		if (errors.hasErrors()) {
			return;
		}

		CadastroCategDTO novaCategoria = (CadastroCategDTO) target;

		Optional<Categoria> possivelCategoria = categoriaRepository.findByNome(novaCategoria.getNome());

		if (possivelCategoria.isPresent()) {
			errors.rejectValue("nome", null, "O nome da categoria informado ja existe no sistema");
		}

	}

}