package com.builders.cliente.cliente.application.api.dto;

import com.builders.cliente.cliente.domain.Cliente;

import lombok.Getter;

@Getter
public class ClienteDTO {
	private String nome;

	private Integer idade;

	private String numeroCelular;

	public ClienteDTO(Cliente cliente) {
		numeroCelular = cliente.getNumeroCelular();
		idade = cliente.getIdade();
		nome = cliente.getNome();
		
	}
}
