/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cr.ac.una.proyecto_progra4_backend.services;

import cr.ac.una.proyecto_progra4_backend.domain.OrdenDeCompra;
import cr.ac.una.proyecto_progra4_backend.jpa.OrdenDeCompraRepository;
import jakarta.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

/**
 *
 * @author Adam Acuña
 */
@Service
@Primary
public class OrdenDeCompraServices implements IOrdenDeCompraService {

    @Autowired
    private OrdenDeCompraRepository ordenRep;

    @Override
    @Transactional
    public String guardar(OrdenDeCompra orden) {
        if (orden.getIdProveedor() == null || orden.getIdPedido() == null
                || orden.getFechaOrden() == null || orden.getFechaEntrega() == null
                || orden.getEstadoOrden() == null || orden.getEstadoOrden().isEmpty()) {

            return "{\"success\": false, \"message\": \"Por favor, rellene todos los campos.\"}";
        }

        try {
            // Obtener el último id de orden de compra
            List<OrdenDeCompra> lastOrdenDeCompraList = ordenRep.findLastOrdenDeCompra();
            int lastId = 0;
            if (!lastOrdenDeCompraList.isEmpty()) {
                OrdenDeCompra lastOrdenDeCompra = lastOrdenDeCompraList.get(0);
                lastId = lastOrdenDeCompra.getIdOrdenDeCompra();
            }

            // Generar el nuevo número de referencia
            String nuevoNumeroReferencia = "ORD-" + (lastId + 1);
            orden.setNumeroReferencia(nuevoNumeroReferencia);

            // Guardar la orden de compra
            ordenRep.save(orden);
            return "{\"success\": true, \"message\": \"La orden de compra se ha registrado exitosamente.\"}";
        } catch (Exception e) {
            return "{\"success\": false, \"message\": \"Error al guardar la orden de compra: " + e.getMessage() + "\"}";
        }
    }

    @Override
    public List<OrdenDeCompra> getOrdenes() {
        return ordenRep.findAll();
    }
    
    @Override
    @Transactional
    public String eliminar(String numeroReferencia) {
        try {
            ordenRep.deleteByNumeroReferencia(numeroReferencia);
            return "{\"success\": true, \"message\": \"Orden de compra eliminada exitosamente.\"}";
        } catch (Exception e) {
            return "{\"success\": false, \"message\": \"Error al eliminar la orden de compra: " + e.getMessage() + "\"}";
        }
    }
    
    @Override
    @Transactional
    public String actualizarOrden(String numeroReferencia, OrdenDeCompra nuevaOrden) {
        try {
            Optional<OrdenDeCompra> ordenExistenteOpt = ordenRep.findByNumeroReferencia(numeroReferencia);
            if (ordenExistenteOpt.isPresent()) {
                OrdenDeCompra ordenExistente = ordenExistenteOpt.get();
                // Actualiza los campos necesarios
                ordenExistente.setIdPedido(nuevaOrden.getIdPedido());
                ordenExistente.setIdProveedor(nuevaOrden.getIdProveedor());
                ordenExistente.setFechaOrden(nuevaOrden.getFechaOrden());
                ordenExistente.setFechaEntrega(nuevaOrden.getFechaEntrega());
                ordenExistente.setEstadoOrden(nuevaOrden.getEstadoOrden());

                ordenRep.save(ordenExistente);

                return "{\"success\": true, \"message\": \"Orden de compra actualizada exitosamente.\"}";
            } else {
                return "{\"success\": false, \"message\": \"Orden de compra no encontrada.\"}";
            }
        } catch (Exception e) {
            return "{\"success\": false, \"message\": \"Error al actualizar la orden de compra: " + e.getMessage() + "\"}";
        }
    }
}
