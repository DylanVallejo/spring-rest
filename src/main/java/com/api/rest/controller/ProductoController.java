package com.api.rest.controller;

import com.api.rest.model.Producto;
import com.api.rest.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/productos")
public class ProductoController {

    @Autowired
    private ProductoService productoService;


    @PostMapping
    public Producto agregarProducto(@RequestBody Producto producto){
        return productoService.saveProducto(producto);
    }

    @GetMapping
    public List<Producto> listarProducto(){
        return productoService.getProducto();
    }


    @GetMapping("/{id}")
    public Producto buscarProducto(@PathVariable int id){
        return productoService.getProductById(id);
    }


    @PutMapping
    public Producto actualizarProducto(@RequestBody Producto producto){
        return productoService.updateProducto(producto);
    }


    @DeleteMapping("/{id}")
    public String eliminarProducto(@PathVariable int id){
        return productoService.deleteProductos(id);
    }

}
