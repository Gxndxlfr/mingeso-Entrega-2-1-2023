package com.tingeso.registroQuincena.entities;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name = "quincena")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class RegistroQuincenaEntity {
    @Id
    @NotNull
    private Integer ID;
    private String kilos;
    private String codigo;
    private String grasa;
    private String st;
}