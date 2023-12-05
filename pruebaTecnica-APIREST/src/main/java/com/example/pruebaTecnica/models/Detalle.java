package com.example.pruebaTecnica.models;


import jakarta.persistence.*;


@Entity
@Table(name = "detalle")
public class Detalle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long numDetalle;

    @ManyToOne
    @JoinColumn(name = "numFactura", nullable = false)
    private Factura factura;

    @ManyToOne
    @JoinColumn(name = "idProducto", nullable = false)
    private Producto producto;



    private Integer cantidad;
    private double precio;


    public void setId(Long id) {
        this.numDetalle = id;
    }

    @Id
    public Long getId() {
        return numDetalle;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }


}
