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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.gvendas.gestaovendas.entidades.Categoria;
import com.gvendas.gestaovendas.servico.CategoriaServico;

@RestController
@RequestMapping("/categoria")
public class CategoriaControlador {
	
	@Autowired
	private CategoriaServico categoriaServico;
	
	@GetMapping
	public List<Categoria> listarTodas(){ 
		return categoriaServico.listarTodas();
	}
	
    @GetMapping("/{codigo}")
	public ResponseEntity<Optional<Categoria>> buscarPorId(@PathVariable Long codigo){
    	Optional<Categoria> categoria = categoriaServico.burcarPorCodigo(codigo);
    	return categoria.isPresent() ? ResponseEntity.ok(categoria) : ResponseEntity.notFound().build();
	}
    
    @PostMapping
    public ResponseEntity<Categoria> salvar(@Valid @RequestBody Categoria categoria){
        Categoria categoriaSalva = categoriaServico.salvar(categoria);
        return ResponseEntity.status(HttpStatus.CREATED).body(categoriaSalva); 
      }
    
    @PutMapping("/{codigo}")
    public ResponseEntity<Categoria> atualizar(@PathVariable long codigo, @Valid @RequestBody Categoria categoria){
    	return ResponseEntity.ok(categoriaServico.atualizar(codigo, categoria));
    }
 }
