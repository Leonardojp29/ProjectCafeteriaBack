package com.cafeteria.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cafeteria.model.Menu;
import com.cafeteria.repository.IMenuRepository;

@Service
public class MenuServiceImpl implements MenuService {

	@Autowired
	private IMenuRepository Menu;
	
	@Override
	public List<Menu> listarTodos() {
		return Menu.findAll();
	}

	@Override
	public Menu registrar(Menu obj) {
		return Menu.save(obj);
	}
	
	@Override
    public Menu actualizar(int id, Menu menuActualizado) {
        Optional<Menu> menuExistente = Menu.findById(id);

        if (menuExistente.isPresent()) {
            Menu menu = menuExistente.get();
            menu.setNombre(menuActualizado.getNombre());
            menu.setPrecio(menuActualizado.getPrecio());
            menu.setIdcategoria(menuActualizado.getIdcategoria());
            menu.setDescripcion(menuActualizado.getDescripcion());
            menu.setImagen(menuActualizado.getImagen());
            return Menu.save(menu);
        } else {
            throw new RuntimeException("Menú no encontrado con ID: " + id);
        }
    }

    @Override
    public void eliminar(int id) {
        Optional<Menu> menuExistente = Menu.findById(id);

        if (menuExistente.isPresent()) {
        	Menu.deleteById(id);
        } else {
            throw new RuntimeException("Menú no encontrado con ID: " + id);
        }
    }
    
    @Override
    public Menu buscarPorId(int id) {
        Optional<Menu> menu = Menu.findById(id);
        return menu.orElseThrow(() -> new RuntimeException("Menu no encontrado con ID: " + id));
    }
}

