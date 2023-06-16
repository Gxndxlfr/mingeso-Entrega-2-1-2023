package com.tingeso.subirDatasService.controllers;

import com.tingeso.subirDatasService.entities.SubirDataEntity;
import com.tingeso.subirDatasService.services.SubirDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;

@RestController
@RequestMapping("/fileUpload")
public class SubirDataController {

    @Autowired
    private SubirDataService subirData;

    @GetMapping
    public ResponseEntity<ArrayList<SubirDataEntity>> obtenerData() {
        ArrayList<SubirDataEntity> data = subirData.obtenerData();
        if (data.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(data);
    }

    @PostMapping
    public void upload(@RequestParam("file") MultipartFile file, RedirectAttributes redirectAttributes) {
        subirData.guardar(file);
        redirectAttributes.addFlashAttribute("mensaje", "¡Archivo Acopio.csv cargado correctamente!");
        subirData.leerCsv("Acopio.csv");

    }





}
