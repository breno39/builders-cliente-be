package com.builders.cliente.cliente.infrastructure;

import org.springframework.stereotype.Repository;

import com.builders.cliente.cliente.application.repository.ClienteRepository;
import com.builders.cliente.cliente.domain.Cliente;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Repository
@AllArgsConstructor
@Log4j2
public class ClienteJPARepository implements ClienteRepository {
	private ClienteSpringDataJPARepository clienteSpringDataJPARepository;
	
	@Override
	public Cliente save(Cliente cliente) {
		log.info("[Inicia] ClienteJpaRepository - save");
		Cliente clienteSalvo = this.clienteSpringDataJPARepository.save(cliente);
		log.info("[Finaliza] ClienteJpaRepository - save");
		return clienteSalvo;
	}

}
