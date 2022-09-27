package com.bbva.ccol.merchantsmerchantsacquirementsacquirementscontractssendv0.business.dto;

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
public class BStore {

	private BAddress address;
	private String state;
	private String daneCode;
	private String cityName;
	private String phoneNumber;
	private String pointOfSaleId;
	private String radicationNumberVisa;
	private String radicationNumberMaster;
	private BSaleTypeEnum saleType;
}
