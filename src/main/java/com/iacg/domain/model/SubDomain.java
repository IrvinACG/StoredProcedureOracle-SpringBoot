package com.iacg.domain.model;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SubDomain implements Serializable{
    

    private String id;
 
    private String name;

    private String description;
    
    private String parentSubDomainName;
    
    private String domain;
    
    private static final long serialVersionUID = -8665079319309993755L;
    
}
