package com.mintic.lagenerica.dao;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.mintic.lagenerica.model.Producto;

@Repository
public interface ProductoDao extends MongoRepository<Producto, Long> {

}
