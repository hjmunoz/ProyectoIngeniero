package com.bbva.ccol.merchantsmerchantsacquirementsacquirementscontractssendv0.facade.v0.dto;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;

import com.bbva.ccol.merchantsmerchantsacquirementsacquirementscontractssendv0.facade.v0.validations.INotificationRequiredInput;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Clase que representa la informacion del usuario que realiza la operacion de
 * vinculacion
 * @author carlos.toro
 */
@Getter
@Setter
@NoArgsConstructor
public class BusinessAgent implements Serializable {

	private static final long serialVersionUID = -842868230137911948L;

	@NotBlank(groups = INotificationRequiredInput.class)
	private String id;
	
}
