package com.repository;

import com.model.Reporte;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReporteRepository extends JpaRepository<Reporte, Integer> {
  
}