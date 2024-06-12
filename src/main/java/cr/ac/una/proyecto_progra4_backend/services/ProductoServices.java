/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cr.ac.una.proyecto_progra4_backend.services;

import cr.ac.una.proyecto_progra4_backend.domain.Producto;
import cr.ac.una.proyecto_progra4_backend.jpa.ProductoRepository;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

/**
 *
 * @author USUARIO
 */
@Service
@Primary
public class ProductoServices implements IProductoServices{
    
    @Autowired
    ProductoRepository productoRep;

    @Override
    public boolean agregarProductos(Producto producto) {
        boolean resultado= true;
        try {
            productoRep.save(producto);
        } catch (Exception ex) {
            Logger.getLogger(ProductoServices.class.getName()).log(Level.SEVERE,null,ex);
            resultado=false;
        }
        return resultado;
    }

    @Override
    public List<Producto> getProductos() {
        List<Producto> productos;
        try {
            productos= productoRep.findAll();
        } catch (Exception ex) {
            productos= null;
            Logger.getLogger(ProductoServices.class.getName()).log(Level.SEVERE, null, ex);
        }
        return productos;
    }

    @Override
    public boolean eliminar(String codigo) {
        boolean resultado= true;
        
        try {
            productoRep.eliminarProducto(codigo);

        } catch (Exception ex) {
            Logger.getLogger(ProductoServices.class.getName()).log(Level.SEVERE, null, ex);
            resultado= false;
        }
        return resultado;
    }

    @Override
    public List<Producto> buscarProductos(String textoBusqueda) {
        List<Producto> productos;
        try {
            productos= productoRep.busquedaProductos(textoBusqueda);
        } catch (Exception ex) {
            productos=null;
            Logger.getLogger(ProductoServices.class.getName()).log(Level.SEVERE, null, ex);
        }
        return productos;
    } 

    @Override
    public boolean modificar(Producto producto) {
       boolean resultado;
       
        try {
            productoRep.modificarProducto(producto.getCodigo(), producto.getNombre(), 
                    producto.getDescripcion(), producto.getPrecio(), producto.getCategoria(), 
                    producto.getCalificacion(), producto.isDisponible(), producto.getStock());
            
            //System.out.println("Metodo modificar: Disponible["+producto.isDisponible()+"]");
            resultado= true;
        } catch (Exception ex) {
            Logger.getLogger(ProductoServices.class.getName()).log(Level.SEVERE,null,ex);
            resultado= false;
        }
       return resultado;
    }

    @Override
    public List<Producto> obtenerRegistrosPaginados(int numeroPagina, int tamanoPagina) {
        Page<Producto> paginaProductos = productoRep.findAll(PageRequest.of(numeroPagina, tamanoPagina));
        return paginaProductos.getContent();
    }
}
