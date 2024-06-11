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
 * @author yeile
 */
@Entity
@Table(name = "producto")
public class Producto {
    
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_Producto")
    private int id;

    @Column(name = "nombre_Producto")
    private String nombre;

    @Column(name = "descripcion_Producto")
    private String descripcion;

    @Column(name = "precio_Producto")
    private double precio;

    @Column(name = "categoria_Producto")
    private String categoria;

    @Column(name = "calificacion_Producto")
    private int calificacion;

    @Column(name = "disponibilidad_Producto")
    private boolean disponible;

    @Column(name = "stock_Producto")
    private int stock;

    @Column(name = "codProducto")
    private String codigo;

    public Producto() {
    }

    public Producto( String nombre, String descripcion, double precio, String categoria, int calificacion,
            boolean disponible, int stock, String codigo) {
        //this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
        this.categoria = categoria;
        this.calificacion = calificacion;
        this.disponible = disponible;
        this.stock = stock;
        this.codigo = codigo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public int getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(int calificacion) {
        this.calificacion = calificacion;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    @Override
    public String toString() {
        return "Producto [id=" + id + ", nombre=" + nombre + ", descripcion=" + descripcion + ", precio=" + precio
                + ", categoria=" + categoria + ", calificacion=" + calificacion + ", disponible=" + disponible
                + ", stock=" + stock + ", codigo=" + codigo + "]";
    }

    
    /**
    private String codigo, nombre, descripcion, categoria;
    private int calificacion;
    private double precio;
    private boolean disponible; //se vendio el producto??

    public Producto() {
    }

    public Producto(String codigo, String nombre, String descripcion, String categoria, int calificacion, double precio, boolean disponible) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.categoria = categoria;
        this.calificacion = calificacion;
        this.precio = precio;
        this.disponible = disponible;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public int getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(int calificacion) {
        this.calificacion = calificacion;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponibilidad(boolean disponible) {
        this.disponible = disponible;
    }

    @Override
    public String toString() {
        return "Producto{" + "codigoProducto=" + codigo + ", nombreProducto=" + nombre + ", descripcion=" + descripcion + ", categoria=" + categoria + ", calificacion=" + calificacion + ", precio=" + precio + ", ventaProducto=" + disponible + '}';
    }
    ***/
}
