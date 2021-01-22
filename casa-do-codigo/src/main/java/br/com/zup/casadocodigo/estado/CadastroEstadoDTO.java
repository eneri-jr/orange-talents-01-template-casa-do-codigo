package br.com.zup.casadocodigo.estado;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import br.com.zup.casadocodigo.pais.Pais;
import br.com.zup.casadocodigo.pais.PaisRepository;
import br.com.zup.casadocodigo.validacao.ExisteObjeto;
import br.com.zup.casadocodigo.validacao.ValorUnico;

public class CadastroEstadoDTO {
	
	@NotBlank
	@ValorUnico(Classe = Estado.class, campo = "nome")
	private String nome;

	@NotNull
	@ExisteObjeto(Classe = Pais.class, campo = "id")
	private Long idPais;

	public CadastroEstadoDTO(@NotBlank String nome, @NotNull Long idPais) {
		super();
		this.nome = nome;
		this.idPais = idPais;
	}
	
	public Estado converter(PaisRepository paisRepository) {
		Pais pais = paisRepository.getOne(idPais);
		
		return new Estado(nome, pais);
	}
}
