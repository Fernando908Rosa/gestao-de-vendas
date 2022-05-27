package com.gvendas.gestaovendas.servico;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import com.gvendas.gestaovendas.dto.Venda.ClienteVendaResponseDTO;
import com.gvendas.gestaovendas.dto.Venda.ItemVendaRequestDTO;
import com.gvendas.gestaovendas.dto.Venda.ItemVendaResponseDTO;
import com.gvendas.gestaovendas.dto.Venda.VendaResponseDTO;
import com.gvendas.gestaovendas.entidades.ItemVenda;
import com.gvendas.gestaovendas.entidades.Produto;
import com.gvendas.gestaovendas.entidades.Venda;

public abstract class AbstractVendaServico {
	
	protected ClienteVendaResponseDTO retornandoClienteVendaResponseDTO(Venda venda, List<ItemVenda> itensvendaList) {
		return new ClienteVendaResponseDTO(venda.getCliente().getNome(), Arrays.asList(
				criandoVendaResponseDTO(venda, itensvendaList))); 
	}
		
	protected VendaResponseDTO criandoVendaResponseDTO(Venda venda, List<ItemVenda> itensVendaList) {
		List<ItemVendaResponseDTO> itensVendaResponseDto = itensVendaList.stream()
			.map(this::criandoItensVendaResponseDto).collect(Collectors.toList());
		return new VendaResponseDTO(venda.getCodigo(), venda.getData(), itensVendaResponseDto);
	}

	protected ItemVendaResponseDTO criandoItensVendaResponseDto(ItemVenda itemVenda) {
		return new ItemVendaResponseDTO(itemVenda.getCodigo(), itemVenda.getQuantidade(), itemVenda.getPrecoVendido(),
			itemVenda.getProduto().getCodigo(), itemVenda.getProduto().getDescricao());
	}
	
	protected ItemVenda criandoItemVenda(ItemVendaRequestDTO itemVendaDto, Venda venda) {
		return new ItemVenda(itemVendaDto.getQuantidade(), itemVendaDto.getPrecoVendido(),
				new Produto(itemVendaDto.getCodigoProduto()), venda);
	}
}	
	
	