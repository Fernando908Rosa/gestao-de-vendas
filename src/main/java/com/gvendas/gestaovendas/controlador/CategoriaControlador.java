package com.gvendas.gestaovendas.controlador;

import java.util.List;

import java.util.Optional;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.gvendas.gestaovendas.dto.Categoria.CategoriaRequestDTO;
import com.gvendas.gestaovendas.dto.Categoria.CategoriaResponseDTO;
import com.gvendas.gestaovendas.entidades.Categoria;
import com.gvendas.gestaovendas.servico.CategoriaServico;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(tags = "Categoria")
@RestController
@RequestMapping("/categoria")
public class CategoriaControlador {

	@Autowired
	private CategoriaServico categoriaServico;

	@ApiOperation(value = "Listar", nickname = "listarTodas")
	@GetMapping
	public List<CategoriaResponseDTO> listarTodas() {
		return categoriaServico.listarTodas().stream()
				.map(categoria -> CategoriaResponseDTO.converterParaCategoriaDTO(categoria))
				.collect(Collectors.toList());
	}

	@ApiOperation(value = "Listar por codigo", nickname = "buscarorId")
	@GetMapping("/{codigo}")
	public ResponseEntity<CategoriaResponseDTO> buscarPorId(@PathVariable Long codigo) {
		Optional<Categoria> categoria = categoriaServico.burcarPorCodigo(codigo);
		return categoria.isPresent()
				? ResponseEntity.ok(CategoriaResponseDTO.converterParaCategoriaDTO(categoria.get()))
				: ResponseEntity.notFound().build();
	}

	@ApiOperation(value = "Salvar", nickname = "salvarCategoria")
	@PostMapping
	public ResponseEntity<CategoriaResponseDTO> salvar(@Valid @RequestBody CategoriaRequestDTO categoriaDto) {
		Categoria categoriaSalva = categoriaServico.salvar(categoriaDto.converterParaEntidade());
		return ResponseEntity.status(HttpStatus.CREATED).body(CategoriaResponseDTO.converterParaCategoriaDTO(categoriaSalva));
	}

	@ApiOperation(value = "Atualizar", nickname = "atualizarCategoria")
	@PutMapping("/{codigo}")
	public ResponseEntity<CategoriaResponseDTO> atualizar(@PathVariable long codigo, @Valid @RequestBody CategoriaRequestDTO categoriaDto) {
		Categoria categoriaAtualizada = categoriaServico.atualizar(codigo,categoriaDto.converterParaEntidade(codigo));
		return ResponseEntity.ok(CategoriaResponseDTO.converterParaCategoriaDTO(categoriaAtualizada));
	}

	@ApiOperation(value = "Deletar", nickname = "deletarCategoria")
	@DeleteMapping("/{codigo}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deletar(@PathVariable Long codigo) {
		categoriaServico.deletar(codigo);
	}
}
