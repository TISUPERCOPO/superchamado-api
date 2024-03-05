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
import com.supercopo.chamado.domain.Chamado;
import com.supercopo.chamado.domain.dto.ChamadoDTO;
import com.supercopo.chamado.domain.dto.flat.ChamadoFlat;
import com.supercopo.chamado.service.ChamadoService;

@RestController
@RequestMapping("chamados")
public class ChamadoResorce {
	
	@Autowired
	private ChamadoService service;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@GetMapping
	public ResponseEntity<List<ChamadoFlat>> findAll() {
		List<ChamadoFlat> list = service.findAllInativos();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> findAllSetor(@PathVariable Integer id) {
		ChamadoFlat list = service.findAllChamado(id);
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping("/Ativos")
	public ResponseEntity<List<ChamadoFlat>> findAllInativos() {
		List<ChamadoFlat> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@PostMapping
	public ResponseEntity<ChamadoFlat> insert(@Valid @RequestBody ChamadoFlat obj) {
		ChamadoFlat objNovo = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(objNovo.getId())
				.toUri();
		return ResponseEntity.created(uri).body(objNovo);
	}
	
	
	
	@PutMapping("/{id}")
	public ResponseEntity<?> update(@Valid @RequestBody ChamadoDTO obj, @PathVariable Integer id) {
		obj.setId(id);
		Chamado novoobj = new Chamado(obj);
		Chamado atividadeAtualizado = service.from(novoobj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().
				path("/{id}").buildAndExpand(atividadeAtualizado.getId()).toUri();
		return ResponseEntity.created(uri).body(atividadeAtualizado);
		
	}
	
	
}
