package com.gvendas.gestaovendas.dto.Venda;

import java.math.BigDecimal;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "Itens venda retorno DTO")
public class ItemVendaResponseDTO {
    
	@ApiModelProperty(value = "Codigo")
	private Long codigo;
    
	@ApiModelProperty(value = "Quantidade")
	private Integer quantidade;
    
	@ApiModelProperty(value = "Preço vendido")
	private BigDecimal precovendido;
    
	@ApiModelProperty(value = "Códico produto")
	private Long codigoProduto;
    
	@ApiModelProperty(value = "Descrição produto")
	private String produtoDescricao;

	public ItemVendaResponseDTO(Long codigo, Integer quantidade, BigDecimal precovendido, Long codigoProduto,
			String produtoDescricao) {
		this.codigo = codigo;
		this.quantidade = quantidade;
		this.precovendido = precovendido;
		this.codigoProduto = codigoProduto;
		this.produtoDescricao = produtoDescricao;
	}

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public BigDecimal getPrecovendido() {
		return precovendido;
	}

	public void setPrecovendido(BigDecimal precovendido) {
		this.precovendido = precovendido;
	}

	public Long getCodigoProduto() {
		return codigoProduto;
	}

	public void setCodigoProduto(Long codigoProduto) {
		this.codigoProduto = codigoProduto;
	}

	public String getProdutoDescricao() {
		return produtoDescricao;
	}

	public void setProdutoDescricao(String produtoDescricao) {
		this.produtoDescricao = produtoDescricao;
	}
}
