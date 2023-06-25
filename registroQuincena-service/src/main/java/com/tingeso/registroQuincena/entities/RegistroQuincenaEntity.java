package com.tingeso.registroQuincena.entities;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table (name = "quincena")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class RegistroQuincenaEntity {

    @NotNull
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String kilos;
    private String codigo;
    private String grasa;
    private String st;
}