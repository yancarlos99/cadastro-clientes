package br.com.cadastro.clientes.rest.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ServicoPrestadoDTO {
	
	@NotEmpty(message = "O campo Descrição é obrigatório.")
	private String descricao;
	
	@NotEmpty(message = "O campo Preço é obrigatório.")
	private String preco;
	
	@NotEmpty(message = "O campo Data é obrigatório.")
	private String data;
	
	@NotNull(message = "O campo Cliente é obrigatório.")
	private Long idCliente;

}
