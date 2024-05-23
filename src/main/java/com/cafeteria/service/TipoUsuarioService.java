package com.cafeteria.service;

import java.util.List;

import com.cafeteria.model.TipoUsuario;

public interface TipoUsuarioService {
	
	public List<TipoUsuario> listarTodos();	
    
    public TipoUsuario buscarPorId(int id);
}
