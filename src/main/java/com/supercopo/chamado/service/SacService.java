package com.supercopo.chamado.service;


import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.supercopo.chamado.domain.LogSistema;
import com.supercopo.chamado.domain.Sac;
import com.supercopo.chamado.domain.SacNew;
import com.supercopo.chamado.domain.dto.flat.SacFlat;
import com.supercopo.chamado.repository.LogSistemaRepository;
import com.supercopo.chamado.repository.SacRepository;
import com.supercopo.chamado.service.exception.EntidadeNaoEncontradaExcepition;
import com.supercopo.chamado.service.util.Tenantuser;

@Service
public class SacService {
	
	@Autowired
	private SacRepository repo;
	
	@Autowired
	private Tenantuser tenantUsuario;
	
	@Autowired
	private LogSistemaService log;
	
	@Autowired
	private LogSistemaRepository repolog;
	
	
	public List<Sac> findALLSQL() {
		List<Sac> lista = repo.finfALLSQL();
		
		return lista;
	}
	
	
	public List<SacFlat> findAll() {
		List<Sac> sac = repo.findAllAtivas();
		List<SacFlat> listempFlat = new ArrayList<>();
		for(Sac e: sac) {
			SacFlat empflat = new SacFlat(e);
			listempFlat.add(empflat);
		}
		return listempFlat;
	}
	
	
	public List<SacFlat> findAllInativos() {
		List<Sac> emp = repo.findAllInativos();
		List<SacFlat> listempFlat = new ArrayList<>();
		for(Sac e: emp) {
			SacFlat empflat = new SacFlat(e);
			listempFlat.add(empflat);
		}
		return listempFlat;
	}
	
	@Transactional
	public Sac insert(Sac sac) {
		sac.setId(null);
		sac.setTenant(tenantUsuario.buscarOuFalhar());
		System.out.println(sac.getTenant());
		repo.save(sac);
		logSac(sac, "inserir");
		return sac;
	}
	
	private void logSac(Sac obj, String string) {
		LogSistema logsistema = log.insert(obj, string);
		logsistema.setSac(obj);
		repolog.save(logsistema);

	}
	
	
	public SacFlat findAllSac(Integer id) {
		
		Sac obj = repo.buscarId(id);
		
		SacFlat sf = new SacFlat(obj);
		
		return sf;

	}
	
	public Sac from(Sac atividadeNovo) {
		Sac atividadeAtual = buscarOuFalhar(atividadeNovo.getId());
		atividadeAtual.setTenant(tenantUsuario.buscarOuFalhar());
		
		BeanUtils.copyProperties(atividadeNovo, atividadeAtual, "id");
		atividadeAtual.setTenant(tenantUsuario.buscarOuFalhar());
		logSac(atividadeAtual, "alterar");
	
		return repo.save(atividadeAtual);
	}


	public Sac buscarOuFalhar(int id) {
		return repo.findById(id)
				.orElseThrow(() -> new EntidadeNaoEncontradaExcepition(String.format("Sac não encontrada", id)));
	}

	
	
}
