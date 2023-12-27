package com.api.rest.service;


import com.api.rest.model.Producto;
import com.api.rest.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductoService {

    @Autowired
    private ProductRepository productRepository;

    public Producto saveProducto(Producto producto){
        return productRepository.save(producto);
    }


    public List<Producto> getProducto(){
        return productRepository.getAllProductos();
    }

    public Producto getProductById(Integer id){
        return productRepository.findById(id);
    }


    public String deleteProductos(int id){
        productRepository.delete(id);
        return "producto " + id + " eliminado";
    }


    public Producto updateProducto(Producto producto){
        return productRepository.update(producto);
    }
}
