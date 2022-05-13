package com.gvendas.gestaovendas.dto.cliente;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("Endereço requisição DTO")
public class EnderecoRequestDTO {
	@ApiModelProperty(value = "Logradouro")
	@NotBlank(message = "Logradouro")
	@Length(min = 3, max = 30, message = "logradouro")
	
	private String logradouro;
	
	@ApiModelProperty(value = "Complemento")
	@Length(max = 30, message = "Complemento")
	private String complemento;
	
	@ApiModelProperty(value = "Bairro")
	@NotBlank(message = "Bairro")
	@Length(min = 3, max = 30, message = "Bairro")
	private String bairro;
	
	@ApiModelProperty("Cep") 
	@NotBlank(message = "Cep")
	@Pattern(regexp = "[\\d]{5}-[\\d]{3}", message = "Cep")
	private String cep;
	
	@ApiModelProperty("Cidade")
	@NotBlank(message = "cidade")
	@Length(min = 3, max = 30, message = "cidade")
	private String cidade;
	
	@ApiModelProperty("Estado")
	@NotBlank(message = "estado")
	@Length(min = 3, max = 30, message = "estado")
	private String estado;
	
	@ApiModelProperty("Numero")
	@NotNull(message = "Numero")
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
}
	
	

