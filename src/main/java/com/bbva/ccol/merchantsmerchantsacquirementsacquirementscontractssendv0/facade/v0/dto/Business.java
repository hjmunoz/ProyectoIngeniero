package com.bbva.ccol.merchantsmerchantsacquirementsacquirementscontractssendv0.facade.v0.dto;

import java.io.Serializable;
import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.bbva.ccol.merchantsmerchantsacquirementsacquirementscontractssendv0.facade.v0.validations.INotificationRequiredInput;

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
public class Business implements Serializable {

    private static final long serialVersionUID = 7347107995880397397L;

    @NotBlank(groups = INotificationRequiredInput.class)
    private String id;
    
    @NotBlank(groups = INotificationRequiredInput.class)
    private String legalName;
    
    @NotBlank(groups = INotificationRequiredInput.class)
    private String doingBusinessAs;
    
    @NotBlank(groups = INotificationRequiredInput.class)
    private String commercialRegister;
    
    @Valid
    @NotNull(groups = INotificationRequiredInput.class)
    private BusinessDocument businessDocument;
    
    private String commercialActivity;
    
    @NotBlank(groups = INotificationRequiredInput.class)
    private String economicActivity;
    
    @NotBlank(groups = INotificationRequiredInput.class)
    private String merchantCategoryCode;
    
    private String merchantCategoryCodeReal;
    
    @Valid
    @NotNull(groups = INotificationRequiredInput.class)
    private List<Store> stores;
    
    @Valid
    @NotNull(groups = INotificationRequiredInput.class)
    private MailingAddress mailingAddress;
    
    @Valid
    @NotNull(groups = INotificationRequiredInput.class)
    private List<TaxResponsibility> taxResponsibilities;
    
}
