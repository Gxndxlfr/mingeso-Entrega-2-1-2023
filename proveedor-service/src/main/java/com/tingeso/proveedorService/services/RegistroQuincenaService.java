package com.tingeso.proveedorService.services;

import com.tingeso.proveedorService.models.RegistroQuincenaModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class RegistroQuincenaService {
    @Autowired
    RestTemplate restTemplate;

    public RegistroQuincenaModel guardarRegistroQuincena(String codigo, String kilos, String grasa, String st){

        System.out.println("LLEGAMOSSSSSSSSSSSSSSSSSSSSSSS");
        RegistroQuincenaModel quincena = new RegistroQuincenaModel(1,kilos,codigo,grasa,st);
        HttpEntity<RegistroQuincenaModel> request = new HttpEntity<>(quincena);
        System.out.println(quincena);
        RegistroQuincenaModel newQuincena = restTemplate.postForObject("http://registroQuincena-service/quincena/save", request, RegistroQuincenaModel.class);

        return newQuincena;
    }

}
