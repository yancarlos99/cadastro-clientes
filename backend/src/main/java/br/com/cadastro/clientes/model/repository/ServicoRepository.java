package br.com.cadastro.clientes.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.cadastro.clientes.model.entity.Servico;

public interface ServicoRepository extends JpaRepository<Servico, Long> {

}
