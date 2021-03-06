package br.com.zup.casadocodigo.estado;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import br.com.zup.casadocodigo.pais.Pais;

@Entity
public class Estado {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank
	@Column(unique = true)
	private String nome;

	@ManyToOne
	@NotNull
	private Pais pais;

	public Estado() {

	}

	public Estado(@NotBlank String nome, @NotNull Pais pais) {
		super();
		this.nome = nome;
		this.pais = pais;
	}

	public Long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public Pais getPais() {
		return pais;
	}

	public boolean pertencePais(Pais pais) {
		return this.pais.equals(pais);
	}

}
