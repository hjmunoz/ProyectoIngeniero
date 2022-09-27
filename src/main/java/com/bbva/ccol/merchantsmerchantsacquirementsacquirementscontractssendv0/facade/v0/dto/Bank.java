package com.bbva.ccol.merchantsmerchantsacquirementsacquirementscontractssendv0.facade.v0.dto;

import java.io.Serializable;

import javax.validation.Valid;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Clase que representa la informacion del banco
 * @author carlos.toro
 */
@Getter
@Setter
@NoArgsConstructor
public class Bank implements Serializable {

	private static final long serialVersionUID = -9072729829114626614L;

	@Valid
	private Branch branch;

}
