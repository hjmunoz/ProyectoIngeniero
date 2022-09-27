package com.bbva.ccol.merchantsmerchantsacquirementsacquirementscontractssendv0.facade.v0.dto;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;

import com.bbva.ccol.merchantsmerchantsacquirementsacquirementscontractssendv0.facade.v0.validations.INotificationRequiredInput;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Clase que identifica el tipo de documento de una persona natural o juridica
 * @author carlos.toro
 */
@Getter
@Setter
@NoArgsConstructor
public class BusinessDocumentType implements Serializable {

	private static final long serialVersionUID = 3264243578213839061L;

	@NotBlank(groups = INotificationRequiredInput.class)
	private BusinessDocumentTypeEnum id;
	
	private String description;

}
