package com.cafeteria.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name ="Locales")
@Data
public class Locales {
	@Id 
	private int id;
	@Column(name="IDdistrito")
	private int IDdistrito;
	private String direccion;
	private String horario;
}

