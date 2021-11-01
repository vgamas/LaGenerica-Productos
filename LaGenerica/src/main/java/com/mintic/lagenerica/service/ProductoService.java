package com.mintic.lagenerica.service;

import java.util.Optional;

import com.mintic.lagenerica.model.Producto;

public interface ProductoService {
	
	public Producto crearProducto(Producto producto);
	
	public Iterable<Producto> listarProductos();
	
	public void borrarProductoPorId(Long id) ;
	
	public void borrarTodosProductos();
	
	public Optional<Producto> buscarProductoPorId(Long id);
}
