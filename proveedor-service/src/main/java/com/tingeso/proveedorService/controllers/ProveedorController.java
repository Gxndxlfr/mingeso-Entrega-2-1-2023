package com.tingeso.proveedorService.controllers;

import com.tingeso.proveedorService.entities.ProveedorEntity;
import com.tingeso.proveedorService.services.ProveedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/proveedor")
public class ProveedorController {

    @Autowired
    private ProveedorService proveedorService;

    //@Autowired
    //private RegistroQuincenaService registroQuincenaService;

    @GetMapping
    public ResponseEntity<ArrayList<ProveedorEntity>> obtenerData() {
        ArrayList<ProveedorEntity> data = proveedorService.obtenerProveedores();
        if (data.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(data);
    }

    @PostMapping
    public void guardarEmpleado(@RequestBody ProveedorEntity proveedor){

        proveedorService.guardarProveedor(proveedor);
        //registroQuincenaService.guardarRegistroQuincena(codigo,"0","0","0");
    }

   /* @PostMapping("/nuevo-proveedor")
    public String nuevoProveedor(@RequestParam("codigo") String codigo,
                                 @RequestParam("nombre") String nombre,
                                 @RequestParam("categoria") String categoria){
        proveedorService.guardarProveedor(codigo, nombre, categoria);
        registroQuincenaService.guardarRegistroQuincena(codigo,"0","0","0");
        return "redirect:/nuevo-proveedor";
    }*/





}
