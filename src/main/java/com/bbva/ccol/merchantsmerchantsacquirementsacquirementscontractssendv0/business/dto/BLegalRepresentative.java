package com.bbva.ccol.merchantsmerchantsacquirementsacquirementscontractssendv0.business.dto;

import java.math.BigDecimal;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Clase que representa la informacion del representante legal del comercio
 * vinculado
 * @author carlos.toro
 */
@Getter
@Setter
@NoArgsConstructor
public class BLegalRepresentative {

	private BIdentityDocument identityDocument;
	private String firstName;
	private String middleName;
	private String firstLastName;
	private String secondLastName;
	private BGenderEnum gender;
	private String phoneNumber;
	private String mobileNumber;
	private String city;
	private String email;
	private BigDecimal shareholdingPercentage;
	private BAddress address;

}
