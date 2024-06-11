package cr.ac.una.proyecto_progra4_backend.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import cr.ac.una.proyecto_progra4_backend.domain.Factura;
/**
 * @author UNA
 */
public interface FacturaRepository extends JpaRepository<Factura,Integer> {
    
}
