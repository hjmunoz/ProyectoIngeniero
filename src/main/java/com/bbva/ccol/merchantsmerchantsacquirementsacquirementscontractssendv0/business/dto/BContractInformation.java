package com.bbva.ccol.merchantsmerchantsacquirementsacquirementscontractssendv0.business.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Clase que representa la informacion del contrato de vinculacion entre el
 * comercio y el banco
 * @author carlos.toro
 */
@Getter
@Setter
@NoArgsConstructor
public class BContractInformation {

	private String reference;
	private BBusinessAgent businessAgent;

}
