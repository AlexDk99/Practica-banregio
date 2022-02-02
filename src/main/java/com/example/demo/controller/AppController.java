package com.example.demo.controller;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.example.demo.models.CategoriaModel;
import com.example.demo.models.ProductoModel;
import com.example.demo.services.CategoriaService;
import com.example.demo.services.ProductoService;

import io.swagger.annotations.ApiOperation;

@Controller
@RestController
@RequestMapping()
public class AppController {
	@Autowired
	CategoriaService categoriaService;
	@Autowired
	ProductoService productoService;
	
	
	@CrossOrigin
	@ApiOperation("Obtiene todas las categorias")
	@GetMapping("/categorias")
	public ArrayList<CategoriaModel> obtenerCategoria(){
		return categoriaService.obtener();
	}
	
	@CrossOrigin
	@ApiOperation("Inserta una nueva categoria")
	@PostMapping("/categorias")
	public CategoriaModel registraCategoria(@RequestBody CategoriaModel categoria){
		return this.categoriaService.guardar(categoria);
	}
	
	@CrossOrigin
	@ApiOperation("Modifica una categoria")
	@PutMapping("/categorias")
	public CategoriaModel modificarCategoria(@RequestBody CategoriaModel categoria) {
		return this.categoriaService.actualizar(categoria);
	} 
	
	@CrossOrigin
	@ApiOperation("Modifica parcialmente una categoria")
	@PatchMapping("/categorias")
	public CategoriaModel modificarProductoParcial(@RequestBody CategoriaModel categoria) {
		return this.categoriaService.actualizarParcial(categoria);
	} 
	
	@CrossOrigin
	@ApiOperation("Obtiene los detalles de una categoria")
	@GetMapping("/categorias/{id}")
	public Optional<CategoriaModel> obtenerCategoriaPorId (@PathVariable("id") Long id){
		return this.categoriaService.obtenerPorId(id);
	}
	
	@CrossOrigin
	@ApiOperation("Elimina una categoria")
	@DeleteMapping(path = "/categorias/{id}")
	public String eliminarPorId (@PathVariable("id") Long id) {
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
	public ProductoModel registraProducto(@RequestBody ProductoModel producto){
		return this.productoService.guardar(producto);
	}
	
	@CrossOrigin
	@ApiOperation("Actualiza un producto")
	@PutMapping("/productos")
	public ProductoModel modificarProducto(@RequestBody ProductoModel producto) {
		return this.productoService.actualizar(producto);
	} 
	
	@CrossOrigin
	@ApiOperation("Modifica parcialmente un producto")
	@PatchMapping("/productos")
	public ProductoModel modificarProductoParcial(@RequestBody ProductoModel producto) {
		return this.productoService.actualizarParcial(producto);
	} 
	
	@CrossOrigin
	@ApiOperation("Obtiene los detalles de un producto")
	@GetMapping("/productos/{id}")
	public Optional<ProductoModel> obtenerProductoPorId (@PathVariable("id") Long id){
		return this.productoService.obtenerPorId(id);
	}
	
	@CrossOrigin
	@ApiOperation("Filtra los productos por precio")
	@GetMapping("/productos/{query}")
	public ArrayList<ProductoModel> obtenerProductoPorPrecio (@RequestParam("prioridad") Float precio){
		return this.productoService.obtenerPorPrecio(precio);
	}
	
	@CrossOrigin
	@ApiOperation("Elimina un producto")
	@DeleteMapping(path = "/productos/{id}")
	public String eliminarProductoPorId (@PathVariable("id") Long id) {
		boolean ok = this.productoService.eliminar(id);
		if(ok) {
			return "Se elimino correctamente";
		}else {
			return "Intente mas tarde";
		}
	}
}
