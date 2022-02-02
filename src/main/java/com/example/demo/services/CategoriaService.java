package com.example.demo.services;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.models.CategoriaModel;
import com.example.demo.repositories.CategoriaRepository;

@Service
public class CategoriaService {
	@Autowired
	CategoriaRepository categoriaRepo;
	
	public ArrayList<CategoriaModel> obtener(){
		return (ArrayList<CategoriaModel>)categoriaRepo.findAll();
	}
	
	public CategoriaModel guardar(CategoriaModel usuario) {
		return categoriaRepo.save(usuario);
	}
	
	public Optional <CategoriaModel> obtenerPorId(Long id){
		return categoriaRepo.findById(id);
	}
	
	
	public boolean eliminar(Long id) {
		try {
			categoriaRepo.deleteById(id);
			return true;
		}catch(Exception e) {
			return false;
		}
	}
	public CategoriaModel actualizar(CategoriaModel usuario) {
		return categoriaRepo.save(usuario);
	}
	
	public CategoriaModel actualizarParcial(CategoriaModel usuario) {
		return categoriaRepo.save(usuario);
	}
}
