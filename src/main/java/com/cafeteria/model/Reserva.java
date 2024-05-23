package com.cafeteria.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name="Reserva")
@Data
public class Reserva {
	@Id
	private int id;
	private String Nombre;
	private String Correo;
	private String Telefono;
	private int Cantidad;
	private String fecha;
    private String hora;
    private String mensaje;
}

