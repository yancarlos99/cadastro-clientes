package br.com.cadastro.clientes.rest;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import br.com.cadastro.clientes.model.entity.Cliente;
import br.com.cadastro.clientes.model.entity.ServicoPrestado;
import br.com.cadastro.clientes.model.repository.ClienteRepository;
import br.com.cadastro.clientes.model.repository.ServicoPrestadoRepository;
import br.com.cadastro.clientes.rest.dto.ServicoPrestadoDTO;
import br.com.cadastro.clientes.util.BigDecimalConverter;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/servicos-prestados")
@RequiredArgsConstructor
public class ServicoPrestadoController {
	
	private final ClienteRepository clienteRepository;
	private final ServicoPrestadoRepository repository;
	private final BigDecimalConverter bigDecimalConverter;
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ServicoPrestado salvar( @RequestBody @Valid ServicoPrestadoDTO dto) {
		
		LocalDate dataFormatada = LocalDate.parse(dto.getData(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		
		Long idCliente = dto.getIdCliente();
		
		Cliente cliente = clienteRepository
				.findById(idCliente)
				.orElseThrow( () -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "CLIENTE NÃO EXISTE"));
		
		ServicoPrestado servicoPrestado = new ServicoPrestado();
		servicoPrestado.setDescricao(dto.getDescricao());
		servicoPrestado.setData(dataFormatada);
		servicoPrestado.setCliente(cliente);
		servicoPrestado.setValor(bigDecimalConverter.converter(dto.getPreco()));
		
		return repository.save(servicoPrestado);
	}
	
	@GetMapping
	public List<ServicoPrestado> pesquisar(
			@RequestParam(value = "nome", required = false, defaultValue = "") String nome,
			@RequestParam(value = "mes", required = false) Integer mes
			){
		
		return repository.findByNomeClienteAndMes("%" + nome + "%", mes);
	}

}
