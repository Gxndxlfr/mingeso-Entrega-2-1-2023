package com.tingeso.planillaService.entities;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "planilla")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class PlanillaEntity {
    @Id
    @NotNull
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer ID;
    private String quincena;
    private String codigo;
    private String nombre;
    private int klsLeche;
    private int cantDias;
    private double promedioKlsLeche;
    private double varLeche;
    private int Grasa;
    private double varGrasa;
    private int St;
    private double varSt;
    private int pagoLeche;
    private int pagoGrasa;
    private int pagoSt;
    private int bonificacionFrecuencia;
    private int descuentoLeche;
    private int descuentoGrasa;
    private int descuentoSt;
    private int pagoTotal;
    private int retencion;
    private int pagoFinal;

}
