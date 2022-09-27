package com.bbva.ccol.merchantsmerchantsacquirementsacquirementscontractssendv0.business.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Clase que representa la informacion de la instalacion incluyendo que tipo de
 * datafono se utiliza y en que horario se hara la instalacion
 * @author carlos.toro
 */
@Getter
@Setter
@NoArgsConstructor
public class BInstallationData {

	private BDataphoneTypeEnum dataphoneType;
	
	private BScheduleEnum schedule;
	
}
