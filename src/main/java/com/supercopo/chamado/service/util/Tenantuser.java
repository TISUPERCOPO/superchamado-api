package com.supercopo.chamado.service.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.supercopo.chamado.domain.Tenant;
import com.supercopo.chamado.domain.Usuario;
import com.supercopo.chamado.repository.TenantRepository;
import com.supercopo.chamado.repository.UsuarioRepository;
import com.supercopo.chamado.security.DaringSecurity;

@Service
public class Tenantuser {

	@Autowired
	private UsuarioRepository repoUsu;
	@Autowired
	private TenantRepository repotenant;
	
	@Autowired
	private DaringSecurity daringSecurity;
	
	
	public Tenant buscarOuFalhar() {
		String login = daringSecurity.getUsuario();
		Integer codigo = repoUsu.buscarTenant(login);
		Tenant t = repotenant.findPorId(codigo);		
		return t;
	}
	public String buscarEmailUsuToken() {
		String email = daringSecurity.getUsuario();			
		return email;
	}
	public Integer buscarOuFalharGtenant() {
		String login = daringSecurity.getUsuario();
		Integer codigo = repoUsu.buscarGTenant(login);
		
		return codigo;
	}
	public Integer buscarOuFalharGtenantID() {
		String login = daringSecurity.getUsuario();
		Integer codigo = repoUsu.buscarGTenantId(login);		
		return codigo;
	}
	
	
	public Integer buscarOuFalharInt() {
		String login = daringSecurity.getUsuario();
		Integer codigo = repoUsu.buscarTenant(login);
		Tenant t = new Tenant();
		t.setId(codigo);
		return codigo;
	}
	
	public Usuario buscarUsuario() {
		String login = daringSecurity.getUsuario();
		Usuario usu = repoUsu.findPorLogin(login);	
		return usu;
	}
	
	public String tenantOuGtenant() {
		String retorno = "tenant_id";
		String login = daringSecurity.getUsuario();
		Usuario usu = repoUsu.findPorLogin(login);
		if(usu.getGtenantativo() == 0 ) {
			retorno = "tenant_id";
		}else {
			retorno = "gtenant_id";
		}
		return retorno;
	}
	public Integer buscarGtenantdoCadastrodeUsu() {
		String login = daringSecurity.getUsuario();
		Integer gtenant = repoUsu.findPorGtwenantPelologin(login);
		return gtenant;
	}
	
	
}
