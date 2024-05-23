package com.cafeteria.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cafeteria.model.Categoria;

public interface ICategoriaRepository extends JpaRepository<Categoria, Integer> {

}
