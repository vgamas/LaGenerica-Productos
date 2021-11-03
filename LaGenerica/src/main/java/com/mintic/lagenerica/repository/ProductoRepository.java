package com.mintic.lagenerica.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.mintic.lagenerica.model.Producto;

public interface ProductoRepository extends MongoRepository<Producto, Long> {

//	List<Producto> findByNombre_producto(String nombre);
}
