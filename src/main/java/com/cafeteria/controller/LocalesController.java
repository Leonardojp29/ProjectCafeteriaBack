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

import com.cafeteria.model.Locales;
import com.cafeteria.service.LocalesService;


@RestController
@RequestMapping("/api/locales")
@CrossOrigin(origins = "http://localhost:4200")
public class LocalesController {

	@Autowired
	private LocalesService service;

	@GetMapping
	@ResponseBody
	public ResponseEntity<List<Locales>> listarLocales() {
		return ResponseEntity.ok(service.listarTodos());
	}
	
	@PostMapping
	public ResponseEntity<Locales> registrar(@RequestBody Locales locales){
		Locales nuevo = service.registrar(locales);
		return new ResponseEntity<>(nuevo, HttpStatus.CREATED);
	}
	
    @PutMapping("/{id}")
    public ResponseEntity<Locales> actualizar(@PathVariable("id") int id, 
                                          @RequestBody Locales localesActualizado) {
    	Locales actualizado = service.actualizar(id, localesActualizado);
        return ResponseEntity.ok(actualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable("id") int id) {
        service.eliminar(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Locales> buscarLocalesPorId(@PathVariable("id") int id) {
    	Locales locales = service.buscarPorId(id);
        return ResponseEntity.ok(locales);
    }

}
