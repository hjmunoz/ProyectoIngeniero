package com.bbva.ccol.merchantsmerchantsacquirementsacquirementscontractssendv0.facade.v0.dto.request;

import java.io.Serializable;
import java.util.List;

import javax.validation.constraints.NotNull;

import com.bbva.ccol.merchantsmerchantsacquirementsacquirementscontractssendv0.facade.v0.dto.AcquirementInformation;
import com.bbva.ccol.merchantsmerchantsacquirementsacquirementscontractssendv0.facade.v0.dto.Conditions;
import com.bbva.ccol.merchantsmerchantsacquirementsacquirementscontractssendv0.facade.v0.dto.ContractInformation;
import com.bbva.ccol.merchantsmerchantsacquirementsacquirementscontractssendv0.facade.v0.dto.Rate;
import com.bbva.ccol.merchantsmerchantsacquirementsacquirementscontractssendv0.facade.v0.validations.INotificationRequiredInput;

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
public class SendRequest implements Serializable {

	private static final long serialVersionUID = 3213818414548825013L;
	
	private String codeTemplate;
	
	@NotNull(groups = INotificationRequiredInput.class)
	private AcquirementInformation acquirementInformation;
	
	@NotNull(groups = INotificationRequiredInput.class)
    private Conditions conditions;
	
    private ContractInformation contractInformation;
    
    private List<Rate> rate;
}
