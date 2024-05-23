package com.cafeteria.service;

import java.util.List;

import com.cafeteria.model.Reserva;

public interface ReservaService {
	
	public List<Reserva> listarTodos();
	
	public Reserva registrar(Reserva obj);

    public Reserva actualizar(int id, Reserva reservaActualizado);

    public void eliminar(int id);
    
    public Reserva buscarPorId(int id);

}
