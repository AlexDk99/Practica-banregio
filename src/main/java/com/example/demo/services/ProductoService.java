package com.example.demo.services;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.models.ProductoModel;
import com.example.demo.repositories.ProductoRepository;

@Service
public class ProductoService {
	@Autowired
	ProductoRepository productoRepo;
	
	public ArrayList<ProductoModel> obtener(){
		return (ArrayList<ProductoModel>)productoRepo.findAll();
	}
	
	public ProductoModel guardar(ProductoModel usuario) {
		return productoRepo.save(usuario);
	}
	
	public Optional <ProductoModel> obtenerPorId(Long id){
		return productoRepo.findById(id);
	}
	
	public ArrayList<ProductoModel> obtenerPorPrecio(Float precio){
		return productoRepo.findByPrecio(precio);
	}
	
	public boolean eliminar(Long id) {
		try {
			productoRepo.deleteById(id);
			return true;
		}catch(Exception e) {
			return false;
		}
	}
	public ProductoModel actualizar(ProductoModel usuario) {
		return productoRepo.save(usuario);
	}
	
	public ProductoModel actualizarParcial(ProductoModel usuario) {
		return productoRepo.save(usuario);
	}
}
