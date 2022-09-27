package com.bbva.ccol.merchantsmerchantsacquirementsacquirementscontractssendv0.business.dto;

import java.math.BigDecimal;

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
public class BItemizeFeeUnit {

	private BigDecimal amount;
	private String currency;
	private BUnitTypeEnum unitType;

}
