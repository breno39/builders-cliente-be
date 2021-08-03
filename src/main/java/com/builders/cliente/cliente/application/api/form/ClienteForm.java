package com.builders.cliente.cliente.application.api.form;

import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

import com.builders.cliente.cliente.domain.Cliente;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class ClienteForm {

	@NotBlank
	@Size(max = 256) // é sempre bom limitar esses campos pra evitar problemas futuros
	private String nome;

	@Positive
	@Max(150) // é sempre bom limitar esses campos pra evitar problemas futuros
	private Integer idade;

	@NotBlank
	@Pattern(regexp = "^\\(?(?:[14689][1-9]|2[12478]|3[1234578]|5[1345]|7[134579])\\)? ?(?:[2-8]|9[1-9])[0-9]{3}\\-?[0-9]{4}$", message = "numero de celular nao valido!")
	private String numeroCelular;
	
	public Cliente toEntity() {
		return Cliente.builder()
				.nome(nome)
				.idade(idade)
				.numeroCelular(numeroCelular)
				.build();
	}
}
