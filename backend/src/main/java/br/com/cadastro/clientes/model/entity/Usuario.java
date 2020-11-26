package br.com.cadastro.clientes.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Usuario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(unique = true, name = "login")
	@NotEmpty(message = "Campo Username é obrigatório!")
	private String username;
	
	@Column(name = "senha")
	@NotEmpty(message = "Campo Senha é obrigatório!")
	private String password;
}
