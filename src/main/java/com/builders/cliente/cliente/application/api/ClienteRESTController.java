package com.builders.cliente.cliente.application.api;

import java.net.URI;

import javax.validation.Valid;


import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.builders.cliente.cliente.application.api.dto.ClienteDTO;
import com.builders.cliente.cliente.application.api.form.ClienteForm;
import com.builders.cliente.cliente.application.service.ClienteService;
import com.builders.cliente.cliente.domain.Cliente;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;

@RestController

@Validated
@AllArgsConstructor
@Log4j2
public class ClienteRESTController implements ClienteAPI {
	private ClienteService clienteService;

	@Override
	public ResponseEntity<ClienteDTO> criaCliente(ClienteForm clienteform, UriComponentsBuilder uriBuilder) {
		log.info("[Inicia] ClienteRestController - criaCliente");
		Cliente cliente = clienteService.salvaCliente(clienteform.toEntity());
		log.info("cliente {} salvo!", cliente.toString());
		URI uri = uriBuilder.path("/cliente-api/app/v1/cliente/{clienteId}").buildAndExpand(cliente.getId()).toUri();
		log.info("[Finaliza] ClienteRestController - criaCliente");
		return ResponseEntity.created(uri).body(new ClienteDTO(cliente));
	}

}
