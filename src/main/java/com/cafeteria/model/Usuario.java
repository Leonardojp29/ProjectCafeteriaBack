package com.cafeteria.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name="Usuario")
@Data
public class Usuario {
	@Id
	private int ID;
	private String Nombre;
	private String Apellido;
	private String Email;
	private String usuario;
	@Column(name="contraseña")
	private String password;
	@Column(name="tipo_usuario_id")
	private int TipoUsuario_ID;
}

