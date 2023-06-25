package com.tingeso.planillaService.models;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProveedorModel {
    private Long ID;
    private String codigo;
    private String nombre;
    private String categoria;
}
