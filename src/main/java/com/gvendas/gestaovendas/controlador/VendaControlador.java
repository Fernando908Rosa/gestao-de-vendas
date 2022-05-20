package com.gvendas.gestaovendas.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gvendas.gestaovendas.dto.Venda.ClienteVendaResponseDTO;
import com.gvendas.gestaovendas.servico.VendaServico;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(tags = "venda")
@RestController
@RequestMapping("/venda")
public class VendaControlador {
	
	@Autowired
	private VendaServico vendaServico;
	
	@ApiOperation(value = "Listar vendas por cliente", nickname = "ListarVendaPorCliente")
	@GetMapping("/cliente/{codigoCliente}")
	public ResponseEntity<ClienteVendaResponseDTO> ListarVendaPorCliente(@PathVariable Long codigoCliente) {
		return ResponseEntity.ok(vendaServico.ListaVendaPorCliente(codigoCliente)); 
	}

}
