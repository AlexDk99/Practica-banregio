package com.example.demo.models;

import javax.persistence.*;

@Entity
@Table(name= "Producto")
public class ProductoModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
	private Long id;
	private String nombre;
	private Long Stock;
	private Float precio;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Long getStock() {
		return Stock;
	}
	public void setStock(Long stock) {
		Stock = stock;
	}
	public Float getPrecio() {
		return precio;
	}
	public void setPrecio(Float precio) {
		this.precio = precio;
	}
		
	
}
