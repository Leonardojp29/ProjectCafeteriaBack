package com.cafeteria.service;

import org.springframework.http.ResponseEntity;

import com.cafeteria.model.Usuario;

public interface AuthService {
    ResponseEntity<?> authenticateUser(Usuario usuario);
}
