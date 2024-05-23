package com.cafeteria.service;

import java.util.List;

import com.cafeteria.model.Usuario;

public interface UsuarioService {
	
	public List<Usuario> listarTodos();
	
	public Usuario registrar(Usuario obj);

    public Usuario actualizar(int id, Usuario usuarioActualizado);

    public void eliminar(int id);
    
    public Usuario buscarPorId(int id);
}
