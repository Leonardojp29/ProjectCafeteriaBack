package com.cafeteria.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cafeteria.model.Distrito;
import com.cafeteria.repository.IDistritoRepository;

@Service
public class DistritoServiceImpl implements DistritoService {

	@Autowired
	private IDistritoRepository Distrito;
	
	@Override
	public List<Distrito> listarTodos() {
		return Distrito.findAll();
	}

	@Override
	public Distrito registrar(Distrito obj) {
		return Distrito.save(obj);
	}
	
	@Override
    public Distrito actualizar(int IDdistrito, Distrito distritoActualizado) {
        Optional<Distrito> distritoExistente = Distrito.findById(IDdistrito);

        if (distritoExistente.isPresent()) {
        	Distrito distrito = distritoExistente.get();
        	distrito.setIDdistrito(distritoActualizado.getIDdistrito());
        	distrito.setNombre(distritoActualizado.getNombre());
            
            return Distrito.save(distrito);
        } else {
            throw new RuntimeException("Distrito no encontrada con ID: " + IDdistrito);
        }
    }

    @Override
    public void eliminar(int IDdistrito) {
        Optional<Distrito> distritoExistente = Distrito.findById(IDdistrito);

        if (distritoExistente.isPresent()) {
        	Distrito.deleteById(IDdistrito);
        } else {
            throw new RuntimeException("Distrito no encontrada con ID: " + IDdistrito);
        }
    }
    
    @Override
    public Distrito buscarPorId(int IDdistrito) {
        Optional<Distrito> distrito = Distrito.findById(IDdistrito);
        return distrito.orElseThrow(() -> new RuntimeException("Distrito no encontrada con ID: " + IDdistrito));
    }
}