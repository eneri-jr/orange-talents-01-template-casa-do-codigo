package br.com.zup.casadocodigo.autor;

import java.util.Optional;

import javax.validation.constraints.NotBlank;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AutorRepository extends JpaRepository<Autor, Long> {
	
	Optional<Autor> findByEmail(String email);

	Autor findByNome(String nomeAutor);
}
