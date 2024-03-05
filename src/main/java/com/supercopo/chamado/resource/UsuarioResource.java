package com.supercopo.chamado.resource;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.supercopo.chamado.domain.Usuario;
import com.supercopo.chamado.domain.dto.UsuarioDTO;
import com.supercopo.chamado.domain.dto.flat.UsuarioFlat;
import com.supercopo.chamado.service.UsuarioService;

@RestController
@RequestMapping("/usuarios")
public class UsuarioResource {

	@Autowired
	private UsuarioService service;

	@GetMapping("/{id}")
	public ResponseEntity<?> find(@PathVariable Integer id) {
		UsuarioDTO obj = service.findF(id);
		return ResponseEntity.ok().body(obj);
	}

	@GetMapping("/{id}/senha")
	public ResponseEntity<?> findSenha(@PathVariable Integer id) {
		Usuario obj = service.find(id);
		return ResponseEntity.ok().body(obj);
	}
	
	
	

	@GetMapping
	public ResponseEntity<List<UsuarioFlat>> findAll() {
		List<UsuarioFlat> list = service.findAllSQL();
		return ResponseEntity.ok().body(list);
	}

	@GetMapping("/inativos")
	public ResponseEntity<List<UsuarioFlat>> findAllInativo() {
		// List<UsuarioDTO> list = service.findAll();
		List<UsuarioFlat> list = service.findAllSqlInativo();
		return ResponseEntity.ok().body(list);
	}

	@RequestMapping(value = "/page", method = RequestMethod.GET)
	public ResponseEntity<Page<Usuario>> findPage(@RequestParam(value = "page", defaultValue = "0") Integer page,
			@RequestParam(value = "linesPerPage", defaultValue = "24") Integer linesPerPage,
			@RequestParam(value = "orderBy", defaultValue = "nome") String orderBy,
			@RequestParam(value = "direction", defaultValue = "ASC") String direction) {
		Page<Usuario> list = service.findPage(page, linesPerPage, orderBy, direction);
		return ResponseEntity.ok().body(list);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable Integer id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}

	@PostMapping
	public ResponseEntity<?> insert(@RequestBody UsuarioFlat obj) {
		UsuarioFlat objNovo = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(objNovo.getId())
				.toUri();
		return ResponseEntity.created(uri).body(objNovo);

	}

	@PutMapping("/{id}")
	public ResponseEntity<?> update(@RequestBody UsuarioFlat obj, @PathVariable Integer id) {
		obj.setId(id);
		UsuarioFlat atividadeAtualizado = service.from(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(atividadeAtualizado.getId()).toUri();
		return ResponseEntity.created(uri).body(atividadeAtualizado);
	}

	@PutMapping("/{id}/senha")
	public ResponseEntity<?> updateSenha(@RequestBody UsuarioFlat obj, @PathVariable Integer id) {
		obj.setId(id);
		UsuarioFlat atividadeAtualizado = service.fromSenha(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(atividadeAtualizado.getId()).toUri();
		return ResponseEntity.created(uri).body(atividadeAtualizado);

	}

	@PutMapping("/alterarsenha")
	public ResponseEntity<?> alterarsenha(@RequestBody String obj) {
		Usuario usu = service.fromSenha(obj);
		usu.setPermissoes(null);
		return ResponseEntity.ok().body(usu);
	}

	@PutMapping("/{id}/status")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void inativar(@RequestBody Boolean obj, @PathVariable int id) {
		service.status(obj, id);

	}

	@RequestMapping(value = "/tenant/{idempresa}", method = RequestMethod.PUT)
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void setTenantAtivo(@PathVariable int idempresa) {
		service.tenantAtivo(idempresa);

	}
	
	
	
	@PutMapping("/{id}/resest")
	public ResponseEntity<?> resestsenha(@PathVariable Integer id) {
		Usuario usu = service.resestsenhas(id);
		usu.setPermissoes(null);
		return ResponseEntity.ok().body(usu);
	}

}
