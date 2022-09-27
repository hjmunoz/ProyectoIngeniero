package com.bbva.ccol.merchantsmerchantsacquirementsacquirementscontractssendv0.business.dto;

import java.util.List;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


/**
 * Clase que representa la informacion del comercio que se esta vinculando
 * @author carlos.toro
 */
@Getter
@Setter
@NoArgsConstructor
public class BBusiness {

    private String id;
    private String legalName;
    private String doingBusinessAs;
    private String commercialRegister;
    private BBusinessDocument businessDocument;
    private String commercialActivity;
    private String economicActivity;
    private String merchantCategoryCode;
    private String merchantCategoryCodeReal;
    private List<BStore> stores;
    private BMailingAddress mailingAddress;
    private List<BTaxResponsibility> taxResponsibilities;
    
}
