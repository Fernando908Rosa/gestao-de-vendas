package com.gvendas.gestaovendas.servico;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gvendas.gestaovendas.dto.Venda.ClienteVendaResponseDTO;
import com.gvendas.gestaovendas.dto.Venda.VendaResponseDTO;
import com.gvendas.gestaovendas.entidades.Cliente;
import com.gvendas.gestaovendas.entidades.ItemVenda;
import com.gvendas.gestaovendas.entidades.Venda;
import com.gvendas.gestaovendas.excecao.RegraNegocioException;
import com.gvendas.gestaovendas.repositorio.ItemVendaRepositorio;
import com.gvendas.gestaovendas.repositorio.VendaRepositorio;

@Service
public class VendaServico extends AbstractVendaServico {

	@Autowired
	private VendaRepositorio vendaRepositorio;

	@Autowired
	private ItemVendaRepositorio itemVendaRepositorio;

	@Autowired
	private ClienteServico clienteservico;
	private Object codigo;

	@Autowired
	public VendaServico(VendaRepositorio vendaRepositorio, ClienteServico clienteservico,
			ItemVendaRepositorio itemvendaRepositorio) {
		this.vendaRepositorio = vendaRepositorio;
		this.clienteservico = clienteservico;
		this.clienteservico = clienteservico;
	}

	public ClienteVendaResponseDTO ListaVendaPorCliente(Long codigoCliente) {
		Cliente cliente = validarClienteVendaExiste(codigoCliente);
		List<VendaResponseDTO> vendaResponseDtoList = vendaRepositorio.findByClienteCodigo(codigoCliente).stream()
				.map(venda -> criandoVendaResponseDTO(venda , itemVendaRepositorio.findByVendaCodigo(venda.getCodigo()))).collect(Collectors.toList());
		return new ClienteVendaResponseDTO(cliente.getNome(), vendaResponseDtoList);
	}

	public ClienteVendaResponseDTO ListarVendaPorCodigo(Long codigovenda) {
		Venda venda = validarVendaExiste(codigovenda);
		List<ItemVenda> itensVendaList = itemVendaRepositorio.findByVendaCodigo(venda.getCodigo());
		return new ClienteVendaResponseDTO(venda.getCliente().getNome(), Arrays
				.asList(criandoVendaResponseDTO(venda,itensVendaList))); 
	}

	private Venda validarVendaExiste(Long codigoVenda) {
		Optional<Venda> venda = vendaRepositorio.findById(codigoVenda);
		if (venda.isEmpty()) {
			throw new RegraNegocioException(String.format("Venda de código %s nao encontrado.", codigo));
		}
		return venda.get();
	}

	private Cliente validarClienteVendaExiste(Long codigoCliente) {
		Optional<Cliente> cliente = clienteservico.burcarPorCodigo(codigoCliente);
		if (cliente.isEmpty()) {
			throw new RegraNegocioException(
					String.format("O Cliente  de codigo %s informado não existe no cadastro.", codigoCliente));
		}
		return cliente.get();
	}
}