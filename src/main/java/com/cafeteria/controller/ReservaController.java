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

import com.cafeteria.model.Reserva;
import com.cafeteria.service.ReservaService;


@RestController
@RequestMapping("/api/reservas")
@CrossOrigin(origins = "http://localhost:4200")
public class ReservaController {

	@Autowired
	private ReservaService service;

	@GetMapping
	@ResponseBody
	public ResponseEntity<List<Reserva>> listarReservas() {
		return ResponseEntity.ok(service.listarTodos());
	}
	
	@PostMapping
	public ResponseEntity<Reserva> registrar(@RequestBody Reserva reserva){
		Reserva nuevo = service.registrar(reserva);
		return new ResponseEntity<>(nuevo, HttpStatus.CREATED);
	}
	
    @PutMapping("/{id}")
    public ResponseEntity<Reserva> actualizar(@PathVariable("id") int id, 
                                          @RequestBody Reserva reservaActualizado) {
    	Reserva actualizado = service.actualizar(id, reservaActualizado);
        return ResponseEntity.ok(actualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable("id") int id) {
        service.eliminar(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Reserva> buscarReservaPorId(@PathVariable("id") int id) {
    	Reserva reserva = service.buscarPorId(id);
        return ResponseEntity.ok(reserva);
    }

}
