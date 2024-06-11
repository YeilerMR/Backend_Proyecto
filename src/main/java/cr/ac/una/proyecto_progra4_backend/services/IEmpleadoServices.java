/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package cr.ac.una.proyecto_progra4_backend.services;

import cr.ac.una.proyecto_progra4_backend.domain.Empleado;
import java.util.List;

/**
 *
 * @author kinco
 */
public interface IEmpleadoServices {

    public String agregar(Empleado empleado);

    public List<Empleado> getEmpleados();

    public String eliminar(int idUsuario);

    public Empleado getEmpleadoPorCedula(String cedula);

    public Empleado getEmpleadoPorID(int idUsuario);

    public Empleado getEmpleadoPorEmail(String email);

    public Empleado getEmpleadoPorTelefono(String telefono);

    public List<Empleado> obtenerRegistrosPaginados(int numeroPagina, int tamanoPagina);

    public String actualizarEmpleado(Empleado empleadoActualizado);

}
