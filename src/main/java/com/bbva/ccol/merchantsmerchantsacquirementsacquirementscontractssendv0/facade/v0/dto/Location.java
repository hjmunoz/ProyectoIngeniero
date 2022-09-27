package com.bbva.ccol.merchantsmerchantsacquirementsacquirementscontractssendv0.facade.v0.dto;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;

import com.bbva.ccol.merchantsmerchantsacquirementsacquirementscontractssendv0.facade.v0.validations.INotificationRequiredInput;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Clase que representa la informacion de localizacion especificando la
 * direccion fisica
 * @author carlos.toro
 */
@Getter
@Setter
@NoArgsConstructor
public class Location implements Serializable {

	private static final long serialVersionUID = -2132132268313117308L;

	@NotBlank(groups = INotificationRequiredInput.class)
	private String formattedAddress;

}
