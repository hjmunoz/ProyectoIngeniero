package com.bbva.ccol.merchantsmerchantsacquirementsacquirementscontractssendv0.business.dto;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;

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
public class BAcquirementInformation {

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern="yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
	private Date completionDate;
	private String filedCity;
	private BBusiness business;
	private BLegalRepresentative legalRepresentative;
	private List<BShareholder> shareholders;
	private BRelatedContract relatedContract;
	private BFinancialInformation financialInformation;
	private BInstallationData installationData;

}
