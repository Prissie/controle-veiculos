package com.desafio.controleveiculos.domain.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class VeiculoDto {
	
	@NotBlank(message = "{marca.notblank}")
	private String marca;
	
	@NotBlank(message = "{modelo.notblank}")
	private String modelo;

	@NotBlank(message = "{ano.notblank}")
	@Size(min = 4, max = 4, message = "{ano.notvalid}")
	private String ano;

	public String getMarca() {
		return marca;
	}

	public String getModelo() {
		return modelo;
	}

	public String getAno() {
		return ano;
	}

	@Override
	public String toString() {
		return "VeiculoDto [marca=" + marca + ", modelo=" + modelo + ", ano=" + ano + "]";
	}
	
}
