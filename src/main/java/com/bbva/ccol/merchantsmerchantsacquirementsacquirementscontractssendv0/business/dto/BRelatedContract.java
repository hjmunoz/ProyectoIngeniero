package com.bbva.ccol.merchantsmerchantsacquirementsacquirementscontractssendv0.business.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Clase que representa la informacion de la cuenta bancaria perteneciente al
 * comercio en la que sera depositado
 * @author carlos.toro
 */
@Getter
@Setter
@NoArgsConstructor
public class BRelatedContract {

	private String number;
	private BBank bank;
	private BHolder holder;

}
