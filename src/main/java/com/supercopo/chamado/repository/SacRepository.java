package com.supercopo.chamado.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.supercopo.chamado.domain.Sac;

@Repository
public interface SacRepository extends JpaRepository<Sac, Integer>{
	
	@Query(value = "select * from sac ", nativeQuery = true)
	List<Sac> finfALLSQL();
	
	@Query(value= "select * from sac where status = 1 order by id desc", nativeQuery = true)
	List<Sac> findAllAtivas();
	
	
	@Query(value= "select * from sac where status = 0 order by id desc", nativeQuery = true)
	List<Sac> findAllInativos();
	
	
	@Query(value= "select * from sac where tenant_id = ?", nativeQuery = true)
	List<Sac> convenio(Integer tenant);
	
	
	 @Query(value= "select * from sac where tenant_id = ?", nativeQuery = true)
	List<Sac> sac(Integer tenant);
	 
	 

	@Query(value= "select * from sac where id = ?", nativeQuery = true)
	Sac buscarId(Integer id);

}
