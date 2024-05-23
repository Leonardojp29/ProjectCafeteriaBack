package com.cafeteria.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cafeteria.model.TipoUsuario;
import com.cafeteria.repository.ITipoUsuarioRepository;

@Service
public class TipoUsuarioServiceImpl implements TipoUsuarioService {

	@Autowired
	private ITipoUsuarioRepository TipoUsuario;
	
	@Override
	public List<TipoUsuario> listarTodos() {
		return TipoUsuario.findAll();
	}

	
    @Override
    public TipoUsuario buscarPorId(int id) {
        Optional<TipoUsuario> tipoUsuario = TipoUsuario.findById(id);
        return tipoUsuario.orElseThrow(() -> new RuntimeException("TipoUsuario no encontrado con ID: " + id));
    }
}