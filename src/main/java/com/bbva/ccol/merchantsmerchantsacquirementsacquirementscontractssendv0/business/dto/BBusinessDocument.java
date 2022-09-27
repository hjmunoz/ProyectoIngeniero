package com.bbva.ccol.merchantsmerchantsacquirementsacquirementscontractssendv0.business.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Clase que identifica la informacion del documento de identificacion del
 * comercio vinculado
 * @author carlos.toro
 */
@Getter
@Setter
@NoArgsConstructor
public class BBusinessDocument {

	private BBusinessDocumentType documentType;
	private String documentNumber;
	private String verificationDigit;

}
