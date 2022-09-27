package com.bbva.ccol.merchantsmerchantsacquirementsacquirementscontractssendv0.facade.v0.dto;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.bbva.ccol.merchantsmerchantsacquirementsacquirementscontractssendv0.facade.v0.validations.INotificationRequiredInput;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Clase que representa la informacion de una comision especifica incluyendo la
 * cantidad y el tipo de moneda utilizado
 * @author carlos.toro
 */
@Getter
@Setter
@NoArgsConstructor
public class ItemizeFeeUnit implements Serializable {

	private static final long serialVersionUID = -1709632839304956110L;

	@NotNull(groups = INotificationRequiredInput.class)
	private BigDecimal amount;
	
	@NotBlank(groups = INotificationRequiredInput.class)
	private String currency;
	
	@NotNull(groups = INotificationRequiredInput.class)
	private UnitTypeEnum unitType;

}
