package com.example.pruebaTecnica.repositories;

import com.example.pruebaTecnica.models.Detalle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DetalleRepository extends JpaRepository<Detalle, Long> {
    List<Detalle> findByFacturaNumFactura(Long numFactura);
}
