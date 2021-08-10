package com.iacg.domain.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Domain implements Serializable {

    private String id;

    private String name;

    private String description;

    private List<SubDomain> subDominios = new ArrayList<>();
    
    private static final long serialVersionUID = -8665071219309993755L;
}
