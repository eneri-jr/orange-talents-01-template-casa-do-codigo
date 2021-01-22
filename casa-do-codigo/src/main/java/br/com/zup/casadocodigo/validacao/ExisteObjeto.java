package br.com.zup.casadocodigo.validacao;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Documented
@Constraint(validatedBy = ValidaExisteObjeto.class)
@Target(value = {ElementType.FIELD})
@Retention(value = RetentionPolicy.RUNTIME)
public @interface ExisteObjeto {
	
	//Padrão para se criar uma anotation:
	
	String message() default "Id informado não esta cadastrado no banco";
	
	Class<?>[] groups() default { };
	
	Class<?extends Payload>[] payload() default { };
	
	//Parametros para validar os dados:
	
	String campo();
	
	Class<?> Classe();
	
}
