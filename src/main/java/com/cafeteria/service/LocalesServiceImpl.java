package com.cafeteria.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cafeteria.model.Locales;
import com.cafeteria.repository.ILocalesRepository;

@Service
public class LocalesServiceImpl implements LocalesService {

	@Autowired
	private ILocalesRepository Locales;
	
	@Override
	public List<Locales> listarTodos() {
		return Locales.findAll();
	}

	@Override
	public Locales registrar(Locales obj) {
		return Locales.save(obj);
	}
	
	@Override
    public Locales actualizar(int id, Locales localesActualizado) {
        Optional<Locales> localesExistente = Locales.findById(id);

        if (localesExistente.isPresent()) {
        	Locales locales = localesExistente.get();
        	locales.setIDdistrito(localesActualizado.getIDdistrito());
        	locales.setDireccion(localesActualizado.getDireccion());
        	locales.setHorario(localesActualizado.getHorario());
            return Locales.save(locales);
        } else {
            throw new RuntimeException("Local no encontrado con ID: " + id);
        }
    }

    @Override
    public void eliminar(int id) {
        Optional<Locales> localesExistente =Locales.findById(id);

        if (localesExistente.isPresent()) {
        	Locales.deleteById(id);
        } else {
            throw new RuntimeException("Local no encontrado con ID: " + id);
        }
    }
    
    @Override
    public Locales buscarPorId(int id) {
        Optional<Locales> locales = Locales.findById(id);
        return locales.orElseThrow(() -> new RuntimeException("Local no encontrado con ID: " + id));
    }
}
