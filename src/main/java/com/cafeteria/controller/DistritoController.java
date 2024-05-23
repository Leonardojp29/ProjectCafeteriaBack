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

import com.cafeteria.model.Distrito;
import com.cafeteria.service.DistritoService;

@RestController
@RequestMapping("/api/distritos")
@CrossOrigin(origins = "http://localhost:4200")
public class DistritoController {
	
	@Autowired
	private DistritoService service;

	@GetMapping
	@ResponseBody
	public ResponseEntity<List<Distrito>> listarDistritos() {
		return ResponseEntity.ok(service.listarTodos());
	}
	
	@PostMapping
	public ResponseEntity<Distrito> registrar(@RequestBody Distrito distrito){
		Distrito nuevo = service.registrar(distrito);
		return new ResponseEntity<>(nuevo, HttpStatus.CREATED);
	}
	
    @PutMapping("/{IDdistrito}")
    public ResponseEntity<Distrito> actualizar(@PathVariable("IDdistrito") int IDdistrito, 
                                          @RequestBody Distrito distritoActualizado) {
    	Distrito actualizado = service.actualizar(IDdistrito, distritoActualizado);
        return ResponseEntity.ok(actualizado);
    }

    @DeleteMapping("/{IDdistrito}")
    public ResponseEntity<Void> eliminar(@PathVariable("IDdistrito") int IDdistrito) {
        service.eliminar(IDdistrito);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    @GetMapping("/{IDdistrito}")
    public ResponseEntity<Distrito> buscarCategoriaPorId(@PathVariable("IDdistrito") int IDdistrito) {
    	Distrito distrito = service.buscarPorId(IDdistrito);
        return ResponseEntity.ok(distrito);
    }
}
