package com.tingeso.subirporcentajeservice.repositories;


import com.tingeso.subirporcentajeservice.entities.SubirPorcentajeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Repository
public interface SubirPorcentajeRepository extends JpaRepository <SubirPorcentajeEntity, Integer>{

    @Query(value = "select * from porcentaje as p where p.codigo = :codigo",
            nativeQuery = true)
    SubirPorcentajeEntity getbyCodigo(@Param("codigo") String codigo);

    @Transactional
    void deleteByCodigo(String codigo);
}