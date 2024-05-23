package com.cafeteria.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name ="distrito")
@Data
public class Distrito {
	@Id 
	private int IDdistrito;
	private String nombre;
}

