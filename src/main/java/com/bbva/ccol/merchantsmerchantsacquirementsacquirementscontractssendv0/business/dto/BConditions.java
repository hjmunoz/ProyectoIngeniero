package com.bbva.ccol.merchantsmerchantsacquirementsacquirementscontractssendv0.business.dto;

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
public class BConditions {

	private String serviceName;
	private BFees fees;

}
