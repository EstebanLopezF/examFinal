package com.cenfotec.app.repo;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.cenfotec.app.domain.Atleta;
import com.cenfotec.app.domain.Condominio;

@Repository
public interface CondominioRepository extends JpaRepository<Atleta, Long>{
    
	@Query(value = "{call list_condominio}", nativeQuery = true)
	List<Condominio> listall();
    
    @Query(value = "{call getid_condominio(:idParam)}", nativeQuery = true)
    Optional<Condominio> getById(@Param("idParam") long id);
    
    @Query(value = "{call create_condominio(:cantidadUnidadesParam, :cedulaJuridicaParam, :direccionParam, :nombreParam, :representanteParam, :estadoParam, "
    		+ ":cuotaParam )}", nativeQuery = true)
    void create(
    		@Param("cantidadUnidadesParam")long cantidadUnidadesParam,  
    		@Param("cedulaJuridicaParam")String cedulaJuridicaParam,
    		@Param("direccionParam")String direccionParam,
    		@Param("nombreParam")String nombreParam,
    		@Param("representanteParam")String representanteParam,
    		@Param("estadoParam")String estadoParam,
    		@Param("cuotaParam")double cuotaParam
    );
    
    @Query(value = "{call searchEstado_condominio(:estadoParam)}", nativeQuery = true)
    List<Condominio> getByStatus(@Param("estadoParam") String nombreParam);

    @Query(value = "{call update_procedure(:cedulaParam, :pesoParam, :provinciaParam, :cantonParam, :distritoParam, :telefonoParam, :correoParam )}", nativeQuery = true)
    void updateProcedure(
            @Param("cedulaParam")long cedulaParam,   
            @Param("pesoParam")double pesoParam,
            @Param("provinciaParam")String provinciaParam,
            @Param("cantonParam")String cantonParam,
            @Param("distritoParam")String distritoParam,
            @Param("telefonoParam")String telefonoParam,
            @Param("correoParam")String correoParam
    );
    
    @Query(value = "{call update_condominio(:idParam, :cantidadUnidadesParam, :cedulaJuridicaParam, :direccionParam, :nombreParam, :representanteParam, :cuotaParam )}", nativeQuery = true)
    void update(          
            @Param("idParam")long idParam,
    		@Param("cantidadUnidadesParam")long cantidadUnidadesParam,  
    		@Param("cedulaJuridicaParam")String cedulaJuridicaParam,
    		@Param("direccionParam")String direccionParam,
    		@Param("nombreParam")String nombreParam,
    		@Param("representanteParam")String representanteParam,
    		@Param("cuotaParam")double cuotaParam
    );
    
}
















