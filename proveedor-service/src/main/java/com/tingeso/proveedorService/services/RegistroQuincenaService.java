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

    @Autowired
    RestTemplate restTemplate;

    public RegistroQuincenaModel guardarQuincena(String codigo, String kilos, String grasa, String st){
        RegistroQuincenaModel quincena = new RegistroQuincenaModel(kilos,codigo,grasa,st);
        HttpEntity<RegistroQuincenaModel> request = new HttpEntity<>(quincena);
        RegistroQuincenaModel newQuincena = restTemplate.postForObject("http://registroQuincena-service/", request, RegistroQuincenaModel.class);

        return newQuincena;
    }

}
