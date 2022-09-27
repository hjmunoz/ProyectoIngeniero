package com.bbva.ccol.merchantsmerchantsacquirementsacquirementscontractssendv0.business.dto;

import java.util.List;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * DTO que representa los parametros de entrada del servicio request-acquisition
 * @author carlos.toro
 */
@Getter
@Setter
@NoArgsConstructor
public class BSendRequest {
	
	private String codeTemplate;
	private BAcquirementInformation acquirementInformation;
	private BConditions conditions;
	private BContractInformation contractInformation;
	private List<BRate> rate;

}
