package com.btour.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.btour.model.Reserva;


@Repository
public interface ReservaRepository extends JpaRepository<Reserva, Long>{

}
