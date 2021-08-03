package com.builders.cliente.cliente.application.api;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.builders.cliente.cliente.application.api.dto.ClienteDTO;
import com.builders.cliente.cliente.application.api.form.ClienteForm;

@RestController
@RequestMapping("/v1/cliente")
public interface ClienteAPI {
	
	@PostMapping
	@ResponseStatus(value = HttpStatus.CREATED)
	public ResponseEntity<ClienteDTO> criaCliente(@RequestBody @Valid ClienteForm clienteform,
			UriComponentsBuilder uriBuilder);
}
