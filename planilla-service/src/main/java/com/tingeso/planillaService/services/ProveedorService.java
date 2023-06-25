package com.tingeso.planillaService.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tingeso.planillaService.models.ProveedorModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

@Service
public class ProveedorService {

    @Autowired
    RestTemplate restTemplate;
    public ArrayList<ProveedorModel> obtenerProveedores() {
        String url = "http://proveedor-service/empleado";
        ResponseEntity<Object[]> response = restTemplate.getForEntity(url, Object[].class); // Se usa lista de Object para mapear la repuesta JSON
        Object[] records = response.getBody(); // Obtener lista de proveedores desde microservicio proveedor
        if (records == null) {
            return null;
        }
        ObjectMapper mapper = new ObjectMapper(); // Mapper desde object a modelo Empleado
        return (ArrayList<ProveedorModel>) Arrays.stream(records)
                .map(proveedores -> mapper.convertValue(proveedores, ProveedorModel.class))
                .collect(Collectors.toList());
    }


}
