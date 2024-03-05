package com.supercopo.chamado.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.supercopo.chamado.domain.Chamado;

@Repository
public interface ChamadoRepository extends JpaRepository<Chamado, Integer>{
	
	@Query(value = "select * from chamado where status = 1 and tenant_id = ? order by id desc",nativeQuery = true)
	List<Chamado> findAllAtivas(int id);
	
	@Query(value = "select * from chamado where id = ?",nativeQuery = true)
	Chamado buscarId(Integer id);
	
	@Query(value = "select * from chamado where status = 0 and tenant_id = ? order by id desc",nativeQuery = true)
	List<Chamado> findAllInativos(int id);

}
