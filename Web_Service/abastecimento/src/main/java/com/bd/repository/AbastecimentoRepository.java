package com.bd.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bd.model.Abastecimento;
import com.bd.model.SaidaAbast;

public interface AbastecimentoRepository extends JpaRepository<Abastecimento, Long>{

	
//	SaidaAbast criarRelatorio(long vei_id);
}
