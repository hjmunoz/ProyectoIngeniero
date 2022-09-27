package com.bbva.ccol.merchantsmerchantsacquirementsacquirementscontractssendv0.facade.v0.dto;

import java.io.Serializable;

import javax.validation.Valid;

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
public class ContractInformation implements Serializable {

	private static final long serialVersionUID = -3523243205114203728L;

	private String reference;
	
	@Valid
	private BusinessAgent businessAgent;

}
