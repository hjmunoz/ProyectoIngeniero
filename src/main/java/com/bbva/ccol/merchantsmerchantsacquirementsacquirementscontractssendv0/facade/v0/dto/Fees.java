package com.bbva.ccol.merchantsmerchantsacquirementsacquirementscontractssendv0.facade.v0.dto;

import java.io.Serializable;
import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;

import com.bbva.ccol.merchantsmerchantsacquirementsacquirementscontractssendv0.facade.v0.validations.INotificationRequiredInput;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Clase que identifica la lista de las comisiones pactadas en el proceso de
 * vinculacion
 * @author carlos.toro
 */
@Getter
@Setter
@NoArgsConstructor
public class Fees implements Serializable {

	private static final long serialVersionUID = 840049675752731746L;

	@Valid
	@NotEmpty(groups = INotificationRequiredInput.class)
	private List<ItemizeFee> itemizeFees;

}
