package com.tingeso.proveedorService.services;

import com.tingeso.proveedorService.entities.ProveedorEntity;
import com.tingeso.proveedorService.repositories.ProveedorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;

@Service
public class ProveedorService {

    @Autowired
    ProveedorRepository proveedorRepository;

    @Autowired
    RestTemplate restTemplate;

    public void guardarProveedor(ProveedorEntity proveedor){

        proveedorRepository.save(proveedor);
    }

    public ArrayList<ProveedorEntity> obtenerProveedores(){
        return (ArrayList<ProveedorEntity>) proveedorRepository.findAll();
    }

    public String eliminarProveedores(String codigo){
        proveedorRepository.deleteByCodigo(codigo);
        return "proveedor eliminado";
    }
}
