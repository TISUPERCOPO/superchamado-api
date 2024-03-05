package com.supercopo.chamado.service.rels;
import java.io.InputStream;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.supercopo.chamado.domain.Sac;
import com.supercopo.chamado.domain.Usuario;
import com.supercopo.chamado.domain.dto.rel.SacRel;
import com.supercopo.chamado.domain.dto.rel.UsuRel;
import com.supercopo.chamado.repository.SacRepository;
import com.supercopo.chamado.repository.UsuarioRepository;

import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

@Service
public class RelAtendimento {

	@Autowired
	private UsuarioRepository repoUsu;
	
	@Autowired
	private SacRepository reposac;


	public byte[] sac(Integer tenant) throws Exception {
		List<Sac> sacs = reposac.sac(tenant);
		List<SacRel> convrels = new ArrayList<SacRel>();
		for(Sac sac: sacs) {
			SacRel convrel = new SacRel(sac);
			convrels.add(convrel);
			}		
		
			        
		Map<String, Object> parametros = new HashMap<>();
		parametros.put("tenant", (tenant));
		parametros.put("REPORT_LOCALE", new Locale("pt", "BR"));
		
		
		InputStream inputStream = this.getClass().getResourceAsStream(
				"/rel/sac.jasper");		
		JRBeanCollectionDataSource jrb = new JRBeanCollectionDataSource(convrels, false);
		JasperPrint jasperPrint = JasperFillManager.fillReport(inputStream, parametros,jrb);
		
		return JasperExportManager.exportReportToPdf(jasperPrint);
		
	

	}


	public byte[] usuario(Integer tenant) throws Exception {
		List<Usuario> listUsu = repoUsu.findAllList(tenant);
		List<UsuRel>listusurel = new ArrayList<UsuRel>();
		for (Usuario usu:listUsu ) {
			UsuRel usurel = new UsuRel(usu);
			listusurel.add(usurel);
		}
//		
			        
		Map<String, Object> parametros = new HashMap<>();
		parametros.put("tenant", (tenant));
		parametros.put("REPORT_LOCALE", new Locale("pt", "BR"));
		
		
		InputStream inputStream = this.getClass().getResourceAsStream(
				"/rel/usuarios.jasper");		
		JRBeanCollectionDataSource jrb = new JRBeanCollectionDataSource(listusurel, false);
		JasperPrint jasperPrint = JasperFillManager.fillReport(inputStream, parametros,jrb);
		
		return JasperExportManager.exportReportToPdf(jasperPrint);
		
	}


}