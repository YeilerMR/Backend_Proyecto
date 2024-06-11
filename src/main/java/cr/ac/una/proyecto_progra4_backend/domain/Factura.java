package cr.ac.una.proyecto_progra4_backend.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import java.sql.Date;

/**
 * @author GONZALO DORMOS RODRIGUEZ
 */
@Entity
@Table(name = "facturacion")
/*----CREANDO CLASE FACTURA-----*/
public class Factura {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_Facturacion")
    private int id_factura;
    
    @Column(name="codigoFactura_Facturacion")
    private String codigo_factura;
    
    @Column(name="fechaFactura_Facturacion")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    
    @Column(name="precioTotal_Facturacion")
    private double precio_total;
    
    @Column(name="descuento_Facturacion")
    private double descuento;
    
    @Column(name="impuesto_Facturacion")
    private float impuesto;
    
    @Column(name="metodoPago_Facturacion")
    private String metodo_pago;
    
    @Column(name="observacion_Facturacion")
    private String observacion;

    public Factura() {
        this.id_factura = 0;
    }

    public Factura(int id_factura, String codigo_factura, Date fecha, double precio_total, double descuento, String metodo_pago, String observacion) {
        this.id_factura = id_factura;
        this.codigo_factura = codigo_factura;
        this.fecha = fecha;
        this.precio_total = precio_total;
        this.metodo_pago = metodo_pago;
        this.observacion = observacion;
        this.descuento = descuento;
    }

    public float getImpuesto() {
        return impuesto;
    }

    public void setImpuesto(float impuesto) {
        this.impuesto = impuesto;
    }

    public void setDescuento(double descuento) {
        this.descuento = descuento;
    }

    public void setId_factura(int id_factura) {
        this.id_factura = id_factura;
    }

    public void setCodigo_factura(String codigo_factura) {
        this.codigo_factura = codigo_factura;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public void setPrecio_total(double precio_total) {
        this.precio_total = precio_total;
    }

    public void setMetodo_pago(String metodo_pago) {
        this.metodo_pago = metodo_pago;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public double getDescuento() {
        return descuento;
    }

    public int getId_factura() {
        return id_factura;
    }

    public String getCodigo_factura() {
        return codigo_factura;
    }

    public Date getFecha() {
        return fecha;
    }

    public double getPrecio_total() {
        return precio_total;
    }

    public String getMetodo_pago() {
        return metodo_pago;
    }

    public String getObservacion() {
        return observacion;
    }
}
