package br.com.zup.casadocodigo.estado;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.zup.casadocodigo.pais.PaisRepository;

@RestController
@RequestMapping("/estado")
public class EstadoController {
	
	@Autowired
	private EstadoRepository estadoRepository;
	
	@Autowired
	private PaisRepository paisRepository;
	
	@PostMapping
	@Transactional
	public void cadastrar(@RequestBody @Valid CadastroEstadoDTO estadoDTO) {

		Estado estado = estadoDTO.converter(paisRepository);
		estadoRepository.save(estado);

	}

}
