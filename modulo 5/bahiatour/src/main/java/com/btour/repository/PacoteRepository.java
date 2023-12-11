package com.btour.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.btour.model.Pacote;

@Repository
public interface PacoteRepository extends JpaRepository<Pacote, Long>{

	
	 List<Pacote> findByDestino(String destino);
}
