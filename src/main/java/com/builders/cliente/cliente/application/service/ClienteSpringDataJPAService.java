package com.builders.cliente.cliente.application.service;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.builders.cliente.cliente.application.repository.ClienteRepository;
import com.builders.cliente.cliente.domain.Cliente;
import com.builders.cliente.handler.ApiException;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Service
@AllArgsConstructor
@Log4j2
public class ClienteSpringDataJPAService implements ClienteService {
	private ClienteRepository clienteRepository;

	@Override
	public Cliente salvaCliente(Cliente cliente) {
		log.info("[Inicia] ClienteSpringDataJPAService - salvaCliente");
		saveToRepository(cliente);
		log.info("[Finaliza] ClienteSpringDataJPAService - salvaCliente");
		return cliente;
	}
	
	private Cliente saveToRepository(Cliente cliente) {
		log.info("[Inicia] ClienteSpringDataJPAService - saveToRepository");
		try {
			Cliente clienteSalvo = this.clienteRepository.save(cliente);
			log.info("[Finaliza] ClienteSpringDataJPAService - saveToRepository");
			return clienteSalvo;
		} catch (DataIntegrityViolationException e) {
			throw ApiException.throwApiException(HttpStatus.BAD_REQUEST,
					"O cliente já Existe", e);
		}
	}

}
