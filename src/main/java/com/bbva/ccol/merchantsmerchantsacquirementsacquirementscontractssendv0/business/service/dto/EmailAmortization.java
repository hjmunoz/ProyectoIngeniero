package com.bbva.ccol.merchantsmerchantsacquirementsacquirementscontractssendv0.business.service.dto;

import java.util.List;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Clase que representa la informacion para la notificacion
 * 
 * @author carlos.toro
 *
 */
@Setter
@Getter
@NoArgsConstructor
public class EmailAmortization {

	private String code;

	private List<String> to;

	private List<Variables> lstVariablesTemplate;

	private String dataJson;

}
