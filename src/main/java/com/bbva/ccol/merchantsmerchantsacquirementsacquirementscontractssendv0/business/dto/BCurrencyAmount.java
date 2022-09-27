package com.bbva.ccol.merchantsmerchantsacquirementsacquirementscontractssendv0.business.dto;

import java.math.BigDecimal;

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
public class BCurrencyAmount {

	private BigDecimal amount;
	private String currency;

}
