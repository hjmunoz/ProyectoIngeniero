package com.bbva.ccol.merchantsmerchantsacquirementsacquirementscontractssendv0.business.dto;

import java.util.List;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Clase que identifica la lista de las comisiones pactadas en el proceso de
 * vinculacion
 * @author carlos.toro
 */
@Getter
@Setter
@NoArgsConstructor
public class BFees {

	private List<BItemizeFee> itemizeFees;

}
