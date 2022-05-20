package com.gvendas.gestaovendas.dto.Venda;

import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("Cliente da venda retorno DTO")
public class ClienteVendaResponseDTO {

	@ApiModelProperty(value = "Nome cliente")
	private String nome;

	@ApiModelProperty(value = "venda")
	private List<VendaResponseDTO> vendaResponseDTO;

	public ClienteVendaResponseDTO(String nome, List<VendaResponseDTO> vendaResponseDTO) {
		this.nome = nome;
		this.vendaResponseDTO = vendaResponseDTO;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<VendaResponseDTO> getVendaResponseDTO() {
		return vendaResponseDTO;
	}

	public void setVendaResponseDTO(List<VendaResponseDTO> vendaResponseDTO) {
		this.vendaResponseDTO = vendaResponseDTO;
	}
}