package br.com.zup.casadocodigo.autor;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class InvalidaEmailDuplicadoValidator implements Validator {

	@Autowired
	private AutorRepository autorRepository;

	@Override
	public boolean supports(Class<?> clazz) {
		return CadastroAutorDTO.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		if (errors.hasErrors()) {
			return;
		}

		CadastroAutorDTO novoAutor = (CadastroAutorDTO) target;

		Optional<Autor> possivelAutor = autorRepository.findByEmail(novoAutor.getEmail());

		if (possivelAutor.isPresent()) {
			errors.rejectValue("email", null, "O email informado já esta cadastrado em nosso sistema");
		}

	}

}
