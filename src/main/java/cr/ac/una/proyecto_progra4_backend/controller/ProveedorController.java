/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cr.ac.una.proyecto_progra4_backend.controller;

import cr.ac.una.proyecto_progra4_backend.domain.Proveedor;
import cr.ac.una.proyecto_progra4_backend.services.IProveedoresService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Adam Acuña
 */
@RestController
@RequestMapping("/api")
public class ProveedorController {

    @Autowired
    private IProveedoresService servicePro;

    @GetMapping("/listarProveedor")
    private List<Proveedor> proveedores() {
        return servicePro.getProveedores();
    }

    @PostMapping("/registrarProveedor")
    public ResponseEntity<String> crearProveedor(@RequestBody Proveedor proveedor) {
        String result = servicePro.guardar(proveedor);
        return ResponseEntity.ok(result);
    }

    @PutMapping("/editarProveedor")
    public ResponseEntity<String> editarProveedor(@RequestBody Proveedor proveedor) {
        String result = servicePro.actualizarProveedor(proveedor);
        return ResponseEntity.ok(result);
    }

    @DeleteMapping("/eliminarProveedor")
    public ResponseEntity<String> eliminarProveedor(@RequestParam("proveedor") int id) {
        String result = servicePro.eliminar(id);
        return ResponseEntity.ok(result);
    }
}
