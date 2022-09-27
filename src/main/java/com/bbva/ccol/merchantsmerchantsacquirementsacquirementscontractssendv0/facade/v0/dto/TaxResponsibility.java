package com.bbva.ccol.merchantsmerchantsacquirementsacquirementscontractssendv0.facade.v0.dto;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;

import com.bbva.ccol.merchantsmerchantsacquirementsacquirementscontractssendv0.facade.v0.validations.INotificationRequiredInput;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Clase que representa la informacion de la responsabilidad tributaria del
 * comercio vinculado
 * @author carlos.toro
 */
@Getter
@Setter
@NoArgsConstructor
public class TaxResponsibility implements Serializable {

	private static final long serialVersionUID = -6076157954524116542L;

	@NotBlank(groups = INotificationRequiredInput.class)
	private String code;

}
