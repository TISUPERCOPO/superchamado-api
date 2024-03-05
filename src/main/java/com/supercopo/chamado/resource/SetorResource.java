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

import com.supercopo.chamado.domain.Setor;
import com.supercopo.chamado.domain.dto.SetorDTO;
import com.supercopo.chamado.domain.dto.flat.SetorFlat;
import com.supercopo.chamado.service.SetorService;

@RestController
@RequestMapping("/setores")
public class SetorResource {

	@Autowired
	private SetorService service;
	
	@Autowired
	private ModelMapper modelMapper;

	@GetMapping
	public ResponseEntity<List<SetorFlat>> findAll() {
		List<SetorFlat> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> findAllSetor(@PathVariable Integer id) {
		SetorFlat list = service.findAllSetor(id);
		System.out.println("id" + id);
		return ResponseEntity.ok().body(list);
	}

	@GetMapping("/inativos")
	public ResponseEntity<List<SetorFlat>> findAllInativos() {
		List<SetorFlat> list = service.findAllInativos();
		return ResponseEntity.ok().body(list);
	}

	@PostMapping
	public ResponseEntity<Setor> insert(@Valid @RequestBody SetorDTO obj) {
		Setor novoobj = modelMapper.map(obj, Setor.class);
		Setor objNovo = service.insert(novoobj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(objNovo.getId())
				.toUri();
		return ResponseEntity.created(uri).body(objNovo);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?> update(@Valid @RequestBody SetorDTO obj, @PathVariable Integer id) {
		obj.setId(id);
		Setor novoobj = new Setor(obj);
		Setor atividadeAtualizado = service.from(novoobj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().
				path("/{id}").buildAndExpand(atividadeAtualizado.getId()).toUri();
		return ResponseEntity.created(uri).body(atividadeAtualizado);
		
	}

}
