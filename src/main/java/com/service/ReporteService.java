package com.service;

import com.model.Reporte;
import com.repository.ReporteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Date;

@Service
public class ReporteService {

    private final ReporteRepository reporteRepository;

    @Autowired
    public ReporteService(ReporteRepository reporteRepository) {
        this.reporteRepository = reporteRepository;
    }

    public Reporte generarReporte(Reporte reporte) {
        reporte.setFechaGeneracion(new Date());
        return reporteRepository.save(reporte);
    }

    public Reporte editarReporte(int id, Reporte reporteActualizado) {
        Reporte reporteExistente = reporteRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Reporte no encontrado"));
        
        reporteExistente.setTipo(reporteActualizado.getTipo());
        reporteExistente.setAutor(reporteActualizado.getAutor());
        
        return reporteRepository.save(reporteExistente);
    }
}