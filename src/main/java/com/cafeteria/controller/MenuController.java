package com.cafeteria.controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import com.cafeteria.model.Menu;
import com.cafeteria.service.MenuService;

@RestController
@RequestMapping("/api/menues")
@CrossOrigin(origins = "http://localhost:4200")
public class MenuController {

    private static String UPLOADED_FOLDER = "uploads/";

    @Autowired
    private MenuService service;

    @GetMapping
    public ResponseEntity<List<Menu>> listarMenues() {
        return ResponseEntity.ok(service.listarTodos());
    }

    @PostMapping
    public ResponseEntity<Menu> registrar(@RequestBody Menu menu){
        Menu nuevo = service.registrar(menu);
        return new ResponseEntity<>(nuevo, HttpStatus.CREATED);
    }

    @PostMapping("/upload")
    public ResponseEntity<String> uploadFile(@RequestParam("file") MultipartFile file) {
        if (file.isEmpty()) {
            return ResponseEntity.badRequest().body("Por favor seleccione un archivo para cargar");
        }

        try {
            byte[] bytes = file.getBytes();
            Path path = Paths.get(UPLOADED_FOLDER + file.getOriginalFilename());
            
            File uploadsDir = new File(UPLOADED_FOLDER);
            if (!uploadsDir.exists()) {
                uploadsDir.mkdirs();
            }
            
            Files.write(path, bytes);

            String imageUrl = "http://localhost:8080/" + UPLOADED_FOLDER + file.getOriginalFilename();
            return ResponseEntity.ok(imageUrl);

        } catch (IOException e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al cargar el archivo");
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Menu> actualizar(@PathVariable("id") int id, 
                                           @RequestBody Menu menuActualizado) {
        Menu actualizado = service.actualizar(id, menuActualizado);
        return ResponseEntity.ok(actualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable("id") int id) {
        service.eliminar(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Menu> buscarMenuPorId(@PathVariable("id") int id) {
        Menu menu = service.buscarPorId(id);
        return ResponseEntity.ok(menu);
    }
}
