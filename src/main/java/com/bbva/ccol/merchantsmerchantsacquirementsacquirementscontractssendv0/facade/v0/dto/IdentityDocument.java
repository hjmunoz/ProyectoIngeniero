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
 * Clase que representa la informacion de identificacion de una persona natural
 * o juridica.
 * @author carlos.toro
 */
@Getter
@Setter
@NoArgsConstructor
public class IdentityDocument implements Serializable {

	private static final long serialVersionUID = 7830319988614517255L;

	@Valid
	@NotNull(groups = INotificationRequiredInput.class)
	private DocumentType documentType;

	@NotBlank(groups = INotificationRequiredInput.class)
	private String documentNumber;

	private String expeditionDate;
	
}
