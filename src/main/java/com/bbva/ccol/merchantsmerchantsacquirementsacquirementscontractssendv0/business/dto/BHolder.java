package com.bbva.ccol.merchantsmerchantsacquirementsacquirementscontractssendv0.business.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Clase que identifica la informacion del dueño de una cuenta bancaria
 * @author carlos.toro
 */
@Getter
@Setter
@NoArgsConstructor
public class BHolder {

	private BIdentityDocument identityDocument;
	private String fullName; 

}
