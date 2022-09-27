package com.bbva.ccol.merchantsmerchantsacquirementsacquirementscontractssendv0.facade.v0.dto;

import java.io.Serializable;

import javax.validation.Valid;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Clase que identifica la informacion financiera del comercio vinculado
 * @author carlos.toro
 */
@Getter
@Setter
@NoArgsConstructor
public class FinancialInformation implements Serializable {

	private static final long serialVersionUID = 4224338886742377855L;

	@Valid
	private CurrencyAmount monthlyIncomes;
	
	@Valid
	private CurrencyAmount otherIncomes;
	
	private String description;
	
	@Valid
	private CurrencyAmount monthlyExpenses;
	
	@Valid
	private CurrencyAmount assets;
	
	@Valid
	private CurrencyAmount liabilities;
	
	private String originOfFundsDeclaration;

}
