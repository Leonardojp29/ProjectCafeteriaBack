package com.cafeteria.service;

import java.util.List;

import com.cafeteria.model.Categoria;

public interface CategoriaMenuService {
	
	public List<Categoria> listarTodos();
	
	public Categoria registrar(Categoria obj);

    public Categoria actualizar(int idcategoria, Categoria categoriaActualizado);

    public void eliminar(int idcategoria);
    
    public Categoria buscarPorId(int idcategoria);

}

