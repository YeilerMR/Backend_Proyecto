package cr.ac.una.proyecto_progra4_backend.services;

import java.util.LinkedList;
import java.util.List;

import cr.ac.una.proyecto_progra4_backend.domain.Factura;


/**
 * @author Gonzalo Dormos Rodriguez
 */
public interface IFacturaServices {
    public String Insertar_factura(Factura factura);
    
    public List<Factura> getFacturas();
    
    public boolean Eliminar_factura(int id);
    
    public boolean verificar_codigo(String codigo, int id, boolean edit);
    
    public LinkedList<Factura> ObtenerRegistrosPaginados(int numeroPagina, int tamanoPagina, List<Factura> facturas);

    public Factura getFacturaById(int id);
}
