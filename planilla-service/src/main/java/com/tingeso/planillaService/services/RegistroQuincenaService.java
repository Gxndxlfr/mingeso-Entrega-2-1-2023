package com.tingeso.planillaService.services;

import com.tingeso.planillaService.models.RegistroQuincenaModel;
import com.tingeso.planillaService.models.SubirPorcentajeModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class RegistroQuincenaService {


    @Autowired
    RestTemplate restTemplate;
    public void actualizarDatos(String codigo, int kilos, int stActual, int grasaActual) {
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
