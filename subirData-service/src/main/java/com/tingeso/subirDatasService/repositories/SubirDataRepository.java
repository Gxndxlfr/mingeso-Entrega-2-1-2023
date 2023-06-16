package com.tingeso.subirDatasService.repositories;


import com.tingeso.subirDatasService.entities.SubirDataEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Repository
public interface SubirDataRepository extends JpaRepository <SubirDataEntity, Integer>{

    @Query(value = "select * from data as a where a.proveedor = :codigo",
            nativeQuery = true)
    ArrayList<SubirDataEntity> getbyCodigo(@Param("codigo") String codigo);

    @Query(value = "select * from data as a where a.proveedor = :codigo and a.turno = :turno",
            nativeQuery = true)
    ArrayList<SubirDataEntity> getbyTurnoAndCodigo(@Param("turno") String turno,@Param("codigo") String codigo);

    @Transactional
    void deleteByProveedor(String proveedor);
    //______________________________________________________________________



}