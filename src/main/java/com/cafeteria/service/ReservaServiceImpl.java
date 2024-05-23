package com.cafeteria.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cafeteria.model.Reserva;
import com.cafeteria.repository.IReservaRepository;

@Service
public class ReservaServiceImpl implements ReservaService {

	@Autowired
	private IReservaRepository Reserva;
	
	@Override
	public List<Reserva> listarTodos() {
		return Reserva.findAll();
	}

	@Override
	public Reserva registrar(Reserva obj) {
		return Reserva.save(obj);
	}

	@Override
    public Reserva actualizar(int id, Reserva reservaActualizado) {
        Optional<Reserva> reservaExistente = Reserva.findById(id);

        if (reservaExistente.isPresent()) {
        	Reserva reserva = reservaExistente.get();
        	reserva.setNombre(reservaActualizado.getNombre());
        	reserva.setCorreo(reservaActualizado.getCorreo());
        	reserva.setTelefono(reservaActualizado.getTelefono());
        	reserva.setCantidad(reservaActualizado.getCantidad());
        	reserva.setFecha(reservaActualizado.getFecha());
        	reserva.setHora(reservaActualizado.getHora());
        	reserva.setMensaje(reservaActualizado.getMensaje());
            return Reserva.save(reserva);
        } else {
            throw new RuntimeException("Reserva no encontrada con ID: " + id);
        }
    }

    @Override
    public void eliminar(int id) {
        Optional<Reserva> reservaExistente = Reserva.findById(id);

        if (reservaExistente.isPresent()) {
        	Reserva.deleteById(id);
        } else {
            throw new RuntimeException("Reserva no encontrada con ID: " + id);
        }
    }
    
    @Override
    public Reserva buscarPorId(int id) {
        Optional<Reserva> reserva = Reserva.findById(id);
        return reserva.orElseThrow(() -> new RuntimeException("Reserva no encontrado con ID: " + id));
    }
}
