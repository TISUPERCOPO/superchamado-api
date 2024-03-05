package com.supercopo.chamado.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.supercopo.chamado.domain.Categoria;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Integer>{
	
	@Query(value = "select * from categoria where status = 1 order by id desc",nativeQuery = true)
	List<Categoria> findAllAtivas();

	@Query(value = "select * from categoria where id = ?",nativeQuery = true)
	Categoria buscarId(Integer id);
	
	@Query(value = "select * from categoria where status = 0 order by id desc",nativeQuery = true)
	List<Categoria> findAllInativos();

}
