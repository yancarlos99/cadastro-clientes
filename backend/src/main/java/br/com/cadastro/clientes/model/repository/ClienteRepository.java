package br.com.cadastro.clientes.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.cadastro.clientes.model.entity.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

}
