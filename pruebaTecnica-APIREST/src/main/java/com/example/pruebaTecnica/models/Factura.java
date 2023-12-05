package com.example.pruebaTecnica.models;

import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "factura")
public class Factura {
    @Id
    private Long numFactura;

    @ManyToOne
    @JoinColumn(name = "idCliente", nullable = false)
    private Cliente cliente;

    private Date fecha;

    @OneToMany(mappedBy = "factura")
    private List<Detalle> detalles;


    public void setId(Long id) {
        this.numFactura = id;
    }

    public Long getId() {
        return numFactura;
    }

    public List<Detalle> getDetalles() {
        return detalles;
    }

    public void setDetalles(List<Detalle> detalles) {
        this.detalles = detalles;
    }
}