package com.tingeso.registroQuincena.services;


import com.tingeso.registroQuincena.entities.RegistroQuincenaEntity;
import com.tingeso.registroQuincena.repositories.RegistroQuincenaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RegistroQuincenaService {

    //@Autowired
    //private ProveedorRepository proveedorRepository;

    @Autowired
    private RegistroQuincenaRepository registroQuincenaRepository;

    public RegistroQuincenaEntity guardarRegistroQuincena(String codigo, String grasa, String st,String kilos){
        RegistroQuincenaEntity registroQuincena = new RegistroQuincenaEntity();
        registroQuincena.setCodigo(codigo);
        registroQuincena.setGrasa(grasa);
        registroQuincena.setSt(st);
        registroQuincena.setKilos(kilos);
        registroQuincenaRepository.save(registroQuincena);
        return registroQuincena;
    }
    /*public String setAnteriorQuince() {

        List<ProveedorEntity> proveedores = proveedorRepository.findAll();



        for(ProveedorEntity p:proveedores){
            String codigo = p.getCodigo();
            RegistroQuincenaEntity rq = registroQuincenaRepository.getByCodigo(codigo);

            if(rq == null){
                guardarRegistroQuincena(p.getCodigo(),"0","0","0");
            }
        }
        return "set quincena anterior";
    }*/

    public int getKilosByCodigo(String codigo) {
       return Integer.parseInt(registroQuincenaRepository.getByCodigo(codigo).getKilos());
    }

    public int obtenerGrasaAntigua(String codigo) {
        return Integer.parseInt(registroQuincenaRepository.getByCodigo(codigo).getGrasa());
    }

    public RegistroQuincenaEntity obtenerStAntigua(String codigo) {
        return registroQuincenaRepository.getByCodigo(codigo);
    }

    public String actualizarDatos(String codigo, int kilos, int stActual, int grasaActual) {

        //eliminar por codigo
        System.out.println("        ------------------");
        registroQuincenaRepository.deleteByCodigo(codigo);
        System.out.println("        Eliminado by codigo");
        //nueva entidad por codigo
        RegistroQuincenaEntity nuevoRegistro = new RegistroQuincenaEntity();
        nuevoRegistro.setCodigo(codigo);
        nuevoRegistro.setKilos(String.valueOf(kilos));
        nuevoRegistro.setSt(String.valueOf(stActual));
        nuevoRegistro.setGrasa(String.valueOf(grasaActual));

        registroQuincenaRepository.save(nuevoRegistro);

        /*registroQuincenaRepository.updateKilosQuincena(codigo, kilos);
        registroQuincenaRepository.updateStQuincena(codigo, stActual);
        registroQuincenaRepository.updateGrasaQuincena(codigo, grasaActual);*/
        System.out.println("        ------------------");

        return "registro quincena actualizado";

    }

    public String eliminarQuincena(String codigo){
        registroQuincenaRepository.deleteByCodigo(codigo);
        return "proveedor eliminado";
    }
}
