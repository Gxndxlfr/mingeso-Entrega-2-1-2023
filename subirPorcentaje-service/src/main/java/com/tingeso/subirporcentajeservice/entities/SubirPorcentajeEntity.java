package com.tingeso.subirporcentajeservice.entities;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "porcentaje")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class SubirPorcentajeEntity {
    @Id
    @NotNull
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer ID;
    private String codigo;
    private String grasa;
    private String solidoTotal;
}