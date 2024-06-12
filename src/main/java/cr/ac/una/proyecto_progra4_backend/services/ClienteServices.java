/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cr.ac.una.proyecto_progra4_backend.services;

import cr.ac.una.proyecto_progra4_backend.domain.Cliente;
import cr.ac.una.proyecto_progra4_backend.domain.Usuario;
import cr.ac.una.proyecto_progra4_backend.jpa.ClienteRepository;
import jakarta.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

/**
 *
 * @author Aaron
 */
@Service
@Primary
public class ClienteServices implements IClienteServices {

    @Autowired
    private ClienteRepository clienteRepo;
    @Autowired
    private UsuarioServices userServices;

    @Override
    public boolean agregar(Cliente cliente) {
        Usuario usuarioGuardado = userServices.agregar(cliente.getUsuario());
        if (usuarioGuardado != null) {
            clienteRepo.save(cliente);
            return true;
        }
        return false;
    }

    @Override
    public List<Cliente> getClientes() {
        return clienteRepo.getClientes();
    }

    @Override
    @Transactional
    public boolean eliminar(int idCliente) {
        try {
            // Buscar el cliente por su ID
            Optional<Cliente> clienteOptional = clienteRepo.findById(idCliente);

            // Verificar si el cliente existe
            if (clienteOptional.isPresent()) {
                Cliente cliente = clienteOptional.get();

                // Obtener el usuario asociado al cliente
                Usuario usuario = cliente.getUsuario();

                // Eliminar el usuario
                userServices.eliminar(usuario.getId());

                // Eliminar el cliente
                clienteRepo.delete(cliente);

                return true; // Se eliminó correctamente
            } else {
                return false; // Cliente no encontrado
            }
        } catch (Exception e) {
            return false; // Error al eliminar
        }
    }

    @Override
    public Cliente getClientePorCedula(String cedula) {
        return clienteRepo.findByCedula(cedula);
    }

    @Override
    public Cliente getClientePorID(int idUsuario) {
        return clienteRepo.findById(idUsuario).orElse(null);
    }

    @Override
    public Cliente getClientePorEmail(String email) {
        return clienteRepo.findByEmail(email);
    }

    @Override
    public Cliente getClientePorTelefono(String telefono) {
        return clienteRepo.findByTelefono(telefono);
    }

    @Override
    public List<Cliente> obtenerRegistrosPaginados(int numeroPagina, int tamanoPagina) {
        Page<Cliente> paginaCliente = clienteRepo.getClientesPages(PageRequest.of(numeroPagina, tamanoPagina));
        return paginaCliente.getContent();
    }

    //-------------------MÉTODOS FUNCIONALIDES PRE CRUD-------------------------
    //Verificar si alguno de los datos esta repetido antes de agregar un nuevo cliente
    @Override
    public String verificarPreAgregar(Cliente cliente) {
        Cliente clienteExistenteCedula = getClientePorCedula(cliente.getUsuario().getCedula());
        Cliente clienteExistenteEmail = getClientePorEmail(cliente.getUsuario().getEmail());
        Cliente clienteExistenteTelefono = getClientePorTelefono(cliente.getUsuario().getTelefono());

        if (clienteExistenteCedula != null) {
            return "{\"success\": false, \"message\": \"La cédula ya se encuentra asociada a otro cliente\"}";
        } else if (clienteExistenteEmail != null) {
            return "{\"success\": false, \"message\": \"El email ya está asociado a otro cliente\"}";
        } else if (clienteExistenteTelefono != null) {
            return "{\"success\": false, \"message\": \"El télefono está asociado a otro cliente\"}";
        } else {
            boolean agregadoExitosamente = agregar(cliente);
            if (agregadoExitosamente) {
                return "{\"success\": true, \"message\": \"Cliente agregado exitosamente\"}";
            } else {
                return "{\"success\": false, \"message\": \"Error al agregar el cliente\"}";
            }
        }
    }

    @Override
    public String verificarPreModificar(Cliente cliente) {
        // Obtener el cliente existente por ID
        Cliente clienteExistente = getClientePorID(cliente.getIdCliente());

        // Verificar si el cliente existe
        if (clienteExistente == null) {
            return "{\"success\": false, \"message\": \"El cliente no existe\"}";
        }

        // Verificar si los datos modificados son iguales a los datos actuales del cliente
        if (cliente.equals(clienteExistente)) {
            // Si los datos son iguales, no es necesario hacer más verificaciones
            boolean actualizadoExitosamente = agregar(cliente);
            if (actualizadoExitosamente) {
                return "{\"success\": true, \"message\": \"Cliente actualizado exitosamente\"}";
            } else {
                return "{\"success\": false, \"message\": \"Error al actualizar el cliente\"}";
            }
        }

        // Verificar si algún otro cliente tiene los mismos datos
        Cliente clienteExistenteCedula = getClientePorCedula(cliente.getUsuario().getCedula());
        Cliente clienteExistenteEmail = getClientePorEmail(cliente.getUsuario().getEmail());
        Cliente clienteExistenteTelefono = getClientePorTelefono(cliente.getUsuario().getTelefono());

        // Verificar si algún otro cliente tiene la misma cédula, email o teléfono
        if (clienteExistenteCedula != null && clienteExistenteCedula.getIdCliente() != cliente.getIdCliente()) {
            return "{\"success\": false, \"message\": \"La cédula ya se encuentra asociada a otro cliente\"}";
        } else if (clienteExistenteEmail != null && clienteExistenteEmail.getIdCliente() != cliente.getIdCliente()) {
            return "{\"success\": false, \"message\": \"El email ya está asociado a otro cliente\"}";
        } else if (clienteExistenteTelefono != null && clienteExistenteTelefono.getIdCliente() != cliente.getIdCliente()) {
            return "{\"success\": false, \"message\": \"El teléfono está asociado a otro cliente\"}";
        } else {
            // Si todos los datos están bien, procede con la actualización del cliente
            boolean actualizadoExitosamente = agregar(cliente);
            if (actualizadoExitosamente) {
                return "{\"success\": true, \"message\": \"Cliente actualizado exitosamente\"}";
            } else {
                return "{\"success\": false, \"message\": \"Error al actualizar el cliente\"}";
            }
        }
    }
//    @Override
//    public List<Cliente> getClientesConEnvios() {
//        return clienteRepo.findClientesConEnvios();
//    }

}
