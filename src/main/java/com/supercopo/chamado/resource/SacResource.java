package com.supercopo.chamado.resource;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.supercopo.chamado.domain.Sac;
import com.supercopo.chamado.domain.SacNew;
import com.supercopo.chamado.domain.dto.SacDTO;
import com.supercopo.chamado.domain.dto.flat.SacFlat;
import com.supercopo.chamado.service.SacService;
import com.supercopo.chamado.service.rels.RelAtendimento;
import com.supercopo.chamado.service.util.Tenantuser;

@RestController
@RequestMapping("/sacs")
public class SacResource {
	
	@Autowired
	private SacService service;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private Tenantuser tenantUsuario;
	
	@Autowired
	private RelAtendimento relservice;
	
		
//	@GetMapping
//	public ResponseEntity<?> findALLSQL() {
//		List<Sac> lista = service.findALLSQL();
//		
//		return ResponseEntity.ok(lista);
//	}
	
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<SacFlat>> findAll() {
		List<SacFlat> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> findAllConv(@PathVariable Integer id) {
	//	List<ConvenioDTO> list = service.findAll();
		SacFlat list = service.findAllSac(id);
		System.out.println("id" + id);
		return ResponseEntity.ok().body(list);
	}
	
	
	@RequestMapping(value = "/inativos",method = RequestMethod.GET)
	public ResponseEntity<List<SacFlat>> findAllInativos() {
		List<SacFlat> list = service.findAllInativos();
		return ResponseEntity.ok().body(list);
	}
	
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Sac> insert(@Valid @RequestBody SacNew obj) {
		Sac novoobj = modelMapper.map(obj, Sac.class);
		Sac objNovo = service.insert(novoobj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(objNovo.getId())
				.toUri();
		return ResponseEntity.created(uri).body(objNovo);
	}
	
//	@RequestMapping(value = "/relatorios/mensal", method = RequestMethod.GET)
//	public ResponseEntity<byte[]> mensal(
//			@RequestParam Integer mes, 
//			@RequestParam Integer ano) throws Exception {
//		Integer tenant = tenantUsuario.buscarOuFalharInt();
//		byte[] relatorio = relservice.mensal(mes, ano, tenant);		
//				
//		return ResponseEntity.ok()
//				.header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_PDF_VALUE)
//				.body(relatorio);
//	}
	
	
	
	@RequestMapping(value = "/relatorios/sacs", method = RequestMethod.GET)
	public ResponseEntity<byte[]> convenio() throws Exception {
		Integer tenant = tenantUsuario.buscarOuFalharInt();
		byte[] relatorio = relservice.sac(tenant);		
				
		return ResponseEntity.ok()
				.header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_PDF_VALUE)
				.body(relatorio);
	}
	
	
	@PutMapping("/{id}")
	public ResponseEntity<?> update(@Valid @RequestBody SacDTO obj, @PathVariable Integer id) {
		obj.setId(id);
		Sac novoobj = new Sac(obj);
		Sac atividadeAtualizado = service.from(novoobj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().
				path("/{id}").buildAndExpand(atividadeAtualizado.getId()).toUri();
		return ResponseEntity.created(uri).body(atividadeAtualizado);
		
	}
	
	
	
	
	
	
}
