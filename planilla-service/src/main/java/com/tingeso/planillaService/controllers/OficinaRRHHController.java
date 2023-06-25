package com.tingeso.planillaService.controllers;

import com.tingeso.planillaService.entities.OficinaRRHHEntity;
import com.tingeso.planillaService.services.OficinaRRHHService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.util.ArrayList;

@RestController
@RequestMapping("/oficinaRRHH")
public class OficinaRRHHController {

    @Autowired
    OficinaRRHHService oficinaRRHHService;

    @GetMapping
    public ResponseEntity<ArrayList<OficinaRRHHEntity>> planillaDeSueldos() throws ParseException {
        oficinaRRHHService.reportePlanilla();
        ArrayList<OficinaRRHHEntity> reporteSueldos = oficinaRRHHService.obtenerData();
        if(reporteSueldos.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(reporteSueldos);

    }
}
