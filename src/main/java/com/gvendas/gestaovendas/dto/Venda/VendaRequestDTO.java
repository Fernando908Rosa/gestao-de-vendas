package com.gvendas.gestaovendas.dto.Venda;

import java.time.LocalDate;
import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("Venda requisição DTO")
public class VendaRequestDTO {

	@ApiModelProperty(value = "Data")
	@NotNull(message = "Data")
	private LocalDate data;

	@ApiModelProperty(value = "Itens da venda")
	@Valid
	@NotNull(message = "Itens venda")

	private List<ItemVendaRequestDTO> itensvendaDto;

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}

	public List<ItemVendaRequestDTO> getItensVendaDto() {
		return itensvendaDto;
	}

	public void setItensVendaDto(List<ItemVendaRequestDTO> itensVendaDto) {
		this.itensvendaDto = itensVendaDto;
	}
}
