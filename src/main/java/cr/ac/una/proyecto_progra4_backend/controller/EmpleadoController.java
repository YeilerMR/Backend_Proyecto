/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cr.ac.una.proyecto_progra4_backend.controller;

import cr.ac.una.proyecto_progra4_backend.domain.Empleado;
import cr.ac.una.proyecto_progra4_backend.services.EmpleadoServices;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
 * @author kinco
 */
@RestController
@RequestMapping("/api")
public class EmpleadoController {
    
    @Autowired
    private EmpleadoServices empleadoServices;
    
    @GetMapping("/listarEmpleado")
    private List<Empleado> empleados() {
        return empleadoServices.getEmpleados();
    }

    @PostMapping("/registrarEmpleado")
    public ResponseEntity<String> crearEmpleados(@RequestBody Empleado empleado) {
        String result = empleadoServices.agregar(empleado);
        return ResponseEntity.ok(result);
    }
 
    @PutMapping("/editarEmpleado")
    public ResponseEntity<String> editarEmpleado(@RequestBody Empleado empleado) {
    // Obtener el empleado existente por ID
        System.out.println(empleado.getIdEmpleado());
        Empleado empleadoExistente = empleadoServices.getEmpleadoPorID(empleado.getIdEmpleado());

        // Verificar si el empleado existe
        if (empleadoExistente == null) {
            return ResponseEntity.badRequest().body("{\"success\": false, \"message\": \"El empleado no existe\"}");
        }

        // Actualizar los datos del empleado existente con los datos recibidos
        empleadoExistente.getUsuario().setNombre(empleado.getUsuario().getNombre());
        empleadoExistente.getUsuario().setApellidos(empleado.getUsuario().getApellidos());
        empleadoExistente.getUsuario().setEmail(empleado.getUsuario().getEmail());
        empleadoExistente.getUsuario().setPassword(empleado.getUsuario().getPassword());
        empleadoExistente.getUsuario().setCedula(empleado.getUsuario().getCedula());
        empleadoExistente.getUsuario().setTelefono(empleado.getUsuario().getTelefono());

        // Verificar si algún otro empleado tiene los mismos datos
        Empleado empleadoExistenteCedula = empleadoServices.getEmpleadoPorCedula(empleado.getUsuario().getCedula());
        Empleado empleadoExistenteEmail = empleadoServices.getEmpleadoPorEmail(empleado.getUsuario().getEmail());
        Empleado empleadoExistenteTelefono = empleadoServices.getEmpleadoPorTelefono(empleado.getUsuario().getTelefono());

        // Verificar si algún otro empleado tiene la misma cédula, email o teléfono
        if (empleadoExistenteCedula != null && empleadoExistenteCedula.getIdEmpleado() != empleado.getIdEmpleado()) {
            return ResponseEntity.badRequest().body("{\"success\": false, \"message\": \"La cédula ya se encuentra asociada a otro empleado\"}");
        } else if (empleadoExistenteEmail != null && empleadoExistenteEmail.getIdEmpleado() != empleado.getIdEmpleado()) {
            return ResponseEntity.badRequest().body("{\"success\": false, \"message\": \"El email ya está asociado a otro empleado\"}");
        } else if (empleadoExistenteTelefono != null && empleadoExistenteTelefono.getIdEmpleado() != empleado.getIdEmpleado()) {
            return ResponseEntity.badRequest().body("{\"success\": false, \"message\": \"El teléfono está asociado a otro empleado\"}");
        }
        
        
        if(empleadoServices.agregarBoolean(empleado)){
             return ResponseEntity.ok().body("{\"success\": true, \"message\": \"El empleado se actualizo correctamente\"}");
        }else{
            return ResponseEntity.ok().body("{\"success\": false, \"message\": \"El empleado no se pudo actualizar\"}");
        }
        // Guardar los cambios en el empleado
           
        
    }

    @DeleteMapping("/eliminarEmpleado")
    public ResponseEntity<String> eliminarEmpleado(@RequestParam("id_Empleado") int id) {
        System.out.println("======>"+id);
        String result = empleadoServices.eliminar(id);
        return ResponseEntity.ok(result);
    }
    
    
}
