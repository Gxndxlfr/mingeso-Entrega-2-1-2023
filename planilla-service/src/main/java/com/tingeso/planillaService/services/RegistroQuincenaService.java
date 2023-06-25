package com.tingeso.planillaService.services;

import com.tingeso.planillaService.models.RegistroQuincenaModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class RegistroQuincenaService {


    @Autowired
    RestTemplate restTemplate;
    public RegistroQuincenaModel actualizarDatos(String codigo, int kilos, int stActual, int grasaActual) {


        String k = String.valueOf(kilos);
        String s = String.valueOf(stActual);
        String g = String.valueOf(grasaActual);
        RegistroQuincenaModel quincena = new RegistroQuincenaModel(k,codigo,g,s);
        HttpEntity<RegistroQuincenaModel> request = new HttpEntity<>(quincena);
        System.out.println(quincena);
        RegistroQuincenaModel newQuincena = restTemplate.postForObject("http://registroQuincena-service/quincena/update", request, RegistroQuincenaModel.class);

        return newQuincena;
    }

    public int obtenerStAntigua(String codigo) {
        RegistroQuincenaModel data = null;
        try {
            data = restTemplate.getForObject("http://registroQuincena-service/quincena/" + codigo, RegistroQuincenaModel.class);

            return Integer.valueOf(data.getSt());
        } catch (Exception e) {
            System.out.println("Error:"+ e.getMessage());
            return Integer.valueOf(data.getSt());
        }
    }


    public int obtenerGrasaAntigua(String codigo) {
        RegistroQuincenaModel data = null;
        try {
            data = restTemplate.getForObject("http://registroQuincena-service/quincena/" + codigo, RegistroQuincenaModel.class);

            return Integer.valueOf(data.getGrasa());
        } catch (Exception e) {
            System.out.println("Error:"+ e.getMessage());
            return Integer.valueOf(data.getGrasa());
        }
    }

    public int getKilosByCodigo(String codigo) {

        RegistroQuincenaModel data = null;
        try {
            data = restTemplate.getForObject("http://registroQuincena-service/quincena/" + codigo, RegistroQuincenaModel.class);

            return Integer.valueOf(data.getKilos());
        } catch (Exception e) {
            System.out.println("Error:"+ e.getMessage());
            return Integer.valueOf(data.getKilos());
        }
    }
}
