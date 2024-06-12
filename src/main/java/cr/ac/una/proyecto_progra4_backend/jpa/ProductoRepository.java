/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package cr.ac.una.proyecto_progra4_backend.jpa;

import cr.ac.una.proyecto_progra4_backend.domain.Producto;
import jakarta.transaction.Transactional;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


/**
 *
 * @author USUARIO
 */
@Repository
public interface ProductoRepository extends JpaRepository<Producto, Integer> {
    
        @Query("SELECT p FROM Producto p WHERE p.nombre LIKE %:textoBusqueda% OR p.descripcion LIKE %:textoBusqueda% OR p.categoria LIKE %:textoBusqueda% OR p.codigo LIKE %:textoBusqueda%")
    public List<Producto> busquedaProductos(String textoBusqueda);

    @Transactional
    @Modifying
    @Query("UPDATE Producto p SET p.nombre = :nombre, p.descripcion = :descripcion, p.precio = :precio, p.categoria = :categoria, p.calificacion = :calificacion, p.disponible = :disponible, p.stock = :stock WHERE p.codigo = :codigo")
    void modificarProducto(@Param("codigo") String codigo, @Param("nombre") String nombre, @Param("descripcion") String descripcion, @Param("precio") double precio, @Param("categoria") 
    String categoria, @Param("calificacion") int calificacion, @Param("disponible") boolean disponible, @Param("stock") int stock);
    
    @Transactional
    @Modifying
    @Query("DELETE FROM Producto p WHERE p.codigo = :codigo")
    public void eliminarProducto(@Param("codigo") String codigo);
}