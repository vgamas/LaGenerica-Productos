package com.mintic.lagenerica.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mintic.lagenerica.model.Producto;
import com.mintic.lagenerica.service.ProductoService;

@RestController("/productos")
public class ProductoController {

	@Autowired
	private ProductoService productoService;
	
	@PostMapping("/guardar")
	public ResponseEntity<?> crearProducto(@RequestBody Producto producto){
		return ResponseEntity.status(HttpStatus.CREATED).body(productoService.crearProducto(producto));
	}
	
	@GetMapping("/listar")
	public List<Producto> listarProductos() {
		List<Producto> listaProductos = StreamSupport.stream(productoService.listarProductos().spliterator(), false).collect(Collectors.toList());
		
		return listaProductos;
	}

	@GetMapping("/buscar/{id}")
	public ResponseEntity<?> bucarProducto(@PathVariable(value = "id") Long id) {

		Optional<Producto> oProducto = productoService.buscarProductoPorId(id) ;
		
		if (oProducto.isEmpty())
			return ResponseEntity.notFound().build();
		
		return ResponseEntity.ok(oProducto);
	}

	@DeleteMapping("/eliminar/{id}")
	public ResponseEntity<?> borrarProductoporId(@PathVariable(value = "id") Long id) {

		Optional<Producto> oProducto = productoService.buscarProductoPorId(id) ;
		
		if (oProducto.isEmpty())
			return ResponseEntity.notFound().build();
		
		productoService.borrarProductoPorId(id);
		
		return ResponseEntity.ok(oProducto);
	}

	@PutMapping("actualizar")
	public ResponseEntity<?> actualizarProducto(@RequestBody Producto producto) {

		Optional<Producto> productoAnt = productoService.buscarProductoPorId(producto.getCodigo_producto());
		
		if(productoAnt.isEmpty())
			return ResponseEntity.notFound().build();
		
		productoAnt.get().setNombre_producto(producto.getNombre_producto());
		productoAnt.get().setNitproveedor(producto.getNitproveedor());
		productoAnt.get().setPrecio_compra(producto.getPrecio_compra());
		productoAnt.get().setIvacompra(producto.getIvacompra());
		productoAnt.get().setPrecio_venta(producto.getPrecio_venta());
		
		return ResponseEntity.status(HttpStatus.CREATED).body(productoService.crearProducto(productoAnt.get()));	
	}
}
