package com.supercopo.chamado.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.supercopo.chamado.domain.Categoria;
import com.supercopo.chamado.domain.LogSistema;
import com.supercopo.chamado.domain.dto.flat.CategoriaFlat;
import com.supercopo.chamado.repository.CategoriaRepository;
import com.supercopo.chamado.repository.LogSistemaRepository;
import com.supercopo.chamado.service.exception.EntidadeNaoEncontradaExcepition;
import com.supercopo.chamado.service.util.Tenantuser;

@Service
public class CategoriaService {

	@Autowired
	private CategoriaRepository repo;

	@Autowired
	private Tenantuser tenantUsuario;

	@Autowired
	private LogSistemaService log;

	@Autowired
	private LogSistemaRepository repolog;

	public List<CategoriaFlat> findAll() {
		List<Categoria> categoria = repo.findAllAtivas();
		List<CategoriaFlat> listempFlat = new ArrayList<>();
		for (Categoria e : categoria) {
			CategoriaFlat empflat = new CategoriaFlat(e);
			listempFlat.add(empflat);
		}
		return listempFlat;
	}

	public CategoriaFlat findAllCategoria(Integer id) {

		Categoria obj = repo.buscarId(id);

		CategoriaFlat cf = new CategoriaFlat(obj);

		return cf;
	}

	public List<CategoriaFlat> findAllInativos() {
		List<Categoria> emp = repo.findAllInativos();
		List<CategoriaFlat> listempFlat = new ArrayList<>();
		for (Categoria e : emp) {
			CategoriaFlat empflat = new CategoriaFlat(e);
			listempFlat.add(empflat);
		}
		return listempFlat;
	}
	
	@Transactional
	public Categoria insert(Categoria obj) {
		obj.setId(null);
		obj.setTenant(tenantUsuario.buscarOuFalhar());
		repo.save(obj);
		logCategoria(obj, "inserir");
		return obj;
	}
	
	
	private void logCategoria(Categoria obj, String string) {
		LogSistema logsistema = log.insert(obj, string);
		logsistema.setCategoria(obj);
		repolog.save(logsistema);

	}

	public Categoria from(Categoria atividadeNovo) {
		Categoria atividadeAtual = buscarOuFalhar(atividadeNovo.getId());
		atividadeAtual.setTenant(tenantUsuario.buscarOuFalhar());
		
		BeanUtils.copyProperties(atividadeNovo, atividadeAtual, "id");
		atividadeAtual.setTenant(tenantUsuario.buscarOuFalhar());
		logCategoria(atividadeAtual, "alterar");
	
		return repo.save(atividadeAtual);
	}
	
	
	public Categoria buscarOuFalhar(int id) {
		return repo.findById(id)
				.orElseThrow(() -> new EntidadeNaoEncontradaExcepition(String.format("Categoria não encontrada", id)));
	}

}
