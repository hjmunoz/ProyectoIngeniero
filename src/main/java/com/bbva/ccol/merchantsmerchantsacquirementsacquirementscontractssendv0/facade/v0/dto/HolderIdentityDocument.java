package com.bbva.ccol.merchantsmerchantsacquirementsacquirementscontractssendv0.facade.v0.dto;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;

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
public class HolderIdentityDocument implements Serializable {

	private static final long serialVersionUID = -6885005435957814717L;
	
	@NotBlank(groups = INotificationRequiredInput.class)
	private String documentNumber;
	
}
