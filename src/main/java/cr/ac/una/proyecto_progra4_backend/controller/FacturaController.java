package cr.ac.una.proyecto_progra4_backend.controller;

import java.util.LinkedList;
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

import cr.ac.una.proyecto_progra4_backend.Response.FacturasResponse;
import cr.ac.una.proyecto_progra4_backend.domain.Factura;

import cr.ac.una.proyecto_progra4_backend.services.IFacturaServices;

@RestController
@RequestMapping("/api/factura")
public class FacturaController {
   
    @Autowired
    private IFacturaServices ifs;

    @GetMapping("/listar")
    private ResponseEntity<FacturasResponse> facturas(@RequestParam int page, @RequestParam int pageSize){

        List<Factura> auxiliar = ifs.getFacturas();
        List<Factura> facturas = ifs.ObtenerRegistrosPaginados(page, pageSize, auxiliar);
        int ultimaPagina = (auxiliar != null) ? ((int) Math.ceil((double) auxiliar.size() / pageSize) - 1) : 0;

        FacturasResponse response = new FacturasResponse();

        response.setFacturas(facturas);
        response.setUltimaPagina(ultimaPagina);
        response.setPage(page);
        response.setPageSize(pageSize);

        return ResponseEntity.ok(response);
    }

    @PostMapping("/registrar")
    private ResponseEntity<String> insertar_factura(@RequestBody Factura factura){
        return ResponseEntity.ok(ifs.Insertar_factura(factura));
    }

    @PutMapping("/editar")
    public ResponseEntity<String> editar_facturas(@RequestBody Factura factura){
        return  ResponseEntity.ok(ifs.Insertar_factura(factura));
    }
    @DeleteMapping("/eliminar")
    public ResponseEntity<Boolean> eliminarProveedor(@RequestParam("factura") int id) {
        return ResponseEntity.ok(ifs.Eliminar_factura(id));
    }

   
}
