package com.gvendas.gestaovendas.dto.cliente;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("Endereço retorno DTO")
public class EnderecoResponseDTO {
	
	@ApiModelProperty(value = "Logradouro")
	private String logradouro;
	
	@ApiModelProperty(value = "Complemento")
	private String complemento;
	
	@ApiModelProperty(value = "Bairro")
	private String bairro;
	
	@ApiModelProperty("Cep")                                   
	private String cep;
	
	@ApiModelProperty("Cidade")
	private String cidade;
	
	@ApiModelProperty("Estado") 
	private String estado;
	
	@ApiModelProperty("Numero")
	private Integer numero;

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
		
	}	
	
	

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public EnderecoResponseDTO(String logradouro, Integer numero, String complemento, String bairro, String cep, String cidade,
			String estado) {
		this.logradouro = logradouro;
		this.complemento = complemento;
		this.bairro = bairro;
		this.cep = cep;
		this.cidade = cidade;
		this.estado = estado;
		this.numero = numero;
	} 

}
