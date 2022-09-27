package com.bbva.ccol.merchantsmerchantsacquirementsacquirementscontractssendv0.facade.v0.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Enum que lista los tipos de documento que son permitidos por incocredito,
 * transformando el tipo de dato utilizado en ASO al tipo de dato de incocredito
 * 
 * @author carlos.toro
 *
 */
@Getter
@AllArgsConstructor
public enum DocumentTypeEnum {

	NIT,
	CC,
	CE,
	PASSPORT,
	TI,
	FOREIGNERS_NIT,
	SOCIAL_SECURITY_CARD,
	ESCROW,
	CIVIL_REGISTRATION;

}
