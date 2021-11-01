package com.mintic.lagenerica.model;

import javax.persistence.Id;

import org.springframework.data.mongodb.core.mapping.Document;

@Document("db_productos")
public class Producto {

	@Id
	private Long codigo_producto;
	private String nombre_producto;
	//@DBRef
	private Long nitproveedor;
	private Double precio_compra;
	private Double ivacompra;
	private Double precio_venta;

	public Long getCodigo_producto() {
		return codigo_producto;
	}
	
	public void setCodigo_producto(Long codigo_producto) {
		this.codigo_producto = codigo_producto;
	}
	
	public String getNombre_producto() {
		return nombre_producto;
	}
	
	public void setNombre_producto(String nombre_producto) {
		this.nombre_producto = nombre_producto;
	}
	
	public Long getNitproveedor() {
		return nitproveedor;
	}
	
	public void setNitproveedor(Long nitproveedor) {
		this.nitproveedor = nitproveedor;
	}
	
	public Double getPrecio_compra() {
		return precio_compra;
	}
	
	public void setPrecio_compra(Double precio_compra) {
		this.precio_compra = precio_compra;
	}
	
	public Double getIvacompra() {
		return ivacompra;
	}
	
	public void setIvacompra(Double ivacompra) {
		this.ivacompra = ivacompra;
	}
	
	public Double getPrecio_venta() {
		return precio_venta;
	}
	
	public void setPrecio_venta(Double precio_venta) {
		this.precio_venta = precio_venta;
	}	
}
