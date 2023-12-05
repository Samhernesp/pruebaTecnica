package com.example.pruebaTecnica.services;

import com.example.pruebaTecnica.models.Detalle;
import com.example.pruebaTecnica.models.Factura;
import com.example.pruebaTecnica.repositories.DetalleRepository;
import com.example.pruebaTecnica.repositories.FacturaRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FacturaServices {

    @Autowired
    private FacturaRepository facturaRepository;

    @Autowired
    private DetalleRepository detalleRepository;


    public double calcularTotalFactura(Long numFactura) {

        Optional<Factura> factura = facturaRepository.findById(numFactura);
        if (!factura.isPresent()) {
            throw new EntityNotFoundException("Factura no encontrada");
        }

        List<Detalle> detalles = detalleRepository.findByFacturaNumFactura(numFactura);
        double total = detalles.stream()
                .mapToDouble(detalle -> detalle.getPrecio() * detalle.getCantidad())
                .sum();

        if (total > 1000000 && detalles.size() >= 5) {
            total *= 0.90;
        }

        return total;
    }

}

