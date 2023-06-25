package com.tingeso.proveedorService.models;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RegistroQuincenaModel {
    private Integer ID;
    private String kilos;
    private String codigo;
    private String grasa;
    private String st;

}
