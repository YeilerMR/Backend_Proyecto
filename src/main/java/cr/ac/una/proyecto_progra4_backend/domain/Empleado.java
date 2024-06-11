/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cr.ac.una.proyecto_progra4_backend.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;


/**
 *
 * @author kinco
 */
@Entity
public class Empleado {
    @Id
    private int idEmpleado;
    
    public Empleado() {
    }
    
    public Empleado(int idEmpleado) {
        this.idEmpleado = idEmpleado;
    }
//
//    public Empleado(int idEmpleado, int id, String nombre, String apellidos, String email, String password, String cedula, String telefono, int credencial) {
//        super(id, nombre, apellidos, email, password, cedula, telefono, credencial);
//        this.idEmpleado = idEmpleado;
//    }

    public int getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(int idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    
}