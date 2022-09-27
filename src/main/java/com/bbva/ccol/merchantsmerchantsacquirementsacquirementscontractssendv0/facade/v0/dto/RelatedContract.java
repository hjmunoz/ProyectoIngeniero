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
 * Clase que representa la informacion de la cuenta bancaria perteneciente al
 * comercio en la que sera depositado
 * @author carlos.toro
 */
@Getter
@Setter
@NoArgsConstructor
public class RelatedContract implements Serializable {

	private static final long serialVersionUID = 9189061290715879722L;

	@NotBlank(groups = INotificationRequiredInput.class)
	private String number;
	
	@Valid
	@NotNull(groups = INotificationRequiredInput.class)
	private Bank bank;
	
	@Valid
	@NotNull(groups = INotificationRequiredInput.class)
	private Holder holder;

}
