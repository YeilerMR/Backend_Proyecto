/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package cr.ac.una.proyecto_progra4_backend.services;

import cr.ac.una.proyecto_progra4_backend.domain.Proveedor;
import java.util.List;

/**
 *
 * @author Adam Acuña
 */
public interface IProveedoresService {

    public String guardar(Proveedor proveedor);

    public List<Proveedor> getProveedores();

    public String eliminar(int id);
    
    public String actualizarProveedor(Proveedor proveedorActualizado);

}
