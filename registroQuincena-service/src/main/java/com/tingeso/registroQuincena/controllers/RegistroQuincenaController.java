package com.tingeso.registroQuincena.controllers;

import com.tingeso.registroQuincena.entities.RegistroQuincenaEntity;
import com.tingeso.registroQuincena.repositories.RegistroQuincenaRepository;
import com.tingeso.registroQuincena.services.RegistroQuincenaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


@RestController
@RequestMapping("/quincena")
public class RegistroQuincenaController {

    @Autowired
    private RegistroQuincenaService quincenaService;
    @Autowired
    private RegistroQuincenaRepository registroQuincenaRepository;

    @PostMapping
    public ResponseEntity<RegistroQuincenaEntity> save(@RequestBody RegistroQuincenaEntity quincena) {
        RegistroQuincenaEntity newQuincena = quincenaService.guardarRegistroQuincena(quincena.getCodigo(),quincena.getGrasa(),
                quincena.getSt(), quincena.getKilos());
        return ResponseEntity.ok(newQuincena);
    }
}
