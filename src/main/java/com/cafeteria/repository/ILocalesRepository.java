package com.cafeteria.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cafeteria.model.Locales;

@Repository
public interface ILocalesRepository extends JpaRepository<Locales, Integer>{

}

