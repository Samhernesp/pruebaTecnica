package com.example.pruebaTecnica.controllers;

import com.example.pruebaTecnica.services.FacturaServices;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/facturas")
public class FacturaController {
    @Autowired
    private FacturaServices facturaService;

    @GetMapping("/{numFactura}/valor")
    public ResponseEntity<?> obtenerValorFactura(@PathVariable Long numFactura) {
        try {
            double totalFactura = facturaService.calcularTotalFactura(numFactura);
            return new ResponseEntity<>(totalFactura, HttpStatus.OK);
        } catch (EntityNotFoundException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }
}
