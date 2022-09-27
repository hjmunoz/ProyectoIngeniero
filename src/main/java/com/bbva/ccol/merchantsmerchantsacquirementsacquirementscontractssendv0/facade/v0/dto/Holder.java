package com.bbva.ccol.merchantsmerchantsacquirementsacquirementscontractssendv0.facade.v0.dto;

import java.io.Serializable;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.bbva.ccol.merchantsmerchantsacquirementsacquirementscontractssendv0.facade.v0.validations.INotificationRequiredInput;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Clase que identifica la informacion del dueño de una cuenta bancaria
 * @author carlos.toro
 */
@Getter
@Setter
@NoArgsConstructor
public class Holder implements Serializable {

	private static final long serialVersionUID = -3506728168217885038L;

	@Valid
	@NotNull(groups = INotificationRequiredInput.class)
	private HolderIdentityDocument identityDocument;
	
	@NotBlank(groups = INotificationRequiredInput.class)
	private String fullName; 

}
