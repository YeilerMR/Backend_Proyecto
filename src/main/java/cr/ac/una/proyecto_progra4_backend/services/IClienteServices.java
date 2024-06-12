/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package cr.ac.una.proyecto_progra4_backend.services;

import cr.ac.una.proyecto_progra4_backend.domain.Cliente;
import java.util.List;

/**
 *
 * @author Aaron
 */
public interface IClienteServices {

    public boolean agregar(Cliente cliente);

    public List<Cliente> getClientes();

// public List<Cliente> getClientesConEnvios();
    
    public boolean eliminar(int idUsuario);

    public Cliente getClientePorCedula(String cedula);

    public Cliente getClientePorID(int idUsuario);

    public Cliente getClientePorEmail(String email);

    public Cliente getClientePorTelefono(String telefono);

    public List<Cliente> obtenerRegistrosPaginados(int numeroPagina, int tamanoPagina);

    public String verificarPreAgregar(Cliente cliente);

    public String verificarPreModificar(Cliente cliente);
}
