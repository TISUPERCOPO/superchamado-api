package com.supercopo.chamado.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.supercopo.chamado.domain.LogSistema;


@Repository
public interface LogSistemaRepository extends JpaRepository<LogSistema, Integer> {
	
}