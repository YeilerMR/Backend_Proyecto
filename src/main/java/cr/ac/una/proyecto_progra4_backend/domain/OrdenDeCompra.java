package cr.ac.una.proyecto_progra4_backend.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.sql.Date;

@Entity
@Table(name = "ordendecompra")
public class OrdenDeCompra {

    @Id
    @Column(name = "id_OrdenDeCompra")
    private int idOrdenDeCompra;
    @Column(name = "numeroReferencia_OrdenDeCompra")
    private String numeroReferencia;

    @ManyToOne
    @JoinColumn(name = "idProveedor_OrdenDeCompra", nullable = false)
    private Proveedor idProveedor;

    @ManyToOne
    @JoinColumn(name = "idPedido_OrdenDeCompra", nullable = false)
    private Pedido idPedido;
    @Column(name = "fechaOrden_OrdenDeCompra")
    private Date fechaOrden;
    @Column(name = "fechaEntrega_OrdenDeCompra")
    private Date fechaEntrega;
    @Column(name = "estadoOrden_OrdenDeCompra")
    private String estadoOrden;

    public OrdenDeCompra() {
        idOrdenDeCompra = 0;
        idProveedor = new Proveedor();
        idPedido = new Pedido();
        fechaOrden = new Date(0, 0, 0);
        fechaEntrega = new Date(0, 0, 0);
        numeroReferencia = "";
    }

    public OrdenDeCompra(int idOrdenDeCompra, Pedido idPedido, Proveedor idProveedor, Date fechaOrden, Date fechaEntrega, String estadoOrden, String numeroReferencia) {
        this.idOrdenDeCompra = idOrdenDeCompra;
        this.idPedido = idPedido;
        this.idProveedor = idProveedor;
        this.fechaOrden = fechaOrden;
        this.fechaEntrega = fechaEntrega;
        this.estadoOrden = estadoOrden;
        this.numeroReferencia = numeroReferencia;
    }

    public int getIdOrdenDeCompra() {
        return idOrdenDeCompra;
    }

    public void setIdOrdenDeCompra(int idOrdenDeCompra) {
        this.idOrdenDeCompra = idOrdenDeCompra;
    }

    public Pedido getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(Pedido idPedido) {
        this.idPedido = idPedido;
    }

    public Proveedor getIdProveedor() {
        return idProveedor;
    }

    public void setIdProveedor(Proveedor idProveedor) {
        this.idProveedor = idProveedor;
    }

    public Date getFechaOrden() {
        return fechaOrden;
    }

    public void setFechaOrden(Date fechaOrden) {
        this.fechaOrden = fechaOrden;
    }

    public Date getFechaEntrega() {
        return fechaEntrega;
    }

    public void setFechaEntrega(Date fechaEntrega) {
        this.fechaEntrega = fechaEntrega;
    }

    public String getEstadoOrden() {
        return estadoOrden;
    }

    public void setEstadoOrden(String estadoOrden) {
        this.estadoOrden = estadoOrden;
    }

    public String getNumeroReferencia() {
        return numeroReferencia;
    }

    public void setNumeroReferencia(String numeroReferencia) {
        this.numeroReferencia = numeroReferencia;
    }
}
