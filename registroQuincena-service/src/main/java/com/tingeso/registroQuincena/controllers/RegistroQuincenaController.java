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

    @PostMapping("/save")
    public ResponseEntity<RegistroQuincenaEntity> save(@RequestBody RegistroQuincenaEntity quincena) {
        System.out.println("AAAAAAALO");
        System.out.println(quincena);
        RegistroQuincenaEntity newQuincena = quincenaService.guardarRegistroQuincena(quincena.getCodigo(),quincena.getGrasa(),
                quincena.getSt(), quincena.getKilos());

        System.out.println("AAAAAAALO 2");
        return ResponseEntity.ok(newQuincena);
    }

    @GetMapping("/{codigo}")
    public ResponseEntity<RegistroQuincenaEntity> obtenerStAntigua(@PathVariable("codigo") String codigo){
        RegistroQuincenaEntity data = quincenaService.obtenerStAntigua(codigo);
        if(data == null)
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(data);
    }


}
