package com.tingeso.planillaService.controllers;

import com.tingeso.planillaService.entities.OficinaRRHHEntity;
import com.tingeso.planillaService.entities.PlanillaEntity;
import com.tingeso.planillaService.services.PlanillaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/planilla")
public class PlanillaController {

    @Autowired
    private PlanillaService planillaService;

    @GetMapping
    public ResponseEntity<List<PlanillaEntity>> obtenerPlanilla() throws ParseException {

        List<PlanillaEntity> reporteSueldos = planillaService.calcularPagos();
        if(reporteSueldos.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(reporteSueldos);

    }


}
