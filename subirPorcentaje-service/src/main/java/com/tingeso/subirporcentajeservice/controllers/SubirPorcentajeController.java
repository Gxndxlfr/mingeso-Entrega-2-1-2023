package com.tingeso.subirporcentajeservice.controllers;


import com.tingeso.subirporcentajeservice.entities.SubirPorcentajeEntity;
import com.tingeso.subirporcentajeservice.services.SubirPorcentajeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;

@RestController
@RequestMapping("/file-percentage")
public class SubirPorcentajeController {

    @Autowired
    private SubirPorcentajeService subirPorcentaje;

    @GetMapping
    public ResponseEntity<ArrayList<SubirPorcentajeEntity>> obtenerData() {
        ArrayList<SubirPorcentajeEntity> data = subirPorcentaje.obtenerData();
        if (data.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(data);
    }

    @PostMapping
    public void upload(@RequestParam("file") MultipartFile file, RedirectAttributes redirectAttributes) {
        subirPorcentaje.guardar(file);
        redirectAttributes.addFlashAttribute("mensaje", "¡Archivo porcentajes.csv cargado correctamente!");
        subirPorcentaje.leerCsv("porcentajes.csv");

    }





}
