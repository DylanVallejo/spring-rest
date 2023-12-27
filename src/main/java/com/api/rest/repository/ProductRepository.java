package com.api.rest.repository;

import com.api.rest.model.Producto;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class ProductRepository {


    private List<Producto> productos = new ArrayList<>();
//    si no disponemos de una base de datos podemos crear una lista con los valores para simular una

//    crear productos o agregar valores a la lista
    public void createProductos(){
        productos.addAll(List.of(
                new Producto(1, "Producto 01", 10, 1000),
                new Producto(2, "Producto 02", 11, 9000),
                new Producto(3, "Producto 03", 12, 8000),
                new Producto(4, "Producto 04", 13, 7000),
                new Producto(5, "Producto 05", 14, 6000),
                new Producto(6, "Producto 06", 15, 5000),
                new Producto(7, "Producto 07", 16, 4000),
                new Producto(8, "Producto 08", 17, 3000),
                new Producto(9, "Producto 09", 18, 2000)
        ));
    }

    public ProductRepository(){
        createProductos();
    }

//listar todos los productos
    public List<Producto> getAllProductos(){
        return productos;
    }


//    buscar un producto
    public Producto findById(int id){
        for (int i =0; i < productos.size(); i++){
            if (productos.get(i).getId() == id){
                return productos.get(i);
            }
        }
        return null;
    }

//se encarga de buscar un producto   ***** revisar api streams *****
    public List <Producto> search ( String nombre ){
        return productos.stream()
                .filter(x -> x.getNombre().startsWith(nombre))
                .collect(Collectors.toList());
    }

//  guardar un producto nuevo
    public Producto save(Producto p ){
        Producto producto = new Producto();
        producto.setId(p.getId());
        producto.setNombre(p.getNombre());
        producto.setCantidad(p.getCantidad());
        producto.setPrecio(p.getPrecio());
//        recibimos un producto seteamos sus valores y lo aniadimos al arraylist (guardamos)
        productos.add(producto);
        return producto;
    }


//    eliminar un producto
    public String  delete(Integer id ){
        productos.removeIf(x -> x.getId() == id);
        return null;
    }

//actualizar un producto con su posicion y id
    public Producto update ( Producto producto){
        int idPos = 0;
        int id = 0;

        for (int i = 0; i < productos.size(); i++){
            if(productos.get(i).getId() == producto.getId()){
                id = producto.getId();
                idPos  = i;
                break;
            }
        }

        Producto producto1 = new Producto();
        producto1.setId(id);
        producto1.setNombre(producto.getNombre());
        producto1.setCantidad(producto.getCantidad());
        producto1.setPrecio(producto.getPrecio());
//        insertamos el produto actaulizado al array con la posicion y el producto nuevo
        productos.set(idPos, producto);
        return producto1;
    }



}
