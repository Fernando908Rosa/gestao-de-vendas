package com.gvendas.gestaovendas.dto.Venda;

import java.math.BigDecimal;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("Itens da Venda requisição DTO")
public class ItemVendaRequestDTO {

	@ApiModelProperty(value = "Código produto")
	@NotNull(message = "Código produto")
	private long codigoProduto;

	@ApiModelProperty(value = "Quantidade")
	@NotNull(message = "Quantidade")
	@Min(value = 1, message = "Quantidade")
	private Integer quantidade;

	@ApiModelProperty(value = "Preço Vendido")
	@NotNull(message = "Preço Vendido")
	private BigDecimal precoVendido;

	public long getCodigoProduto() {
		return codigoProduto;
	}

	public void setCodigoProduto(long codigoProduto) {
		this.codigoProduto = codigoProduto;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public BigDecimal getPrecoVendido() {
		return precoVendido;
	}

	public void setPrecoVendido(BigDecimal precoVendido) {
		this.precoVendido = precoVendido;
	}
}
