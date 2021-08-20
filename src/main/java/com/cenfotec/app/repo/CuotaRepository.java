package com.cenfotec.app.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.cenfotec.app.domain.Cuota;


@Repository
public interface CuotaRepository extends JpaRepository<Cuota, Long>{
        
    @Query(value = "{call list_cuota_condominio(:idcondominioParam)}", nativeQuery = true)
    List<Cuota> getByCondominio(@Param("idcondominioParam") long idcondominioParam);

    @Query(value = "{call create_historico_cuota(:idCondominioParam, :precioParam )}", nativeQuery = true)
    void create(
            @Param("idCondominioParam")long idCondominioParam,   
            @Param("precioParam")double precioParam
    );
    
}
















