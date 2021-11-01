package com.mintic.lagenerica.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mintic.lagenerica.dao.ProductoDao;
import com.mintic.lagenerica.model.Producto;

@Service
public class ProductoServiceImpl implements ProductoService {

	@Autowired
	private ProductoDao productoDao;
	
	@Override
	@Transactional
	public Producto crearProducto(Producto producto) {
		// TODO Auto-generated method stub
		
		return productoDao.save(producto);
	}

	@Override
	@Transactional(readOnly = true)
	public Iterable<Producto> listarProductos() {
		// TODO Auto-generated method stub
		return productoDao.findAll();
	}

	@Override
	@Transactional
	public void borrarProductoPorId(Long id) {
		// TODO Auto-generated method stub

		productoDao.deleteAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<Producto> buscarProductoPorId(Long id) {
		// TODO Auto-generated method stub
		return productoDao.findById(id);
	}

	@Override
	@Transactional
	public void borrarTodosProductos() {
		// TODO Auto-generated method stub
		
		productoDao.deleteAll();
	}
}
