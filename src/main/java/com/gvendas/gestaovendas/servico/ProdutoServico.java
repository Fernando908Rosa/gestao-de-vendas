package com.gvendas.gestaovendas.servico;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gvendas.gestaovendas.entidades.Produto;
import com.gvendas.gestaovendas.repositorio.ProdutoRepositorio;

@Service
public class ProdutoServico {
	
	@Autowired
	private ProdutoRepositorio produtorepositorio;
	
	public List<Produto> listarTodos(Long codigocategoria) {
		return produtorepositorio.findByCategoriaCodigo(codigocategoria);
			
	}
	
	public Optional<Produto> buscarPorCodigo(Long codigo, Long codigoCategoria) {
		return produtorepositorio.buscarPorCodigo(codigo, codigoCategoria);
	}
}