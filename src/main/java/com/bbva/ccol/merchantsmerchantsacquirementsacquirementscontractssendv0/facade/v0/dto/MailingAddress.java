package com.bbva.ccol.merchantsmerchantsacquirementsacquirementscontractssendv0.facade.v0.dto;

import java.io.Serializable;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.bbva.ccol.merchantsmerchantsacquirementsacquirementscontractssendv0.facade.v0.validations.INotificationRequiredInput;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Clase que representa la informacion de la direccion y localizador para el
 * envio de mensajeria y correspondencia
 * @author carlos.toro
 */
@Getter
@Setter
@NoArgsConstructor
public class MailingAddress implements Serializable {

	private static final long serialVersionUID = 9088720311939079851L;
	
	@Valid
	@NotNull(groups = INotificationRequiredInput.class)
	private Address address;
	
	private String state;
	
	private String daneCode;
	
	private String cityName;
	
	private String phoneNumber;
	
	private String mobileNumber;
	
	private String postalCode;
	
	@NotBlank(groups = INotificationRequiredInput.class)
	private String email;

}
