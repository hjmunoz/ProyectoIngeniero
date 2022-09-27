package com.bbva.ccol.merchantsmerchantsacquirementsacquirementscontractssendv0.business.dto;

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
public class BMailingAddress {

	private BAddress address;
	private String state;
	private String daneCode;
	private String cityName;
	private String phoneNumber;
	private String mobileNumber;
	private String postalCode;
	private String email;

}
