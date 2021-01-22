package br.com.zup.casadocodigo.compra;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import org.hibernate.validator.internal.constraintvalidators.hv.br.CNPJValidator;
import org.hibernate.validator.internal.constraintvalidators.hv.br.CPFValidator;

import com.sun.istack.NotNull;

import br.com.zup.casadocodigo.estado.Estado;
import br.com.zup.casadocodigo.estado.EstadoRepository;
import br.com.zup.casadocodigo.pais.Pais;
import br.com.zup.casadocodigo.pais.PaisRepository;
import br.com.zup.casadocodigo.validacao.ExisteObjeto;

public class CadastroCompraDTO {

	@NotBlank
	@Email
	private String email;

	@NotBlank
	private String nome;

	@NotBlank
	private String sobrenome;

	@NotBlank
	private String documento;

	@NotBlank
	private String endereco;

	@NotBlank
	private String complemento;

	@NotBlank
	private String cidade;

	@NotNull
	@ExisteObjeto(Classe = Pais.class, campo = "id")
	private Long idPais;

	@ExisteObjeto(Classe = Estado.class, campo = "id")
	private Long idEstado;

	@NotBlank
	private String telefone;

	@NotBlank
	private String cep;

	public CadastroCompraDTO(@NotBlank @Email String email, @NotBlank String nome, @NotBlank String sobrenome,
			@NotBlank String documento, @NotBlank String endereco, @NotBlank String complemento,
			@NotBlank String cidade, Long idPais, Long idEstado, @NotBlank String telefone, @NotBlank String cep) {
		super();
		this.email = email;
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.documento = documento;
		this.endereco = endereco;
		this.complemento = complemento;
		this.cidade = cidade;
		this.idPais = idPais;
		this.idEstado = idEstado;
		this.telefone = telefone;
		this.cep = cep;
	}

	public boolean documentoValido() {
		CPFValidator cpfValidador = new CPFValidator();
		cpfValidador.initialize(null);

		CNPJValidator cnpjValidador = new CNPJValidator();
		cnpjValidador.initialize(null);

		return cpfValidador.isValid(documento, null) || cnpjValidador.isValid(documento, null);
	}

	public String getDocumento() {
		return documento;
	}

	public Long getIdPais() {
		return idPais;
	}

	public Long getIdEstado() {
		return idEstado;
	}

	public Compra converter(PaisRepository paisRepository, EstadoRepository estadoRepository) {
		Pais pais = paisRepository.getOne(idPais);
		Estado estado = estadoRepository.getOne(idEstado);

		return new Compra(email, nome, sobrenome, documento, endereco, complemento, cidade, pais, estado, telefone, cep);
	}

}
