package cr.ac.una.proyecto_progra4_backend.services;

import java.util.List;

import cr.ac.una.proyecto_progra4_backend.domain.Factura;


/**
 * @author Gonzalo Dormos Rodriguez
 */
public interface IFacturaServices {
    public String Insertar_factura(Factura factura);
    
    public List<Factura> getFacturas();
    
    public String Eliminar_factura(int id);
    
    public boolean verificar_codigo(String codigo, int id, boolean edit);
    
    public List<Factura> ObtenerRegistrosPaginados(int numeroPagina, int tamanoPagina, List<Factura> facturas);

    public Factura getFacturaById(int id);

    public String generar_Codigo();

    public String recursivo_char(String prefix, int index);
}
