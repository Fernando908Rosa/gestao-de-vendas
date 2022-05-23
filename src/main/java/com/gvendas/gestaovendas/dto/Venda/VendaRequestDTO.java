package com.gvendas.gestaovendas.dto.Venda;

import java.time.LocalDate;
import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("Venda requisição DTO")
public class VendaRequestDTO {

	@ApiModelProperty(value = "Data")
	private LocalDate data;

	@ApiModelProperty(value = "Itens da venda")
	private List<ItemVendaRequestDTO> itemVendaRequestDTO;

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}

	public List<ItemVendaRequestDTO> getItemVendaRequestDTO() {
		return itemVendaRequestDTO;
	}

	public void setItemVendaRequestDTO(List<ItemVendaRequestDTO> itemVendaRequestDTO) {
		this.itemVendaRequestDTO = itemVendaRequestDTO;
	}
}
