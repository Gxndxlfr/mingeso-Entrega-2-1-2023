package com.tingeso.proveedorService.repositories;

import com.tingeso.proveedorService.entities.ProveedorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface ProveedorRepository extends JpaRepository<ProveedorEntity, String> {

    @Transactional
    void deleteByCodigo(String codigo);
}
