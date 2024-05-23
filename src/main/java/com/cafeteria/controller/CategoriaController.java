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

import com.cafeteria.model.Categoria;
import com.cafeteria.service.CategoriaMenuService;

@RestController
@RequestMapping("/api/categorias")
@CrossOrigin(origins = "http://localhost:4200")
public class CategoriaController {
	
	@Autowired
	private CategoriaMenuService service;

	@GetMapping
	@ResponseBody
	public ResponseEntity<List<Categoria>> listarCategorias() {
		return ResponseEntity.ok(service.listarTodos());
	}
	
	@PostMapping
	public ResponseEntity<Categoria> registrar(@RequestBody Categoria categoria){
		Categoria nuevo = service.registrar(categoria);
		return new ResponseEntity<>(nuevo, HttpStatus.CREATED);
	}
	
    @PutMapping("/{idcategoria}")
    public ResponseEntity<Categoria> actualizar(@PathVariable("idcategoria") int idcategoria, 
                                          @RequestBody Categoria categoriaActualizado) {
    	Categoria actualizado = service.actualizar(idcategoria, categoriaActualizado);
        return ResponseEntity.ok(actualizado);
    }

    @DeleteMapping("/{idcategoria}")
    public ResponseEntity<Void> eliminar(@PathVariable("idcategoria") int idcategoria) {
        service.eliminar(idcategoria);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    @GetMapping("/{idcategoria}")
    public ResponseEntity<Categoria> buscarCategoriaPorId(@PathVariable("idcategoria") int idcategoria) {
    	Categoria categoria = service.buscarPorId(idcategoria);
        return ResponseEntity.ok(categoria);
    }
}
