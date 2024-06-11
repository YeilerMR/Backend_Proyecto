package cr.ac.una.proyecto_progra4_backend.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import cr.ac.una.proyecto_progra4_backend.domain.Factura;
/**
 * @author UNA
 */
public interface FacturaRepository extends JpaRepository<Factura,Integer> {
    @Query("SELECT f FROM Factura f WHERE f.id_factura = (SELECT MAX(f2.id_factura) FROM Factura f2)")
    Factura findUltimaFactura();
}
