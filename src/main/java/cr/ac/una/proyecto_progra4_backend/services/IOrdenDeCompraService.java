/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package cr.ac.una.proyecto_progra4_backend.services;

import cr.ac.una.proyecto_progra4_backend.domain.OrdenDeCompra;
import java.util.List;

/**
 *
 * @author Adam Acuña
 */
public interface IOrdenDeCompraService {

    public String guardar(OrdenDeCompra orden);

    public List<OrdenDeCompra> getOrdenes();

    public String eliminar(String id);

    public String actualizarOrden(String numeroReferencia, OrdenDeCompra nuevaOrden);
}
