package com.bbva.ccol.merchantsmerchantsacquirementsacquirementscontractssendv0.facade.v0.dto;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;

import com.bbva.ccol.merchantsmerchantsacquirementsacquirementscontractssendv0.facade.v0.validations.INotificationRequiredInput;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Clase que representa la informacion de la oficina bancaria
 * @author carlos.toro
 */
@Getter
@Setter
@NoArgsConstructor
public class Branch implements Serializable {

	private static final long serialVersionUID = 1253855551325025981L;

	@NotBlank(groups = INotificationRequiredInput.class)
	private String id;
	
	private String name;

}
