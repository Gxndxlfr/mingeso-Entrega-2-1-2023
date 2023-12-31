package com.tingeso.subirDatasService.services;


import com.tingeso.subirDatasService.entities.SubirDataEntity;
import com.tingeso.subirDatasService.repositories.SubirDataRepository;
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
public class SubirDataService {

    @Autowired
    private SubirDataRepository dataRepository;

    private final Logger logg = LoggerFactory.getLogger(SubirDataService.class);

    public ArrayList<SubirDataEntity> obtenerData() {
        return (ArrayList<SubirDataEntity>) dataRepository.findAll();
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
        dataRepository.deleteAll();
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
                    guardarDataDB(bfRead.split(";")[0], bfRead.split(";")[1], bfRead.split(";")[2], bfRead.split(";")[3]);
                    temp = temp + "\n" + bfRead;
                }
            }
            texto = temp;
            return "Archivo leido exitosamente";
        }catch(Exception e){
            return "No se encontro el archivo";
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


    public void guardarDataDB(String fecha, String turno, String proveedor, String kls_leche){
        SubirDataEntity newData = new SubirDataEntity();
        newData.setFecha(fecha);
        newData.setTurno(turno);
        newData.setProveedor(proveedor);
        newData.setKls_leche(kls_leche);
        dataRepository.save(newData);
    }

    public ArrayList<SubirDataEntity> obtenerAcopioPorCodigo(String codigo) {
        return dataRepository.getbyCodigo(codigo);
    }

    public ArrayList<SubirDataEntity> obtenerAcopioPorTurnoAndCodigo(String turno, String codigo) {
        return dataRepository.getbyTurnoAndCodigo(turno, codigo);
    }

    public SubirDataEntity obtenerFechaPorCodigo(String codigo) {

        ArrayList<SubirDataEntity> acopio = dataRepository.getbyCodigo(codigo);
        return buscarPorCodigo(acopio, codigo);
    }

    public SubirDataEntity buscarPorCodigo(ArrayList<SubirDataEntity> acopio, String codigo){

        SubirDataEntity data = null;
        for(SubirDataEntity a:acopio){
            if(a.getProveedor().equals(codigo)){
                data = a;
            }
            else{
                data = null;
            }
        }
        return data;
    }

    public void eliminarData(String codigo){
        dataRepository.deleteByProveedor(codigo);

    }

    public void eliminarData(ArrayList<SubirDataEntity> datas){
        dataRepository.deleteAll(datas);
    }
}
