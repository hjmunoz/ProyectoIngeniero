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
 * Clase que representa la informacion de las condiciones pactadas al momento de
 * vinculacion al servicio
 * @author carlos.toro
 */
@Getter
@Setter
@NoArgsConstructor
public class Conditions implements Serializable {

	private static final long serialVersionUID = -1217309898647774033L;

	@NotBlank(groups = INotificationRequiredInput.class)
	private String serviceName;
	
	@Valid
	@NotNull(groups = INotificationRequiredInput.class)
	private Fees fees;

}
