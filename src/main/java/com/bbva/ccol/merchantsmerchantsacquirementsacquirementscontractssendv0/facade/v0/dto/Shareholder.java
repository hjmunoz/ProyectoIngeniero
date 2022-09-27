package com.bbva.ccol.merchantsmerchantsacquirementsacquirementscontractssendv0.facade.v0.dto;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.bbva.ccol.merchantsmerchantsacquirementsacquirementscontractssendv0.facade.v0.validations.INotificationRequiredInput;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Clase que representa la informacion de los participantes en la sociedad
 * incluyendo el porcentaje de participacion
 * @author carlos.toro
 */
@Getter
@Setter
@NoArgsConstructor
public class Shareholder implements Serializable {

	private static final long serialVersionUID = -5550884258821407856L;

	@NotBlank(groups = INotificationRequiredInput.class)
	private String fullName;

	@Valid
	@NotNull(groups = INotificationRequiredInput.class)
	private IdentityDocument identityDocument;

	@Valid
	@NotNull(groups = INotificationRequiredInput.class)
	private BigDecimal shareholdingPercentage;

}
