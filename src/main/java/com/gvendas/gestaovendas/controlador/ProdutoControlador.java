package com.gvendas.gestaovendas.controlador;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gvendas.gestaovendas.entidades.Produto;
import com.gvendas.gestaovendas.servico.ProdutoServico;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(tags = "Produto")
@RestController
@RequestMapping("/categoria{codigoCategoria}/produto")
public class ProdutoControlador {

	@Autowired
	private ProdutoServico produtoServico;

	@ApiOperation(value = "Listar", nickname = "listarTodas")
	@GetMapping
	public List<Produto> ListarTodas(@PathVariable Long codigoCategoria) {
		return produtoServico.listarTodos(codigoCategoria);
	}

	@ApiOperation(value = "Listar por codigo", nickname = "buscarPorCodigo")
	@GetMapping("/{codigo}")
	public ResponseEntity<Optional<Produto>> buscarPorId(@PathVariable Long codigoCategoria,
			@PathVariable Long codigo) {
		Optional<Produto> produto = produtoServico.buscarPorCodigo(codigo, codigoCategoria);
		return produto.isPresent() ? ResponseEntity.ok(produto) : ResponseEntity.notFound().build();
	}

	@ApiOperation(value = "Salvar", nickname = "salvarProduto")
	@PostMapping
	public ResponseEntity<Produto> salvar(@Valid @RequestBody Produto produto) {
		Produto produtoSalvo = produtoServico.salvar(produto);
		return ResponseEntity.status(HttpStatus.CREATED).body(produtoSalvo);
	}
	
	@ApiOperation(value = "Atualizar", nickname = "atualizarProduto")
	@PutMapping("/{codigoProduto}")
	public ResponseEntity<Produto> atualizar(@PathVariable Long codigoCategoria, @PathVariable Long codigoProduto, @Valid @RequestBody Produto produto) {
		return ResponseEntity.ok(produtoServico.atualizar(codigoCategoria, codigoProduto, produto));
	}
}	

