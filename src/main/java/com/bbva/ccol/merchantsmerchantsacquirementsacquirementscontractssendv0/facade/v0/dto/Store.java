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
 * Clase que representa la informacion del punto de venta del comercio vinculado
 * 
 * @author carlos.toro
 */
@Getter
@Setter
@NoArgsConstructor
public class Store implements Serializable {

	private static final long serialVersionUID = -3668056656287656572L;

	@Valid
	private Address address;

	private String state;

	private String daneCode;

	private String cityName;

	private String phoneNumber;
	
	@NotNull(groups = INotificationRequiredInput.class)	
	private String pointOfSaleId;

	@NotBlank(groups = INotificationRequiredInput.class)
	private String radicationNumberVisa;

	@NotBlank(groups = INotificationRequiredInput.class)
	private String radicationNumberMaster;

	@NotNull(groups = INotificationRequiredInput.class)
	private SaleTypeEnum saleType;
}
