package com.cafeteria.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.cafeteria.model.TipoUsuario;
import com.cafeteria.service.TipoUsuarioService;

@RestController
@RequestMapping("/api/tipousuarios")
@CrossOrigin(origins = "http://localhost:4200")
public class TipoUsuarioController {

	@Autowired
	private TipoUsuarioService service;

	@GetMapping
	@ResponseBody
	public ResponseEntity<List<TipoUsuario>> listarTipoUsuarios() {
		return ResponseEntity.ok(service.listarTodos());
	}	
	
    @GetMapping("/{id}")
    public ResponseEntity<TipoUsuario> buscarTipoUsuarioPorId(@PathVariable("id") int id) {
    	TipoUsuario tipoUsuario = service.buscarPorId(id);
        return ResponseEntity.ok(tipoUsuario);
    }
	
}

