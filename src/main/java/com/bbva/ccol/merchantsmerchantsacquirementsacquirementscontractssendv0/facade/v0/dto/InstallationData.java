package com.bbva.ccol.merchantsmerchantsacquirementsacquirementscontractssendv0.facade.v0.dto;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

import com.bbva.ccol.merchantsmerchantsacquirementsacquirementscontractssendv0.facade.v0.validations.INotificationRequiredInput;

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
public class InstallationData implements Serializable {

	private static final long serialVersionUID = 4637050391888800613L;

	@NotNull(groups = INotificationRequiredInput.class)
	private DataphoneTypeEnum dataphoneType;
	
	@NotNull(groups = INotificationRequiredInput.class)
	private ScheduleEnum schedule;
	
}
