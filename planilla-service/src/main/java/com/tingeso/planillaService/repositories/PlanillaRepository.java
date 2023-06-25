package com.tingeso.planillaService.repositories;


import com.tingeso.planillaService.entities.PlanillaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface PlanillaRepository extends JpaRepository<PlanillaEntity, String> {

    @Transactional
    void deleteByCodigo(String codigo);
}
