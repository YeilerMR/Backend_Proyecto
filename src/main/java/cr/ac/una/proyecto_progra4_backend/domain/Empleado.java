/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cr.ac.una.proyecto_progra4_backend.domain;

import cr.ac.una.proyecto_progra4_backend.domain.Usuario;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

/**
 *
 * @author kinco
 */
@Entity
@Table(name = "empleado")
public class Empleado {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_Empleado")
    private int idEmpleado;

    @ManyToOne
    @JoinColumn(name = "idUsuario_Empleado", referencedColumnName = "id_Usuario")
    private Usuario usuario;

    public Empleado() {
        //   this.usuario = new Usuario();
    }
    
        public Empleado(int idEmpleado, Usuario usuario) {
        this.idEmpleado = idEmpleado;
        this.usuario = usuario;
    }
    
    public int getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(int idEmpleado) {
        this.idEmpleado = idEmpleado;
    }
    
    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    
}