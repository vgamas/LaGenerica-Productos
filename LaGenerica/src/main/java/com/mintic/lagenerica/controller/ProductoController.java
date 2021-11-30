package com.mintic.lagenerica.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mintic.lagenerica.model.Producto;
import com.mintic.lagenerica.repository.ProductoRepository;

@CrossOrigin(origins = {"http://localhost:9090", "http://localhost:3000"}) // Seguridad
@RestController
@RequestMapping("/productos")
public class ProductoController {

	@Autowired
	private ProductoRepository productoRepository;
	
	@PostMapping("/guardar")
	public ResponseEntity<?> crearProducto(@RequestBody Producto producto){
		return ResponseEntity.status(HttpStatus.CREATED).body(productoRepository.save(producto));
	}
	
	@GetMapping("/listar")
	public List<Producto> listarProductos() {
		List<Producto> listaProductos = StreamSupport.stream(productoRepository.findAll().spliterator(), false).collect(Collectors.toList());
		
		return listaProductos;
	}

	@GetMapping("/buscar/{id}")
	public ResponseEntity<?> bucarProducto(@PathVariable(value = "id") Long id) {

		Optional<Producto> oProducto = productoRepository.findById(id) ;
		
		if (oProducto.isEmpty())
			return ResponseEntity.notFound().build();
		
		return ResponseEntity.ok(oProducto);
	}

	@DeleteMapping("/eliminar/{id}")
	public ResponseEntity<?> borrarProductoporId(@PathVariable(value = "id") Long id) {

		Optional<Producto> oProducto = productoRepository.findById(id) ;
		
		if (oProducto.isEmpty())
			return ResponseEntity.notFound().build();
		
		productoRepository.deleteById(id);
		
		return ResponseEntity.ok(oProducto);
	}
	
	@DeleteMapping("/eliminar")
	public ResponseEntity<?> borrarTodos() {

		Producto oProducto = new Producto();
		
		productoRepository.deleteAll();
		
		return ResponseEntity.ok(oProducto);
	}


	@PutMapping("/actualizar")
	public ResponseEntity<?> actualizarProducto(@RequestBody Producto producto) {

		Optional<Producto> productoAnt = productoRepository.findById(producto.getCodigo_producto());
		
		if(productoAnt.isEmpty())
			return ResponseEntity.notFound().build();
		
		productoAnt.get().setNombre_producto(producto.getNombre_producto());
		productoAnt.get().setNitproveedor(producto.getNitproveedor());
		productoAnt.get().setPrecio_compra(producto.getPrecio_compra());
		productoAnt.get().setIvacompra(producto.getIvacompra());
		productoAnt.get().setPrecio_venta(producto.getPrecio_venta());
		
		return ResponseEntity.status(HttpStatus.CREATED).body(productoRepository.save(productoAnt.get()));	
	}
}
