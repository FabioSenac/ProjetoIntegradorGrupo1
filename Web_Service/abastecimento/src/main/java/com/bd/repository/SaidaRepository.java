package com.bd.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.bd.model.Abastecimento;



public interface SaidaRepository extends CrudRepository<Abastecimento, Long> {
	@Query(value = " Select * from abastecimento WHERE vei_id= ?1",
			  nativeQuery = true)
			List<Abastecimento> findAllBy(Long vei_id);
}
