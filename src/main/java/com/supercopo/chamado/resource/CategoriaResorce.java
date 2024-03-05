package com.supercopo.chamado.resource;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.supercopo.chamado.domain.Categoria;
import com.supercopo.chamado.domain.dto.CategoriaDTO;
import com.supercopo.chamado.domain.dto.flat.CategoriaFlat;
import com.supercopo.chamado.service.CategoriaService;

@RestController
@RequestMapping("/categorias")
public class CategoriaResorce {
	
	@Autowired
	private CategoriaService service;
	
	@Autowired
	private ModelMapper modelMapper;
	
	
	@GetMapping
	public ResponseEntity<List<CategoriaFlat>> findAll() {
		List<CategoriaFlat> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> findAllSetor(@PathVariable Integer id) {
		CategoriaFlat list = service.findAllCategoria(id);
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping("/inativos")
	public ResponseEntity<List<CategoriaFlat>> findAllInativos() {
		List<CategoriaFlat> list = service.findAllInativos();
		return ResponseEntity.ok().body(list);
	}
	
	
	@PostMapping
	public ResponseEntity<Categoria> insert(@Valid @RequestBody CategoriaDTO obj) {
		Categoria novoobj = modelMapper.map(obj, Categoria.class);
		Categoria objNovo = service.insert(novoobj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(objNovo.getId())
				.toUri();
		return ResponseEntity.created(uri).body(objNovo);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?> update(@Valid @RequestBody CategoriaDTO obj, @PathVariable Integer id) {
		obj.setId(id);
		Categoria novoobj = new Categoria(obj);
		Categoria atividadeAtualizado = service.from(novoobj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().
				path("/{id}").buildAndExpand(atividadeAtualizado.getId()).toUri();
		return ResponseEntity.created(uri).body(atividadeAtualizado);
		
	}
	
	
}
