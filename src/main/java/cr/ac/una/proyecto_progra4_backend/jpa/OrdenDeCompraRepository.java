/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package cr.ac.una.proyecto_progra4_backend.jpa;

import cr.ac.una.proyecto_progra4_backend.domain.OrdenDeCompra;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Adam Acuña
 */
@Repository
public interface OrdenDeCompraRepository extends JpaRepository<OrdenDeCompra, Integer> {
    
    @Query("SELECT o FROM OrdenDeCompra o WHERE o.idProveedor.idProveedor = :proveedorId")
    List<OrdenDeCompra> findByProveedorId(@Param("proveedorId") int proveedorId);
    
    void deleteByNumeroReferencia(String numeroReferencia);
    
    Optional<OrdenDeCompra> findByNumeroReferencia(String numeroReferencia);
    
    @Query("SELECT o FROM OrdenDeCompra o ORDER BY o.idOrdenDeCompra DESC")
    List<OrdenDeCompra> findLastOrdenDeCompra();

}
