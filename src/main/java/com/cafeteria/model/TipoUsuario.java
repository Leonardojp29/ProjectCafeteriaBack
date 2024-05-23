package com.cafeteria.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name ="tipousuario")
@Data
public class TipoUsuario {
	@Id 
	private int ID;
	private String Tipo;
	
}
