package com.bbva.ccol.merchantsmerchantsacquirementsacquirementscontractssendv0.business.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Clase que identifica el tipo de documento de una persona natural o juridica
 * @author carlos.toro
 */
@Getter
@Setter
@NoArgsConstructor
public class BDocumentType {

	private BDocumentTypeEnum id;
	private String description;

}
