
package cr.ac.una.proyecto_progra4_backend.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
// import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
// import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

import java.sql.Date;
/**
 * @author GONZALO DORMOS RODRIGUEZ 
 */
/*----- CREANDO PEDIDO -------*/
@Entity
@Table(name="pedido")
public class Pedido{ 
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_Pedido")
    private int id_pedido;
    
    @Column(name="codigo_Pedido")
    private String codigo;

    @ManyToOne //(fetch = FetchType.EAGER)
    @JoinColumn(name ="idEmpleado_Pedido")
    private Empleado empleado;
    
    //@Column(name="idProducto_Pedido")
//    @OneToOne(fetch = FetchType.EAGER)
//    @JoinColumn(name ="id_Producto")
//
    
    // @Column(name="cantidadProductos_pedido")
    // private int cantidad;
    
//  @Column(name="idFactura_Pedido")
//    @OneToOne(fetch = FetchType.EAGER)
//    @JoinColumn(name ="id_Facturacion")
// //
//     @ManyToOne
//     @JoinColumn(name ="idProducto_Pedido")
//     private Producto producto;


    @Column(name="estadoPedido_Pedido")
    private String estado_pedido;
    
    @Column(name="fechaPedido__Pedido")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    
    @Column(name="direccionEnvioPedido_Pedido")
    private String direccion_pedido;
    
    @Column(name="provinciaEnvioPedido_pedido")
    private String Provincia;
    
    @Column(name="cantonEnvio_Pedido")
    private String canton;
    

    @ManyToOne //(fetch = FetchType.EAGER)
    @JoinColumn(name ="idProducto_Pedido")
    private Producto producto;
    
    @Column(name="cantidadProductos_pedido")
    private int cantidad;

    @ManyToOne //(fetch = FetchType.EAGER)
    @JoinColumn(name ="idFactura_Pedido")
    private Factura factura;
    
    
    public Pedido() {
    }

    public Pedido(int id_pedido, String codigo, Empleado empleado, String estado_pedido, Date fecha,
            String direccion_pedido, String provincia, String canton, Producto producto, int cantidad,
            Factura factura) {
        this.id_pedido = id_pedido;
        this.codigo = codigo;
        this.empleado = empleado;
        this.estado_pedido = estado_pedido;
        this.fecha = fecha;
        this.direccion_pedido = direccion_pedido;
        Provincia = provincia;
        this.canton = canton;
        this.producto = producto;
        this.cantidad = cantidad;
        this.factura = factura;
    }


    public int getId_pedido() {
        return id_pedido;
    }


    public void setId_pedido(int id_pedido) {
        this.id_pedido = id_pedido;
    }


    public String getCodigo() {
        return codigo;
    }


    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }


    public Empleado getEmpleado() {
        return empleado;
    }


    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }


    public String getEstado_pedido() {
        return estado_pedido;
    }


    public void setEstado_pedido(String estado_pedido) {
        this.estado_pedido = estado_pedido;
    }


    public Date getFecha() {
        return fecha;
    }


    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }


    public String getDireccion_pedido() {
        return direccion_pedido;
    }


    public void setDireccion_pedido(String direccion_pedido) {
        this.direccion_pedido = direccion_pedido;
    }


    public String getProvincia() {
        return Provincia;
    }


    public void setProvincia(String provincia) {
        Provincia = provincia;
    }


    public String getCanton() {
        return canton;
    }


    public void setCanton(String canton) {
        this.canton = canton;
    }


    public Producto getProducto() {
        return producto;
    }


    public void setProducto(Producto producto) {
        this.producto = producto;
    }


    public int getCantidad() {
        return cantidad;
    }


    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }


    public Factura getFactura() {
        return factura;
    }


    public void setFactura(Factura factura) {
        this.factura = factura;
    }
}
