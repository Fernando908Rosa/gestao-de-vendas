package com.gvendas.gestaovendas.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gvendas.gestaovendas.dto.Venda.ClienteVendaResponseDTO;
import com.gvendas.gestaovendas.dto.Venda.VendaRequestDTO;
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

	@ApiOperation(value = "Listar vendas por código", nickname = "ListarVendaPorCodigo")
	@GetMapping("{codigoVenda}")
	public ResponseEntity<ClienteVendaResponseDTO> ListarVendaPorCodigo(@PathVariable Long codigoVenda) {
		return ResponseEntity.ok(vendaServico.ListarVendaPorCodigo(codigoVenda));
	}
		
	@ApiOperation(value = "Registrar venda", nickname = "salvar")
	@PostMapping("/cliente/{codigoCliente}")
	public ResponseEntity<ClienteVendaResponseDTO> salvar(@PathVariable Long codigoCliente, @RequestBody VendaRequestDTO vendaDto) {
		return ResponseEntity.status(HttpStatus.CREATED).body(vendaServico.salvar(codigoCliente, vendaDto));
	}
}