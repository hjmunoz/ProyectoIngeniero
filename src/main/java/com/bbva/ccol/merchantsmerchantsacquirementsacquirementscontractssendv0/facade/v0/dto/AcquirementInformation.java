package com.bbva.ccol.merchantsmerchantsacquirementsacquirementscontractssendv0.facade.v0.dto;

import java.io.Serializable;
import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.bbva.ccol.merchantsmerchantsacquirementsacquirementscontractssendv0.facade.v0.validations.INotificationRequiredInput;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


/**
 * Clase que representa la informacion de la adquirencia
 * @author carlos.toro
 */
@Getter
@Setter
@NoArgsConstructor
public class AcquirementInformation implements Serializable {

	private static final long serialVersionUID = 406424604018371229L;

	@NotBlank(groups = INotificationRequiredInput.class)
	private String completionDate;
	
	@NotBlank(groups = INotificationRequiredInput.class)
	private String filedCity;
	
	@Valid
	@NotNull(groups = INotificationRequiredInput.class)
	private Business business;
	
	@Valid
	@NotNull(groups = INotificationRequiredInput.class)
	private LegalRepresentative legalRepresentative;
	
	@Valid
	@NotEmpty(groups = INotificationRequiredInput.class)
	private List<Shareholder> shareholders;
	
	@Valid
	@NotNull(groups = INotificationRequiredInput.class)
	private RelatedContract relatedContract;
	
	@Valid
	private FinancialInformation financialInformation;
	
	@Valid
	private InstallationData installationData;

}
