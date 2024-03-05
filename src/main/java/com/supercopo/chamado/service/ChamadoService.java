package com.supercopo.chamado.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.supercopo.chamado.domain.Chamado;
import com.supercopo.chamado.domain.LogSistema;
import com.supercopo.chamado.domain.dto.flat.ChamadoFlat;
import com.supercopo.chamado.repository.CategoriaRepository;
import com.supercopo.chamado.repository.ChamadoRepository;
import com.supercopo.chamado.repository.LogSistemaRepository;
import com.supercopo.chamado.repository.SetorRepository;
import com.supercopo.chamado.service.exception.EntidadeNaoEncontradaExcepition;
import com.supercopo.chamado.service.util.Tenantuser;

@Service
public class ChamadoService {
	
	@Autowired
	private ChamadoRepository repo;
	
	@Autowired
	private CategoriaRepository repoCategoria;
	
	@Autowired
	private SetorRepository repoSetor;
	
	@Autowired
	private Tenantuser tenantUsuario;

	@Autowired
	private LogSistemaService log;

	@Autowired
	private LogSistemaRepository repolog;

	public List<ChamadoFlat> findAll() {
		List<Chamado> chamado = repo.findAllAtivas(tenantUsuario.buscarOuFalharInt());
		List<ChamadoFlat> listempFlat = new ArrayList<>();
		for (Chamado e : chamado) {
			ChamadoFlat empflat = new ChamadoFlat(e);
			listempFlat.add(empflat);
		}
		return listempFlat;
	}

	public ChamadoFlat findAllChamado(Integer id) {
		Chamado obj = repo.buscarId(id);

		ChamadoFlat cf = new ChamadoFlat(obj);
		return cf;
	}

	public List<ChamadoFlat> findAllInativos() {
		List<Chamado> emp = repo.findAllInativos(tenantUsuario.buscarOuFalharInt());
		List<ChamadoFlat> listempFlat = new ArrayList<>();
		for (Chamado e : emp) {
			ChamadoFlat empflat = new ChamadoFlat(e);
			listempFlat.add(empflat);
		}
		return listempFlat;
	}
	
	@Transactional
	public ChamadoFlat insert(ChamadoFlat novoobj) {
		Chamado ch = new Chamado();
		ch.setCategoria(novoobj.getCategoria());
		ch.setSetor(novoobj.getSetor());
		ch.setTenant(tenantUsuario.buscarOuFalhar());
		ch.setDescricao(novoobj.getDescricao());
		ch.setTitulo(novoobj.getTitulo());
		ch.setStatus(novoobj.getStatus());
		ch.setUrgencia(novoobj.getUrgencia());
		repo.save(ch);
		logChamado(ch, "inserir");
		return novoobj;
	}
	
	
	private void logChamado(Chamado obj, String string) {
		LogSistema logsistema = log.insert(obj, string);
		logsistema.setChamado(obj);
		repolog.save(logsistema);

	}
	
	
	public Chamado from(Chamado atividadeNovo) {
		Chamado atividadeAtual = buscarOuFalhar(atividadeNovo.getId());
		atividadeAtual.setTenant(tenantUsuario.buscarOuFalhar());
		
		BeanUtils.copyProperties(atividadeNovo, atividadeAtual, "id");
		atividadeAtual.setTenant(tenantUsuario.buscarOuFalhar());
		logChamado(atividadeAtual, "alterar");
	
		return repo.save(atividadeAtual);
	}
	
	
	public Chamado buscarOuFalhar(int id) {
		return repo.findById(id)
				.orElseThrow(() -> new EntidadeNaoEncontradaExcepition(String.format("Chamado não encontrada", id)));
	}


}
