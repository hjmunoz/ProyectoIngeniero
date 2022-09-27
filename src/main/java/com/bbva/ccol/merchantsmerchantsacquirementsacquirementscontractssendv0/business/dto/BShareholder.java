package com.bbva.ccol.merchantsmerchantsacquirementsacquirementscontractssendv0.business.dto;

import java.math.BigDecimal;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Clase que representa la informacion de los participantes en la sociedad
 * incluyendo el porcentaje de participacion
 * @author carlos.toro
 */
@Getter
@Setter
@NoArgsConstructor
public class BShareholder {

	private String fullName;
	private BIdentityDocument identityDocument;
	private BigDecimal shareholdingPercentage;

}
