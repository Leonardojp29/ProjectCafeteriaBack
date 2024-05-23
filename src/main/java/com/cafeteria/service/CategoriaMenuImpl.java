package com.cafeteria.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cafeteria.model.Categoria;
import com.cafeteria.repository.ICategoriaRepository;

@Service
public class CategoriaMenuImpl implements CategoriaMenuService {

	@Autowired
	private ICategoriaRepository Categoria;
	
	@Override
	public List<Categoria> listarTodos() {
		return Categoria.findAll();
	}

	@Override
	public Categoria registrar(Categoria obj) {
		return Categoria.save(obj);
	}
	
	@Override
    public Categoria actualizar(int idcategoria, Categoria categoriaActualizado) {
        Optional<Categoria> categoriaExistente = Categoria.findById(idcategoria);

        if (categoriaExistente.isPresent()) {
            Categoria categoria = categoriaExistente.get();
            categoria.setIdcategoria(categoriaActualizado.getIdcategoria());
            categoria.setNombre(categoriaActualizado.getNombre());
            
            return Categoria.save(categoria);
        } else {
            throw new RuntimeException("Categoria no encontrada con ID: " + idcategoria);
        }
    }

    @Override
    public void eliminar(int idcategoria) {
        Optional<Categoria> categoriaExistente = Categoria.findById(idcategoria);

        if (categoriaExistente.isPresent()) {
        	Categoria.deleteById(idcategoria);
        } else {
            throw new RuntimeException("Categoria no encontrada con ID: " + idcategoria);
        }
    }
    
    @Override
    public Categoria buscarPorId(int idcategoria) {
        Optional<Categoria> categoria = Categoria.findById(idcategoria);
        return categoria.orElseThrow(() -> new RuntimeException("Categoria no encontrada con ID: " + idcategoria));
    }
}