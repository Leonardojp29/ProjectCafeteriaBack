package com.cafeteria.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cafeteria.model.Reserva;

@Repository
public interface IReservaRepository extends JpaRepository<Reserva, Integer>{

}
