package com.tingeso.subirporcentajeservice.services;


import com.tingeso.subirporcentajeservice.entities.SubirPorcentajeEntity;
import com.tingeso.subirporcentajeservice.repositories.SubirPorcentajeRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

@Service
public class SubirPorcentajeService {

    @Autowired
    private SubirPorcentajeRepository porcentajeRepository;

    private final Logger logg = LoggerFactory.getLogger(SubirPorcentajeService.class);

    public ArrayList<SubirPorcentajeEntity> obtenerData() {
        return (ArrayList<SubirPorcentajeEntity>) porcentajeRepository.findAll();
    }

    public String guardar(MultipartFile file){
        String filename = file.getOriginalFilename();
        if(filename != null){
            if(!file.isEmpty()){
                try{
                    byte [] bytes = file.getBytes();
                    Path path  = Paths.get(file.getOriginalFilename());
                    Files.write(path, bytes);
                    logg.info("Archivo guardado");
                }
                catch (IOException e){
                    logg.error("ERROR", e);
                }
            }
            return "Archivo guardado con exito!";
        }
        else{
            return "No se pudo guardar el archivo";
        }
    }

   /** public MarcasRelojEntity obtenerEspecifico(String rut, String fecha){
        return marcasRelojRepository.buscarData(rut, fecha);
    }

    public MarcasRelojEntity obtenerEspecifico2(String rut, String fecha){
        return marcasRelojRepository.buscarData2(rut, fecha);
    }**/

   public String leerCsv(String direccion){
       String texto = "";
       BufferedReader bf = null;
       porcentajeRepository.deleteAll();
       try{
           bf = new BufferedReader(new FileReader(direccion));
           String temp = "";
           String bfRead;
           int count = 1;
           while((bfRead = bf.readLine()) != null){
               if (count == 1){
                   count = 0;
               }
               else{
                   guardarDataDB(bfRead.split(";")[0], bfRead.split(";")[1], bfRead.split(";")[2]);
                   temp = temp + "\n" + bfRead;
               }
           }
           texto = temp;
           return "Archivo leido exitosamente 2";
       }catch(Exception e){
           return "No se encontro el archivo 2";
       }finally{
           if(bf != null){
               try{
                   bf.close();
               }catch(IOException e){
                   logg.error("ERROR", e);
               }
           }
       }
   }


    public void guardarDataDB(String codigo, String grasa, String solidoTotal){
        SubirPorcentajeEntity newData = new SubirPorcentajeEntity();
        newData.setCodigo(codigo);
        newData.setGrasa(grasa);
        newData.setSolidoTotal(solidoTotal);
        porcentajeRepository.save(newData);
    }

    public SubirPorcentajeEntity obtenerPorcentajesPorCodigo(String codigo) {
        return porcentajeRepository.getbyCodigo(codigo);
    }

    public SubirPorcentajeEntity obtenerGrasaActual(String codigo) {
        return porcentajeRepository.getbyCodigo(codigo);
    }

    public SubirPorcentajeEntity obtenerStActual(String codigo) {
        return porcentajeRepository.getbyCodigo(codigo);
    }

    public String eliminarPorcentaje(String codigo){
        porcentajeRepository.deleteByCodigo(codigo);
        return "proveedor eliminado";
    }
}
