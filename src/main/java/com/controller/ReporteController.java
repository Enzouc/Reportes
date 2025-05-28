package com.controller;

import com.model.Reporte;
import com.service.ReporteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/reportes")
public class ReporteController {

    private final ReporteService reporteService;

    @Autowired
    public ReporteController(ReporteService reporteService) {
        this.reporteService = reporteService;
    }

    @PostMapping
    public ResponseEntity<Reporte> generarReporte(@RequestBody Reporte reporte) {
        return ResponseEntity.ok(reporteService.generarReporte(reporte));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Reporte> editarReporte(@PathVariable int id, @RequestBody Reporte reporte) {
        return ResponseEntity.ok(reporteService.editarReporte(id, reporte));
    }
}