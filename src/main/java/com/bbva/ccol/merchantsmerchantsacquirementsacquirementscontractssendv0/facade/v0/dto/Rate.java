package com.bbva.ccol.merchantsmerchantsacquirementsacquirementscontractssendv0.facade.v0.dto;

import java.io.Serializable;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Rate implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1881859723559653526L;
	private RateType rateType;
	private Unit unit;
	
	
}
