package com.supercopo.chamado.repository;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.supercopo.chamado.domain.Empresa;

@Repository
public interface EmpresaRepository extends JpaRepository<Empresa, Integer>{

	@Query(value= "select * from empresa where status = 1 order by id desc", nativeQuery = true)
	List<Empresa> findAllAtivas();
	
	@Query(value= "select * from empresa where id = ?", nativeQuery = true)
	Empresa find(int id);
	
	
	@Query(value= "select * from empresa where gtenant_id in (\r\n"
			+ "SELECT gtenant_id FROM usuario_empresa where id_usuario = ?)", nativeQuery = true)
	List<Empresa> findAllSqlUsuario(Integer id);
	
	@Query(value= "select * from empresa where tenant_id in (\r\n"
			+ "SELECT tenant_id FROM usuario_empresa where id_usuario = ?)", nativeQuery = true)
	List<Empresa> findAllSqlEmpUsuario(Integer id);
	
	@Query(value= "select * from empresa where status = 0 order by id desc", nativeQuery = true)
	List<Empresa> findAllInativos();
	
	@Query(value= "	select max(tenant_id + 1) from empresa", nativeQuery = true)
	Integer tenantMaisUm();
	
	@Query(value= "select * from empresa where tenant_id = ?", nativeQuery = true)
	Empresa findEmpPorTenantAtivo(Integer tenantativo);
	
	@Query(value= "select * from empresa where id = ?", nativeQuery = true)
	Empresa findPorId(int id);
	
	@Query(value= "select tenant_id from empresa where id = ?", nativeQuery = true)
	Integer buscarTenant(int idempresa);
	
	@Transactional(readOnly = true)
	Empresa findByCpfoucnpj(String cpfoucnpj);


}
