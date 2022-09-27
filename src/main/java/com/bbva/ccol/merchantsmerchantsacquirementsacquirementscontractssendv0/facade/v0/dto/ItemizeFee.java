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
 * Clase que representa la informacion de las comisiones
 * @author carlos.toro
 */
@Getter
@Setter
@NoArgsConstructor
public class ItemizeFee implements Serializable {

	private static final long serialVersionUID = 483159475293444753L;

	@NotBlank(groups = INotificationRequiredInput.class)
	private FeeTypeEnum feeType;
	
	private String description;
	
	@Valid
	@NotNull(groups = INotificationRequiredInput.class)
	private ItemizeFeeUnit itemizeFeeUnit;

}
