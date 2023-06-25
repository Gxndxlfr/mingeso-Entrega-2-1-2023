package com.tingeso.planillaService.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tingeso.planillaService.models.ProveedorModel;
import com.tingeso.planillaService.models.SubirDataModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

@Service
public class SubirDataService {

    @Autowired
    RestTemplate restTemplate;
    public String obtenerFechaPorCodigo(String codigo) {
        SubirDataModel data = null;
        try {
            data = restTemplate.getForObject("http://subirData-service/fileUpload/" + codigo, SubirDataModel.class);

            return data.getFecha();
        } catch (Exception e) {
            System.out.println("Error:"+ e.getMessage());
            return data.getFecha();
        }
    }

    public ArrayList<SubirDataModel> obtenerAcopioPorCodigo(String codigo) {

        String url = "http://subirData-service/fileUpload/all/"+codigo;
        ResponseEntity<Object[]> response = restTemplate.getForEntity(url, Object[].class); // Se usa lista de Object para mapear la repuesta JSON
        Object[] records = response.getBody(); // Obtener lista de acopio desde microservicio subirData
        if (records == null) {
            return null;
        }
        ObjectMapper mapper = new ObjectMapper(); // Mapper desde object a modelo Empleado
        return (ArrayList<SubirDataModel>) Arrays.stream(records)
                .map(acopio -> mapper.convertValue(acopio, SubirDataModel.class))
                .collect(Collectors.toList());
    }

    public ArrayList<SubirDataModel> obtenerAcopioPorTurnoAndCodigo(String turno, String codigo) {
        String url = "http://subirData-service/fileUpload/"+codigo+"/"+turno;
        ResponseEntity<Object[]> response = restTemplate.getForEntity(url, Object[].class); //
        Object[] records = response.getBody();
        if (records == null) {
            return null;
        }
        ObjectMapper mapper = new ObjectMapper(); // Mapper desde object a modelo Empleado
        return (ArrayList<SubirDataModel>) Arrays.stream(records)
                .map(acopio -> mapper.convertValue(acopio, SubirDataModel.class))
                .collect(Collectors.toList());
    }
}
