package com.cenfotec.app.repo;

import java.sql.Date;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.cenfotec.app.domain.Amenidad;


@Repository
public interface AmenidadRepository extends JpaRepository<Amenidad, Long>{
        
    @Query(value = "{call list_Amenidades_Condominio(:idcondominioParam)}", nativeQuery = true)
    List<Amenidad> getByCondominio(@Param("idcondominioParam") long idcondominioParam);

    @Query(value = "{call create_amenidad(:amenidadParam, :idCondominioParam )}", nativeQuery = true)
    void create(
            @Param("amenidadParam")String amenidadParam,   
            @Param("idCondominioParam")long idCondominioParam
    );
    
}
















