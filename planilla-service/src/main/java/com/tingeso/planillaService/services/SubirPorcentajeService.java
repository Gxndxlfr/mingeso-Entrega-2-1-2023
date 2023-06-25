package com.tingeso.planillaService.services;

import com.tingeso.planillaService.models.SubirPorcentajeModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class SubirPorcentajeService {

    @Autowired
    RestTemplate restTemplate;
    public Integer obtenerGrasaActual(String codigo) {
        SubirPorcentajeModel data = null;
        try {
            data = restTemplate.getForObject("http://subirPorcentaje-service/file-percentage/grasa/" + codigo, SubirPorcentajeModel.class);

            return Integer.valueOf(data.getGrasa());
        } catch (Exception e) {
            System.out.println("Error:"+ e.getMessage());
            return Integer.valueOf(data.getGrasa());
        }

    }

    public int obtenerStActual(String codigo) {

        SubirPorcentajeModel data = null;
        try {
            data = restTemplate.getForObject("http://subirPorcentaje-service/file-percentage/st/" + codigo, SubirPorcentajeModel.class);

            return Integer.valueOf(data.getSolidoTotal());
        } catch (Exception e) {
            System.out.println("Error:"+ e.getMessage());
            return Integer.valueOf(data.getSolidoTotal());
        }
    }

    public SubirPorcentajeModel obtenerPorcentajesPorCodigo(String codigo) {

        SubirPorcentajeModel data = null;
        try {
            data = restTemplate.getForObject("http://subirPorcentaje-service/file-percentage/st/" + codigo, SubirPorcentajeModel.class);

            return data;
        } catch (Exception e) {
            System.out.println("Error:"+ e.getMessage());
            return data;
        }
    }
}
