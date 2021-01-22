package br.com.zup.casadocodigo.validacao;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import br.com.zup.casadocodigo.compra.CadastroCompraDTO;

public class ValidaCpfCnpjValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return CadastroCompraDTO.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		if(errors.hasErrors()) {
			return;
		}
		
		CadastroCompraDTO novaCompra = (CadastroCompraDTO) target;
		if(!novaCompra.documentoValido()) {
			errors.rejectValue("documento", null, "Documento precisa ser cpf ou cnpj válido!");
		}

	}

}
