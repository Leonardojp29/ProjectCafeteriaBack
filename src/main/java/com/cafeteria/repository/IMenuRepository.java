package com.cafeteria.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cafeteria.model.Menu;

@Repository
public interface IMenuRepository extends JpaRepository<Menu, Integer>{

}
