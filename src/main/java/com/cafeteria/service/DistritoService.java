package com.cafeteria.service;

import java.util.List;

import com.cafeteria.model.Distrito;

public interface DistritoService {
	
	public List<Distrito> listarTodos();
	
	public Distrito registrar(Distrito obj);

    public Distrito actualizar(int IDdistrito, Distrito distritoActualizado);

    public void eliminar(int IDdistrito);
    
    public Distrito buscarPorId(int IDdistrito);

}