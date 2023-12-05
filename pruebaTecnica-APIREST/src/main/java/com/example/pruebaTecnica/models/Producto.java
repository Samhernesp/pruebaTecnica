package com.example.pruebaTecnica.models;


import jakarta.persistence.*;

@Entity
@Table(name = "producto")
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idProducto;

    private String nombre;
    private double precio;
    private Integer stock;

    public void setId(Long id) {
        this.idProducto = id;
    }

    @Id
    public Long getId() {
        return idProducto;
    }


}
