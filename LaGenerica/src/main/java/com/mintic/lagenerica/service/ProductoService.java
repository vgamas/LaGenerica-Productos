package com.mintic.lagenerica.service;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mintic.lagenerica.model.Producto;

public interface ProductoService extends JpaRepository<Producto, Long> {

}
