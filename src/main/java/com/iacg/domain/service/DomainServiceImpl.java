package com.iacg.domain.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.iacg.domain.exception.ModelNotFoundException;
import com.iacg.domain.model.Domain;
import com.iacgl.domain.repositiry.DomainRepository;

@Service
public class DomainServiceImpl implements IDomainService {

    private final DomainRepository domainRepository;

    @Autowired
    public DomainServiceImpl(final DomainRepository domainRepository) {
        this.domainRepository = domainRepository;
    }
    
    
    /**
     * @return Listado de todos los Dominios con una lista de SubDominio
     * correspondientes al dominio
     */
    @Override
    @Transactional(readOnly = true)
    public List<Domain> findAll() {
        List<Domain> listDomain = (List<Domain>) domainRepository.findAll();
        if (listDomain == null) {
            throw new ModelNotFoundException("No domain list found");
        }
        return listDomain;
    }

    /**
     *
     * @param idDomain Dominio a buscar
     * @return Un Dominio con una lista de SubDominios pertenecientes al dominio
     */
    @Override
    @Transactional(readOnly = true)
    public Domain findById(String idDomain) {
        Domain domain = domainRepository.findById(idDomain);
        if (domain == null) {
            throw new ModelNotFoundException("Not found any Domain with ID: "+idDomain);
        }
        return domain;
    }

}
