package com.cafeteria.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name="Menu")
@Data
public class Menu {
	@Id
	private int ID;
	private String Nombre;
	private int idcategoria;
	private double Precio;
	private String Descripcion;
	private String Imagen;
}


