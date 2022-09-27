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
 * Clase que representa una cantidad de dinero y su tipo de moneda
 * @author carlos.toro
 */
@Getter
@Setter
@NoArgsConstructor
public class CurrencyAmount implements Serializable {

	private static final long serialVersionUID = -8333926741562777308L;

	@NotNull(groups = INotificationRequiredInput.class)
	private BigDecimal amount;
	
	@NotBlank(groups = INotificationRequiredInput.class)
	private String currency;

}
