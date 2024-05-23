package com.cafeteria.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.cafeteria.model.Usuario;
import com.cafeteria.repository.IUsuarioRepository;

@Service
public class AuthServiceImpl implements AuthService {

    @Autowired
    private IUsuarioRepository usuarioRepository;

    @Override
    public ResponseEntity<?> authenticateUser(Usuario usuario) {
        Usuario authenticatedUser = usuarioRepository.findByUsuarioAndPassword(usuario.getUsuario(), usuario.getPassword());
        if (authenticatedUser != null) {
            int tipoUsuarioId = authenticatedUser.getTipoUsuario_ID();
            String message = "Usuario autenticado correctamente";
            
            if (tipoUsuarioId == 2) {
                message += " como cliente";
            } else if (tipoUsuarioId == 1) {
                message += " como administrador";
            } else {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("{\"error\": \"Tipo de usuario desconocido\"}");
            }

            return ResponseEntity.ok("{\"message\": \"" + message + "\", \"tipo_usuario_id\": " + tipoUsuarioId + "}");
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("{\"error\": \"Credenciales inválidas\"}");
        }
    }



}
