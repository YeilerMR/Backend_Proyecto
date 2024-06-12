/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cr.ac.una.proyecto_progra4_backend.controller;

import cr.ac.una.proyecto_progra4_backend.domain.Producto;
import cr.ac.una.proyecto_progra4_backend.services.IProductoServices;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author USUARIO
 */
@RestController
@RequestMapping("/api")
public class ProductoController {
    
    @Autowired
    private IProductoServices productoServices;
    
    @GetMapping("/listarProducto")
    private List<Producto> productos(){
        return productoServices.getProductos();
    }
    @PostMapping("registrarProducto")
    public ResponseEntity<String> save(@RequestBody Producto producto){
        String result = productoServices.agregarProductos(producto);
        return ResponseEntity.ok(result);
    }   
}   
