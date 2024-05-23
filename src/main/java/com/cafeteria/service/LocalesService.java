package com.cafeteria.service;

import java.util.List;

import com.cafeteria.model.Locales;

public interface LocalesService {
	
	public List<Locales> listarTodos();
	
	public Locales registrar(Locales obj);

    public Locales actualizar(int id, Locales localesActualizado);

    public void eliminar(int id);
    
    public Locales buscarPorId(int id);

}
