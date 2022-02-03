package com.example.demo.controller;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.CategoriaModel;
import com.example.demo.models.ProductoModel;
import com.example.demo.services.CategoriaService;
import com.example.demo.services.ProductoService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/test")
public class AppControllerTest {
	ProductoModel product = new ProductoModel();
	CategoriaModel cate = new CategoriaModel();
	@Autowired
	CategoriaService categoriaService;
	@Autowired
	ProductoService productoService;
	
	@ApiOperation("Obtiene todas las categorias")
	@GetMapping("/categorias")
	public ArrayList<CategoriaModel> obtenerCategoria(){
		return categoriaService.obtener();
	}
	
	@CrossOrigin
	@ApiOperation("Inserta una nueva categoria")
	@PostMapping("/categorias")
	public CategoriaModel registraCategoria(){
		cate.setId((long) 1);
		cate.setNombre("Mascotas");
		return this.categoriaService.guardar(cate);
	}
	
	@CrossOrigin
	@ApiOperation("Modifica una categoria")
	@PutMapping("/categorias")
	public CategoriaModel modificarCategoria() {
		cate.setId((long) 1);
		cate.setNombre("Mascotas");
		return this.categoriaService.actualizar(cate);
	} 
	
	@CrossOrigin
	@ApiOperation("Modifica parcialmente una categoria")
	@PatchMapping("/categorias")
	public CategoriaModel modificarCategoriaParcial() {
		cate.setId((long) 1);
		cate.setNombre("Mascotas");
		return this.categoriaService.actualizarParcial(cate);
	} 
	
	@CrossOrigin
	@ApiOperation("Obtiene los detalles de una categoria")
	@GetMapping("/categorias/{id}")
	public Optional<CategoriaModel> obtenerCategoriaPorId (){
		Long id = (long) 1;
		return this.categoriaService.obtenerPorId(id);
	}
	
	@CrossOrigin
	@ApiOperation("Elimina una categoria")
	@DeleteMapping(path = "/categorias/{id}")
	public String eliminarPorId () {
		Long id = (long) 1;
		boolean ok = this.categoriaService.eliminar(id);
		if(ok) {
			return "Se elimino correctamente";
		}else {
			return "Intente mas tarde";
		}
	}
	
	@CrossOrigin
	@ApiOperation("Obtiene todos los productos")
	@GetMapping("/productos")
	public ArrayList<ProductoModel> obtenerProductos(){
		return productoService.obtener();
	}

	@CrossOrigin
	@ApiOperation("Inserta un nuevo producto")
	@PostMapping("/productos")
	public ProductoModel registraProducto(){
		product.setId((long) 1);
		product.setNombre("Croquetas");
		product.setPrecio((float) 12.13);
		product.setStock((long) 13);
		return this.productoService.guardar(product);
	}
	
	@CrossOrigin
	@ApiOperation("Actualiza un producto")
	@PutMapping("/productos")
	public ProductoModel modificarProducto() {
		product.setId((long) 1);
		product.setNombre("Croquetas");
		product.setPrecio((float) 12.13);
		product.setStock((long) 13);
		return this.productoService.actualizar(product);
	} 
	
	@CrossOrigin
	@ApiOperation("Modifica parcialmente un producto")
	@PatchMapping("/productos")
	public ProductoModel modificarProductoParcial() {
		product.setId((long) 1);
		product.setNombre("Croquetas");
		product.setPrecio((float) 12.13);
		product.setStock((long) 13);
		return this.productoService.actualizarParcial(product);
	} 
	
	@CrossOrigin
	@ApiOperation("Obtiene los detalles de un producto")
	@GetMapping("/productos/{id}")
	public Optional<ProductoModel> obtenerProductoPorId (){
		Long id = (long) 1;
		return this.productoService.obtenerPorId(id);
	}
	
	@CrossOrigin
	@ApiOperation("Filtra los productos por precio")
	@GetMapping("/productos/{query}")
	public ArrayList<ProductoModel> obtenerProductoPorPrecio (){
		Float precio = (float) 11.13;
		return this.productoService.obtenerPorPrecio(precio);
	}
	
	@CrossOrigin
	@ApiOperation("Elimina un producto")
	@DeleteMapping(path = "/productos/{id}")
	public String eliminarProductoPorId () {
		Long id = (long) 1;
		boolean ok = this.productoService.eliminar(id);
		if(ok) {
			return "Se elimino correctamente";
		}else {
			return "Intente mas tarde";
		}
	}
}
