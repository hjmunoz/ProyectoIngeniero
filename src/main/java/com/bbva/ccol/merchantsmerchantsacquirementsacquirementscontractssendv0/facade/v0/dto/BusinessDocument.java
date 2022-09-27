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
 * Clase que identifica la informacion del documento de identificacion del
 * comercio vinculado
 * @author carlos.toro
 */
@Getter
@Setter
@NoArgsConstructor
public class BusinessDocument implements Serializable {

	private static final long serialVersionUID = 8668894568647637974L;

	@Valid
	@NotNull(groups = INotificationRequiredInput.class)
	private BusinessDocumentType documentType;
	
	@NotBlank(groups = INotificationRequiredInput.class)
	private String documentNumber;
	
	private String verificationDigit;

}
