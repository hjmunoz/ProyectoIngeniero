package com.bbva.ccol.merchantsmerchantsacquirementsacquirementscontractssendv0.facade.v0.dto;

import java.io.Serializable;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import com.bbva.ccol.merchantsmerchantsacquirementsacquirementscontractssendv0.facade.v0.validations.INotificationRequiredInput;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


/**
 * Clase que representa la informacion de la direccion fisica
 * @author carlos.toro
 */
@Getter
@Setter
@NoArgsConstructor
public class Address implements Serializable {

    private static final long serialVersionUID = -7082609007262757795L;

    @Valid
    @NotNull(groups = INotificationRequiredInput.class)
    private Location location;

}
