package br.com.zup.casadocodigo.compra;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.zup.casadocodigo.estado.EstadoRepository;
import br.com.zup.casadocodigo.pais.PaisRepository;
import br.com.zup.casadocodigo.validacao.PaisPossuiEstadoValidator;
import br.com.zup.casadocodigo.validacao.ValidaCpfCnpjValidator;

@RestController
@RequestMapping("/compra")
public class CompraController {

	@Autowired
	private PaisPossuiEstadoValidator paisPossuiEstadoValidator;
	
	@Autowired
	private CompraRepository compraRepository;
	
	@Autowired
	private PaisRepository paisRepository;
	
	@Autowired
	private EstadoRepository estadoRepository;
	
	@InitBinder
	public void init(WebDataBinder binder) {
		binder.addValidators(new ValidaCpfCnpjValidator(), paisPossuiEstadoValidator);
	}
	
	@PostMapping
	@Transactional
	public void cadastrar(@RequestBody @Valid CadastroCompraDTO compraDTO) {

		Compra compra = compraDTO.converter(paisRepository, estadoRepository);
		compraRepository.save(compra);
	}

}
