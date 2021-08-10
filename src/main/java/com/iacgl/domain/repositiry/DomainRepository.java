package com.iacgl.domain.repositiry;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.iacg.domain.model.Domain;

@Repository
public class DomainRepository {
    
    private final String SP_FIND_ALL = "LISTAR_DOMINIOS";
    private final String SP_FIND_BY_ID = "DOMINIO_BY_ID";
    
    private final EntityManager entityManager;
    
    @Autowired
    public DomainRepository(final EntityManager entityManager) {
        this.entityManager = entityManager;
    }
    
    /**
     * 
     * @return Lista de Domain consultados
     */
    public List<Domain> findAll() {
        List<Object[]>  storedProcedureRows;
        List<Domain> listDomain = new ArrayList<>();
        //Proceso de almacenado
        StoredProcedureQuery storedProcedureQuery = entityManager.createStoredProcedureQuery(SP_FIND_ALL);
        // Registrar los parámetros de entrada y salida   
        storedProcedureQuery.registerStoredProcedureParameter(1, Class.class, ParameterMode.REF_CURSOR);
        // Realizamos la llamada al procedimiento
        storedProcedureQuery.execute();
        // Obtenemos el resultado del cursor en una lista
        storedProcedureRows = storedProcedureQuery.getResultList();
        //Mapear datos a Model
        if(storedProcedureRows.isEmpty())
            return null;
      //Procesar lista o fila de la consulta a Modelo o DTO
        //listDomain = (List<Domain>) storedProcedureRows;
        return listDomain;
    }
    
    /**
     * 
     * @param idDomain Dominio a buscar
     * @return Dominio con lista de subDominios 
     */
    public Domain findById(String idDomain){
        Domain domain;
        List<Object[]> storedProcedureRows;
        //Proceso de almacenado
        StoredProcedureQuery storedProcedureQuery = entityManager.createStoredProcedureQuery(SP_FIND_BY_ID);      
        // Registrar los tipos de parámetros de entrada y salida 
        storedProcedureQuery.registerStoredProcedureParameter(1, String.class, ParameterMode.IN);
        storedProcedureQuery.registerStoredProcedureParameter(2, Class.class, ParameterMode.REF_CURSOR);
        //Parametros del SP
        storedProcedureQuery.setParameter(1, idDomain); 
        // Realizamos la llamada al procedimiento
        storedProcedureQuery.execute();      
        // Obtenemos el resultado del cursor en una lista
        storedProcedureRows = storedProcedureQuery.getResultList();
        //Mapear datos a Model
        if(storedProcedureRows.isEmpty())
            return null;
        //Procesar lista o fila de la consulta
        domain = (Domain) storedProcedureRows;
        return domain;
    }
    
}
