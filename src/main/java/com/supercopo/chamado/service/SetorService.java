package com.supercopo.chamado.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.supercopo.chamado.domain.LogSistema;
import com.supercopo.chamado.domain.Sac;
import com.supercopo.chamado.domain.Setor;
import com.supercopo.chamado.domain.dto.flat.SacFlat;
import com.supercopo.chamado.domain.dto.flat.SetorFlat;
import com.supercopo.chamado.repository.LogSistemaRepository;
import com.supercopo.chamado.repository.SetorRepository;
import com.supercopo.chamado.service.exception.EntidadeNaoEncontradaExcepition;
import com.supercopo.chamado.service.util.Tenantuser;

@Service
public class SetorService {

	@Autowired
	private SetorRepository repo;
	
	@Autowired
	private Tenantuser tenantUsuario;
	
	@Autowired
	private LogSistemaService log;
	
	@Autowired
	private LogSistemaRepository repolog;

	public List<SetorFlat> findAll() {
		List<Setor> setor = repo.findAllAtivas();
		List<SetorFlat> listempFlat = new ArrayList<>();
		for (Setor e : setor) {
			SetorFlat empflat = new SetorFlat(e);
			listempFlat.add(empflat);
		}
		return listempFlat;
	}

	public SetorFlat findAllSetor(Integer id) {
		Setor obj = repo.buscarId(id);

		SetorFlat sf = new SetorFlat(obj);

		return sf;
	}

	public List<SetorFlat> findAllInativos() {
		List<Setor> emp = repo.findAllInativos();
		List<SetorFlat> listempFlat = new ArrayList<>();
		for(Setor e: emp) {
			SetorFlat empflat = new SetorFlat(e);
			listempFlat.add(empflat);
		}
		return listempFlat;
	}
	
	@Transactional
	public Setor insert(Setor setor) {
		setor.setId(null);
		setor.setTenant(tenantUsuario.buscarOuFalhar());
		repo.save(setor);
		logSetor(setor, "inserir");
		return setor;
	}
	
	
	private void logSetor(Setor obj, String string) {
		LogSistema logsistema = log.insert(obj, string);
		logsistema.setSetor(obj);
		repolog.save(logsistema);

	}
	
	public Setor from(Setor atividadeNovo) {
		Setor atividadeAtual = buscarOuFalhar(atividadeNovo.getId());
		atividadeAtual.setTenant(tenantUsuario.buscarOuFalhar());
		
		BeanUtils.copyProperties(atividadeNovo, atividadeAtual, "id");
		atividadeAtual.setTenant(tenantUsuario.buscarOuFalhar());
		logSetor(atividadeAtual, "alterar");
	
		return repo.save(atividadeAtual);
	}
	
	public Setor buscarOuFalhar(int id) {
		return repo.findById(id)
				.orElseThrow(() -> new EntidadeNaoEncontradaExcepition(String.format("Setor não encontrada", id)));
	}


	
	
}
