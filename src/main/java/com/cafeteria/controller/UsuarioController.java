package com.cafeteria.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.cafeteria.model.Usuario;
import com.cafeteria.service.UsuarioService;

@RestController
@RequestMapping("/api/usuarios")
@CrossOrigin(origins = "http://localhost:4200")
public class UsuarioController {
	
	@Autowired
	private UsuarioService service;

	@GetMapping
	@ResponseBody
	public ResponseEntity<List<Usuario>> listarUsuarios() {
		return ResponseEntity.ok(service.listarTodos());
	}
	
	@PostMapping
	public ResponseEntity<Usuario> registrar(@RequestBody Usuario usuario){
		Usuario nuevo = service.registrar(usuario);
		return new ResponseEntity<>(nuevo, HttpStatus.CREATED);
	}
	
    @PutMapping("/{id}")
    public ResponseEntity<Usuario> actualizar(@PathVariable("id") int id, 
                                          @RequestBody Usuario usuarioActualizado) {
    	Usuario actualizado = service.actualizar(id, usuarioActualizado);
        return ResponseEntity.ok(actualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable("id") int id) {
        service.eliminar(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Usuario> buscarUsuarioPorId(@PathVariable("id") int id) {
    	Usuario usuario = service.buscarPorId(id);
        return ResponseEntity.ok(usuario);
    }
	
	
}
