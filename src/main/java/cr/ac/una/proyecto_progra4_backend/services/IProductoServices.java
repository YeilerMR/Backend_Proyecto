/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package cr.ac.una.proyecto_progra4_backend.services;

import cr.ac.una.proyecto_progra4_backend.domain.Producto;
import java.util.List;

/**
 *
 * @author USUARIO
 */
public interface IProductoServices {
     //Agrega un producto a la base de datos
    public String agregarProductos(Producto producto);

    //Devuelve una lista con todos los productos
    public List<Producto> getProductos();

    //Devuelve una lista con los productos
    //que coincidad con textoBusqueda
    public List<Producto> buscarProductos(String textoBusqueda);

    public boolean modificar(Producto producto);
    //Elimina un producto por medio del cod
    public boolean eliminar(String codigo);
    //Metodo de paginacion de productos
    public List<Producto> obtenerRegistrosPaginados(int numeroPagina, int tamanoPagina);
    
}
