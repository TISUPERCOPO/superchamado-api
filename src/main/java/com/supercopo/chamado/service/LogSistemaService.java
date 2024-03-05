package com.supercopo.chamado.service;

import java.time.OffsetDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.supercopo.chamado.domain.Categoria;
import com.supercopo.chamado.domain.Chamado;
import com.supercopo.chamado.domain.Empresa;
import com.supercopo.chamado.domain.LogSistema;
import com.supercopo.chamado.domain.Permissao;
import com.supercopo.chamado.domain.Sac;
import com.supercopo.chamado.domain.Setor;
import com.supercopo.chamado.domain.Usuario;
import com.supercopo.chamado.security.DaringSecurity;

@Service
public class LogSistemaService {
    @Autowired
	private DaringSecurity daringSecurity;

//	public LogSistema insert(Convenio obj, String acao) {
//        String usuarioLogado = daringSecurity.getUsuario();
//        
//	    String comando = (acao + "  " + obj.toString());
//		LogSistema log = new LogSistema(null,usuarioLogado,comando,OffsetDateTime.now(),obj);
//		return log;		
//	}
//	public LogSistema insert(Patrimonio obj, String acao) {
//        String usuarioLogado = daringSecurity.getUsuario();        
//	    String comando = (acao + "  " + obj.toString());
//		LogSistema log = new LogSistema(null,usuarioLogado,comando,OffsetDateTime.now(),obj);
//		return log;		
//	}
//	
//	public LogSistema insert(Atendimento obj, String acao) {
//        String usuarioLogado = daringSecurity.getUsuario();
//        
//	    String comando = (acao + "  " + obj.toString());
//		LogSistema log = new LogSistema(null,usuarioLogado,comando,OffsetDateTime.now(),obj);
//		return log;		
//	}
//	public LogSistema insert(Paciente obj, String acao) {
//        String usuarioLogado = daringSecurity.getUsuario();        
//	    String comando = (acao + "  " + obj.toString());
//		LogSistema log = new LogSistema(null,usuarioLogado,comando,OffsetDateTime.now(),obj);
//		return log;		
//	}
//	
//	public LogSistema insert(Exame obj, String acao) {
//        String usuarioLogado = daringSecurity.getUsuario();        
//	    String comando = (acao + "  " + obj.toString());
//		LogSistema log = new LogSistema(null,usuarioLogado,comando,OffsetDateTime.now(),obj);
//		return log;		
//	}

    public LogSistema insertUsu(Usuario obj, String string) {
        String usuarioLogado = daringSecurity.getUsuario();
        
	    String comando = (string + "  " + obj.toString());
		LogSistema log = new LogSistema(null,usuarioLogado,comando,OffsetDateTime.now(),obj);
		return log;	
	}
    
    public LogSistema insert(Permissao obj, String string) {
        String usuarioLogado = daringSecurity.getUsuario();
        
	    String comando = (string + "  " + obj.toString());
		LogSistema log = new LogSistema(null,usuarioLogado,comando,OffsetDateTime.now(),obj);
		return log;	
	}
    
	public LogSistema insert(Empresa obj, String string) {
		String usuarioLogado = daringSecurity.getUsuario();
		
	    String comando = (string + obj.toString());
		LogSistema log = new LogSistema(null,usuarioLogado,comando,OffsetDateTime.now(),obj);
		return log;
	}
	
	public LogSistema insert(Sac obj, String string) {
		String usuarioLogado = daringSecurity.getUsuario();
		
		String comando = (string + obj.toString());
		LogSistema log = new LogSistema(null,usuarioLogado,comando,OffsetDateTime.now(),obj);
		return log;
	}
	
	 public LogSistema insert(Setor obj, String string) {
	        String usuarioLogado = daringSecurity.getUsuario();
	        
		    String comando = (string + "  " + obj.toString());
			LogSistema log = new LogSistema(null,usuarioLogado,comando,OffsetDateTime.now(),obj);
			return log;	
		}
	 
	 public LogSistema insert(Categoria obj, String string) {
	        String usuarioLogado = daringSecurity.getUsuario();
	        
		    String comando = (string + "  " + obj.toString());
			LogSistema log = new LogSistema(null,usuarioLogado,comando,OffsetDateTime.now(),obj);
			return log;	
		}
	 
	 public LogSistema insert(Chamado obj, String string) {
	        String usuarioLogado = daringSecurity.getUsuario();
	        
		    String comando = (string + "  " + obj.toString());
			LogSistema log = new LogSistema(null,usuarioLogado,comando,OffsetDateTime.now(),obj);
			return log;	
		}

}
