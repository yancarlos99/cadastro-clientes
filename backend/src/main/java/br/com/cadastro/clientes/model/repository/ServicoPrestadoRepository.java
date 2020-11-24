package br.com.cadastro.clientes.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.cadastro.clientes.model.entity.ServicoPrestado;

public interface ServicoPrestadoRepository extends JpaRepository<ServicoPrestado, Long> {

}
