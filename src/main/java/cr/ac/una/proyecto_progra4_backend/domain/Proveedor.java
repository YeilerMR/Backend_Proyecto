/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cr.ac.una.proyecto_progra4_backend.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 *
 * @author Adam Acuña
 */
@Entity
@Table(name = "proveedor")
public class Proveedor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_Proveedor")
    private int idProveedor;
    @Column(name = "nombreProveedor_Proveedor")
    private String nombreProveedor;
    @Column(name = "telefonoProveedor_Proveedor")
    private String telefonoProveedor;
    @Column(name = "descripcionProveedor_Proveedor")
    private String descripcionProveedor;
    @Column(name = "correo_Proveedor")
    private String correo;
    @Column(name = "direccionProveedor_Proveedor")
    private String direccionProveedor;
    @Column(name = "categoriaServicio_Proveedor")
    private String categoriaServicio;
    @Column(name = "informacionAdicional_Proveedor")
    private String informacionAdicional;

    public Proveedor() {
        idProveedor = 0;
        nombreProveedor = "";
        telefonoProveedor = "";
        descripcionProveedor = "";
        correo = "";
        direccionProveedor = "";
        categoriaServicio = "";
        informacionAdicional = "";
    }

    public Proveedor(int idProveedor, String nombreProveedor, String telefonoProveedor, String descripcionProveedor, String correo, String direccionProveedor, String categoriaServicio, String informacionAdicional) {
        this.idProveedor = idProveedor;
        this.nombreProveedor = nombreProveedor;
        this.telefonoProveedor = telefonoProveedor;
        this.descripcionProveedor = descripcionProveedor;
        this.correo = correo;
        this.direccionProveedor = direccionProveedor;
        this.categoriaServicio = categoriaServicio;
        this.informacionAdicional = informacionAdicional;
    }

    public int getIdProveedor() {
        return idProveedor;
    }

    public void setIdProveedor(int idProveedor) {
        this.idProveedor = idProveedor;
    }

    public String getNombreProveedor() {
        return nombreProveedor;
    }

    public void setNombreProveedor(String nombreProveedor) {
        this.nombreProveedor = nombreProveedor;
    }

    public String getTelefonoProveedor() {
        return telefonoProveedor;
    }

    public void setTelefonoProveedor(String telefonoProveedor) {
        this.telefonoProveedor = telefonoProveedor;
    }

    public String getDescripcionProveedor() {
        return descripcionProveedor;
    }

    public void setDescripcionProveedor(String descripcionProveedor) {
        this.descripcionProveedor = descripcionProveedor;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getDireccionProveedor() {
        return direccionProveedor;
    }

    public void setDireccionProveedor(String direccionProveedor) {
        this.direccionProveedor = direccionProveedor;
    }

    public String getCategoriaServicio() {
        return categoriaServicio;
    }

    public void setCategoriaServicio(String categoriaServicio) {
        this.categoriaServicio = categoriaServicio;
    }

    public String getInformacionAdicional() {
        return informacionAdicional;
    }

    public void setInformacionAdicional(String informacionAdicional) {
        this.informacionAdicional = informacionAdicional;
    }
}
