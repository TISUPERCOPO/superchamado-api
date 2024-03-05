package com.supercopo.chamado.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.supercopo.chamado.domain.Setor;

@Repository
public interface SetorRepository extends JpaRepository<Setor, Integer>{
	
	
	@Query(value = "select * from setor where status = 1 order by id desc",nativeQuery = true)
	List<Setor> findAllAtivas();
	
	@Query(value = "select * from setor where id = ?",nativeQuery = true)
	Setor buscarId(Integer id);
	
	@Query(value= "select * from setor where status = 0 order by id desc", nativeQuery = true)
	List<Setor> findAllInativos();

}
