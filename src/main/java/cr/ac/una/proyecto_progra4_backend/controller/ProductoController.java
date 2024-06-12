/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cr.ac.una.proyecto_progra4_backend.controller;

import cr.ac.una.proyecto_progra4_backend.domain.Producto;
import cr.ac.una.proyecto_progra4_backend.services.ProductoServices;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author USUARIO
 */
@RestController
@RequestMapping("/api")
public class ProductoController {

    @Autowired
    private ProductoServices productoServices;

    @GetMapping("/producto")
    public ResponseEntity<List<Producto>> get() {
        List<Producto> productos = productoServices.getProductos();
        return ResponseEntity.ok(productos);
    }
    
    @PostMapping("/agregarProd")
    public ResponseEntity<String> save(@RequestBody Producto producto) {
        if (productoServices.agregarProductos(producto)) {
            return ResponseEntity.ok().body("{\"success\": true, \"message\": \"Producto agregado exitosamente\"}");
        }
        return ResponseEntity.badRequest().body("{\"success\": false, \"message\": \"Error al agregar el producto\"}");
    }

    @GetMapping("/listarProd")
    public ResponseEntity<List<Producto>> mostrarLista(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int pageSize) {
        List<Producto> productos = productoServices.obtenerRegistrosPaginados(page, pageSize);
        return ResponseEntity.ok(productos);
    }

    @GetMapping("/buscarProd")
    public ResponseEntity<List<Producto>> buscar(@RequestParam(value = "textoBuscar", required = true) String textoBuscar) {
        List<Producto> productos;
        if (textoBuscar == null || textoBuscar.isBlank()) {
            productos = productoServices.getProductos();
        } else {
            productos = productoServices.buscarProductos(textoBuscar);
        }

        try {
            Thread.sleep(2000);
        } catch (InterruptedException ex) {
            Logger.getLogger(InterruptedException.class.getName()).log(Level.SEVERE, null, ex);
        }

        return ResponseEntity.ok(productos);
    }

    @DeleteMapping("/eliminarProd/{codigo}")
    public ResponseEntity<String> eliminar(@PathVariable String codigo) {
        boolean elimino = productoServices.eliminar(codigo);
        if (elimino) {
            return ResponseEntity.ok("{\"success\": true, \"message\": \"Producto eliminado correctamente\"}");
        } else {
            return ResponseEntity.badRequest().body("{\"success\": false, \"message\": \"El producto no pudo ser eliminado\"}");
        }
    }

    @PutMapping("/actualizarProd")
    public ResponseEntity<String> actualizar(@RequestBody Producto producto) {
        productoServices.modificar(producto);
        return ResponseEntity.ok("{\"success\": true, \"message\": \"Producto actualizado correctamente\"}");
    }
}
