package com.supercopo.chamado.resource;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

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

import com.supercopo.chamado.domain.Empresa;
import com.supercopo.chamado.domain.EmpresaNew;
import com.supercopo.chamado.domain.dto.flat.EmpresaFlat;
import com.supercopo.chamado.service.EmpresaService;

@RestController
@RequestMapping("/empresas")
public class EmpresaResource {

	@Autowired
	private EmpresaService service;
	
	@GetMapping
	public ResponseEntity<List<EmpresaFlat>> findAll() {
		List<EmpresaFlat> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> find(@PathVariable Integer id) {
		Empresa obj = service.find(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@GetMapping("/usuario")
	public ResponseEntity<List<EmpresaFlat>> findAllUsuario() {
		
		List<EmpresaFlat> list = service.findAllUsuario();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping("/inativos")
	public ResponseEntity<List<EmpresaFlat>> findAllInativos() {
		List<EmpresaFlat> list = service.findAllInativos();
		return ResponseEntity.ok().body(list);
	}
	
	@PostMapping
	public ResponseEntity<Empresa> insert(@Valid @RequestBody EmpresaNew obj) {
		Empresa obj1 = new Empresa(obj);
		Empresa objNovo = service.insert(obj1);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(objNovo.getId())
				.toUri();
		return ResponseEntity.created(uri).body(objNovo);
	}
	
	
	@PutMapping("/{id}")
	public ResponseEntity<Empresa> update(@Valid @RequestBody Empresa obj, @PathVariable Integer id) {
		obj.setId(id);
		Empresa empresaAtualizado = service.from(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(empresaAtualizado.getId()).toUri();
		return ResponseEntity.created(uri).body(empresaAtualizado);
	}
	
}
