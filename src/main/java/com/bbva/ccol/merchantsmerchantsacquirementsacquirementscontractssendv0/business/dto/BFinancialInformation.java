package com.bbva.ccol.merchantsmerchantsacquirementsacquirementscontractssendv0.business.dto;

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
public class BFinancialInformation {

	private BCurrencyAmount monthlyIncomes;
	private BCurrencyAmount otherIncomes;
	private String description;
	private BCurrencyAmount monthlyExpenses;
	private BCurrencyAmount assets;
	private BCurrencyAmount liabilities;
	private String originOfFundsDeclaration;



}


