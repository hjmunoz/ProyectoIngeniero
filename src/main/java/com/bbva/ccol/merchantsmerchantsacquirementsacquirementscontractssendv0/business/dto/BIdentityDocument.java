package com.bbva.ccol.merchantsmerchantsacquirementsacquirementscontractssendv0.business.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Clase que representa la informacion de identificacion de una persona natural
 * o juridica.
 * @author carlos.toro
 */
@Getter
@Setter
@NoArgsConstructor
public class BIdentityDocument {

	private BDocumentType documentType;
	private String documentNumber;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private Date expeditionDate;
}
