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
 * Clase que representa la informacion del representante legal del comercio
 * vinculado
 * @author carlos.toro
 */
@Getter
@Setter
@NoArgsConstructor
public class LegalRepresentative implements Serializable {

	private static final long serialVersionUID = 5510442724651816525L;

	@Valid
	@NotNull(groups = INotificationRequiredInput.class)
	private IdentityDocument identityDocument;
	
	@NotBlank(groups = INotificationRequiredInput.class)
	private String firstName;
	
	private String middleName;
	
	@NotBlank(groups = INotificationRequiredInput.class)
	private String firstLastName;
	
	private String secondLastName;
	
	private GenderEnum gender;
	
	private String phoneNumber;
	
	@NotBlank(groups = INotificationRequiredInput.class)
	private String mobileNumber;
	
	@NotBlank(groups = INotificationRequiredInput.class)
	private String city;
	
	@NotBlank(groups = INotificationRequiredInput.class)
	private String email;
	
	@NotBlank(groups = INotificationRequiredInput.class)
	private BigDecimal shareholdingPercentage;
	
	@Valid
	@NotNull(groups = INotificationRequiredInput.class)
	private Address address;
	
}
