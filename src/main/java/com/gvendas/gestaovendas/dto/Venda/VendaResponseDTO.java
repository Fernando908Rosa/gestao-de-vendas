package com.gvendas.gestaovendas.dto.Venda;

import java.time.LocalDate;
import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("Venda retorno DTO")
public class VendaResponseDTO {
    
	@ApiModelProperty(value = "Codigo")
	private Long codigo;
    
	@ApiModelProperty(value = "Data")
	private LocalDate data;
    @ApiModelProperty(value = "Itens da venda")
	private List<ItemVendaResponseDTO> itemvendaDTO;

	public VendaResponseDTO(Long codigo, LocalDate data, List<ItemVendaResponseDTO> itemvendaDTO) {
		this.codigo = codigo;
		this.data = data;
		this.itemvendaDTO = itemvendaDTO;
	}

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}

	public List<ItemVendaResponseDTO> getItemvendaDTO() {
		return itemvendaDTO;
	}

	public void setItemvendaDTO(List<ItemVendaResponseDTO> itemvendaDTO) {
		this.itemvendaDTO = itemvendaDTO;
	}
}
