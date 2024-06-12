/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cr.ac.una.proyecto_progra4_backend.controller;

import cr.ac.una.proyecto_progra4_backend.domain.Cliente;
import cr.ac.una.proyecto_progra4_backend.domain.Usuario;
import cr.ac.una.proyecto_progra4_backend.services.ClienteServices;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException;

/**
 *
 * @author Aaron
 */
@RestController
@RequestMapping("/api")
public class ClienteController {

    @Autowired
    private ClienteServices clienteServices;

    @GetMapping("/cliente")
    public ResponseEntity<List<Cliente>> get() {
        List<Cliente> clientes = clienteServices.getClientes();
        return ResponseEntity.ok(clientes);
    }

    @PostMapping("/guardar")
    public ResponseEntity<?> save(@RequestBody Cliente clienteJSON) {
        // Extraer datos del objeto Cliente y realizar validación
        Usuario clienteUsuario = clienteJSON.getUsuario();
        ResponseEntity<?> validationResponse = validateClientData(clienteUsuario.getEmail(), clienteUsuario.getTelefono(), clienteUsuario.getCedula());
        if (validationResponse != null) {
            return validationResponse;
        }
        // Agregar el cliente
        boolean agregadoExitosamente = clienteServices.agregar(clienteJSON);
        if (agregadoExitosamente) {
            return ResponseEntity.ok().body("{\"success\": true, \"message\": \"Cliente agregado exitosamente\"}");
        } else {
            return ResponseEntity.badRequest().body("{\"success\": false, \"message\": \"Error al agregar el cliente\"}");
        }
    }

    // Método para validar los datos del cliente
    private ResponseEntity<?> validateClientData(String email, String telefono, String cedula) {
        // Verificar si algún otro cliente tiene los mismos datos
        Cliente clienteExistenteCedula = clienteServices.getClientePorCedula(cedula);
        Cliente clienteExistenteEmail = clienteServices.getClientePorEmail(email);
        Cliente clienteExistenteTelefono = clienteServices.getClientePorTelefono(telefono);

        if (clienteExistenteCedula != null) {
            return ResponseEntity.badRequest().body("{\"success\": false, \"message\": \"La cédula ya se encuentra asociada a otro cliente\"}");
        } else if (clienteExistenteEmail != null) {
            return ResponseEntity.badRequest().body("{\"success\": false, \"message\": \"El email ya está asociado a otro cliente\"}");
        } else if (clienteExistenteTelefono != null) {
            return ResponseEntity.badRequest().body("{\"success\": false, \"message\": \"El teléfono está asociado a otro cliente\"}");
        }

        // Si pasa todas las validaciones, devuelve null
        return null;
    }

    @GetMapping("/buscar")
    public ResponseEntity<Cliente> buscarCliente(@RequestParam(value = "textoBuscar") String cedula) {
        Cliente cliente = clienteServices.getClientePorCedula(cedula);
        if (cliente != null) {
            return ResponseEntity.ok(cliente);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @GetMapping("/listar")
    public ResponseEntity<List<Cliente>> mostrarLista(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int pageSize) {
        List<Cliente> clientes = clienteServices.obtenerRegistrosPaginados(page, pageSize);
        return ResponseEntity.ok(clientes);
    }

    @PostMapping("/actualizar")
    public ResponseEntity<?> actualizarCliente(@RequestParam("idCliente") int idCliente, @RequestBody Cliente clienteJSON) {
        // Obtener el cliente existente por ID
        Cliente clienteExistente = clienteServices.getClientePorID(idCliente);

        // Verificar si el cliente existe
        if (clienteExistente == null) {
            return ResponseEntity.badRequest().body("{\"success\": false, \"message\": \"El cliente no existe\"}");
        }

        // Extraer datos del objeto Cliente y realizar validación
        Usuario clienteUsuario = clienteJSON.getUsuario();

        // Verificar si algún otro cliente tiene los mismos datos
        Cliente clienteExistenteCedula = clienteServices.getClientePorCedula(clienteUsuario.getCedula());
        Cliente clienteExistenteEmail = clienteServices.getClientePorEmail(clienteUsuario.getEmail());
        Cliente clienteExistenteTelefono = clienteServices.getClientePorTelefono(clienteUsuario.getTelefono());

        // Verificar si algún otro cliente tiene la misma cédula, email o teléfono
        if (clienteExistenteCedula != null && clienteExistenteCedula.getIdCliente() != idCliente) {
            return ResponseEntity.badRequest().body("{\"success\": false, \"message\": \"La cédula ya se encuentra asociada a otro cliente\"}");
        } else if (clienteExistenteEmail != null && clienteExistenteEmail.getIdCliente() != idCliente) {
            return ResponseEntity.badRequest().body("{\"success\": false, \"message\": \"El email ya está asociado a otro cliente\"}");
        } else if (clienteExistenteTelefono != null && clienteExistenteTelefono.getIdCliente() != idCliente) {
            return ResponseEntity.badRequest().body("{\"success\": false, \"message\": \"El teléfono está asociado a otro cliente\"}");
        }

        // Actualizar los datos del cliente existente con los datos recibidos
        clienteExistente.getUsuario().setNombre(clienteUsuario.getNombre());
        clienteExistente.getUsuario().setApellidos(clienteUsuario.getApellidos());
        clienteExistente.getUsuario().setEmail(clienteUsuario.getEmail());
        clienteExistente.getUsuario().setPassword(clienteUsuario.getPassword());
        clienteExistente.getUsuario().setCedula(clienteUsuario.getCedula());
        clienteExistente.getUsuario().setTelefono(clienteUsuario.getTelefono());

        // Guardar los cambios en el cliente
        boolean actualizadoExitosamente = clienteServices.agregar(clienteExistente);
        if (actualizadoExitosamente) {
            return ResponseEntity.ok().body("{\"success\": true, \"message\": \"Cliente actualizado exitosamente\"}");
        } else {
            return ResponseEntity.badRequest().body("{\"success\": false, \"message\": \"Error al actualizar el cliente\"}");
        }
    }

    @DeleteMapping("/eliminar")
    public ResponseEntity<Map<String, Object>> eliminarCliente(@RequestParam("id_Cliente") int id_Cliente) {
        try {
            boolean eliminadoExitosamente = clienteServices.eliminar(id_Cliente);
            Map<String, Object> response = new HashMap<>();
            response.put("success", eliminadoExitosamente);
            if (!eliminadoExitosamente) {
                response.put("message", "No se pudo eliminar porque está asociado a un envío");
            }
            return ResponseEntity.ok(response);
        } catch (HttpClientErrorException.BadRequest e) {
            Map<String, Object> response = new HashMap<>();
            response.put("success", false);
            response.put("message", "No se pudo eliminar porque está asociado a un envío");
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            // Otro tipo de excepción no esperada
            Map<String, Object> response = new HashMap<>();
            response.put("success", false);
            response.put("message", "Ocurrió un error inesperado");
            return ResponseEntity.ok(response);
        }
    }

}
