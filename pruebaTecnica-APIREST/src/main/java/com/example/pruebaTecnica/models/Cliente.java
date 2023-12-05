package com.example.pruebaTecnica.models;

import jakarta.persistence.*;


import java.util.Date;
import java.util.List;

@Entity
@Table(name = "cliente")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCliente;

    private String nombre;
    private String apellido;
    private String direccion;
    private Date fechaNacimiento;
    private String telefono;
    private String email;
    private String categoria;

    @OneToMany(mappedBy = "cliente")
    private List<Factura> facturas;


    public void setId(Long id) {
        this.idCliente = id;
    }

    @Id
    public Long getId() {
        return idCliente;
    }

}
