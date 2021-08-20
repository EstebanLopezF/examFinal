package com.cenfotec.app.repo;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.cenfotec.app.domain.Condomino;

@Repository
public interface CondominoRepository extends JpaRepository<Condomino, Long>{
    

    
    @Query(value = "{call getid_condomino(:idParam)}", nativeQuery = true)
    Optional<Condomino> getById(@Param("idParam") long id);
	
    @Query(value = "{call list_condomino_Condominio(:idcondominioParam)}", nativeQuery = true)
    List<Condomino> getByCondominio(@Param("idcondominioParam") long idcondominioParam);
    
    @Query(value = "{call create_condomino(:nombreParam, :idCondominioParam )}", nativeQuery = true)
    void create(
    		@Param("nombreParam")String nombreParam,
    		@Param("idCondominioParam")long idCondominioParam
    );
    
    @Query(value = "{call update_condomino(:idParam, :idCondominioParam, :nombreParam)}", nativeQuery = true)
    void update(          
            @Param("idParam")long idParam,
    		@Param("idCondominioParam")long idCondominioParam,  
    		@Param("nombreParam")String nombreParam
    );
    
    @Query(value = "{call eliminar_condomino(:idParam)}", nativeQuery = true)
    void disable(@Param("idParam") long id);
    
}
















