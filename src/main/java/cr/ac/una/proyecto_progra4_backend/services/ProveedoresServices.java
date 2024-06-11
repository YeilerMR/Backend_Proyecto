/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cr.ac.una.proyecto_progra4_backend.services;

import cr.ac.una.proyecto_progra4_backend.domain.OrdenDeCompra;
import cr.ac.una.proyecto_progra4_backend.domain.Proveedor;
import cr.ac.una.proyecto_progra4_backend.jpa.OrdenDeCompraRepository;
import cr.ac.una.proyecto_progra4_backend.jpa.ProveedorRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

/**
 *
 * @author Adam Acuña
 */
@Service
@Primary
public class ProveedoresServices implements IProveedoresService {


    @Autowired
    private OrdenDeCompraRepository ordenDeCompraRep;

    @Autowired
    private ProveedorRepository proveedorRep;
    
    @Override
    public String guardar(Proveedor proveedor) {
        try {
            // Validación de campos vacíos
            if (proveedor.getNombreProveedor() == null || proveedor.getNombreProveedor().isEmpty()
                    || proveedor.getTelefonoProveedor() == null || proveedor.getTelefonoProveedor().isEmpty()
                    || proveedor.getDescripcionProveedor() == null || proveedor.getDescripcionProveedor().isEmpty()
                    || proveedor.getCorreo() == null || proveedor.getCorreo().isEmpty()
                    || proveedor.getDireccionProveedor() == null || proveedor.getDireccionProveedor().isEmpty()
                    || proveedor.getCategoriaServicio() == null || proveedor.getCategoriaServicio().isEmpty()
                    || proveedor.getInformacionAdicional() == null || proveedor.getInformacionAdicional().isEmpty()) {

                return "{\"success\": false, \"message\": \"Por favor, rellene todos los campos.\"}";
            }

            // Guardar el proveedor si todos los campos están completos
            proveedorRep.save(proveedor);
            return "{\"success\": true, \"message\": \"¡Proveedor agregado exitosamente!\"}";
        } catch (Exception e) {
            return "{\"success\": false, \"message\": \"Error al guardar el proveedor: " + e.getMessage() + "\"}";
        }
    }

    @Override
    public List<Proveedor> getProveedores() {
        return proveedorRep.findAll();
    }

    @Override
    public String eliminar(int id) {
        try {
            // Verificar si el proveedor está asociado a alguna orden de compra
            List<OrdenDeCompra> ordenesDeCompra = ordenDeCompraRep.findByProveedorId(id);
            //boolean existe = new OrdenDeCompraData().proveedorById(id);
            if (!ordenesDeCompra.isEmpty()/*existe*/) {
                return "{\"success\": false, \"message\": \"No se puede eliminar el proveedor porque está asociado a una o más órdenes de compra.\"}";
            }

            proveedorRep.deleteById(id);
            return "{\"success\": true, \"message\": \"¡Proveedor eliminado exitosamente!\"}";
        } catch (Exception e) {
            return "{\"success\": false, \"message\": \"Error al eliminar el proveedor: " + e.getMessage() + "\"}";
        }
    }

    @Override
    public String actualizarProveedor(Proveedor proveedor) {
        try {
            proveedorRep.save(proveedor);
            return "{\"success\": true, \"message\": \"¡Proveedor editado exitosamente!\"}";
        } catch (Exception e) {
            return "{\"success\": false, \"message\": \"Error al editar el proveedor: " + e.getMessage() + "\"}";
        }
    }
}
