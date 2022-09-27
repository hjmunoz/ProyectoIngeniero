package com.bbva.ccol.merchantsmerchantsacquirementsacquirementscontractssendv0.facade.v0.dto;

import java.io.Serializable;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Amount extends Unit implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2752699110198342436L;
	
	private String currency;
	private Double amount;

}
