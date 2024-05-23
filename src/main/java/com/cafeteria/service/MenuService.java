package com.cafeteria.service;

import java.util.List;

import com.cafeteria.model.Menu;

public interface MenuService {
	
	public List<Menu> listarTodos();
	
	public Menu registrar(Menu obj);

    public Menu actualizar(int id, Menu menuActualizado);

    public void eliminar(int id);
    
    public Menu buscarPorId(int id);

}

