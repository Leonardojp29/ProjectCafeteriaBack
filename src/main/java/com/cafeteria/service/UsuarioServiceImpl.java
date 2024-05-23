package com.cafeteria.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cafeteria.model.Usuario;
import com.cafeteria.repository.IUsuarioRepository;

@Service
public class UsuarioServiceImpl implements UsuarioService {
	
	@Autowired
	private IUsuarioRepository Usuario;
	
	@Override
	public List<Usuario> listarTodos() {
		return Usuario.findAll();
	}

	@Override
	public Usuario registrar(Usuario obj) {
		return Usuario.save(obj);
	}
	
	@Override
    public Usuario actualizar(int id, Usuario usuarioActualizado) {
        Optional<Usuario> usuarioExistente = Usuario.findById(id);

        if (usuarioExistente.isPresent()) {
        	Usuario usuario = usuarioExistente.get();
        	usuario.setNombre(usuarioActualizado.getNombre());
        	usuario.setApellido(usuarioActualizado.getApellido());        	
        	usuario.setEmail(usuarioActualizado.getEmail());
        	usuario.setUsuario(usuarioActualizado.getUsuario());
            usuario.setPassword(usuarioActualizado.getPassword());
            usuario.setTipoUsuario_ID(usuarioActualizado.getTipoUsuario_ID());
            return Usuario.save(usuario);
        } else {
            throw new RuntimeException("Usuario no encontrado con ID: " + id);
        }
    }

    @Override
    public void eliminar(int id) {
        Optional<Usuario> usuarioExistente = Usuario.findById(id);

        if (usuarioExistente.isPresent()) {
        	Usuario.deleteById(id);
        } else {
            throw new RuntimeException("Usuario no encontrado con ID: " + id);
        }
    }
    
    
    @Override
    public Usuario buscarPorId(int id) {
        Optional<Usuario> usuario = Usuario.findById(id);
        return usuario.orElseThrow(() -> new RuntimeException("Usuario no encontrado con ID: " + id));
    }
	
}
