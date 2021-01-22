package br.com.zup.casadocodigo.validacao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import br.com.zup.casadocodigo.compra.CadastroCompraDTO;
import br.com.zup.casadocodigo.estado.Estado;
import br.com.zup.casadocodigo.pais.Pais;

@Component
public class PaisPossuiEstadoValidator implements Validator {

	@PersistenceContext
	private EntityManager em;

	@Override
	public boolean supports(Class<?> clazz) {
		return CadastroCompraDTO.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		if (errors.hasErrors()) {
			return;
		}

		CadastroCompraDTO compraDTO = (CadastroCompraDTO) target;

		System.out.println("Caiu no teste");

		Pais pais = em.find(Pais.class, compraDTO.getIdPais());
		Estado estado = em.find(Estado.class, compraDTO.getIdEstado());

		if (!estado.pertencePais(pais)) {

			errors.rejectValue("idEstado", null, "Este estado não é do Pais selecionado");
		}

	}

}
