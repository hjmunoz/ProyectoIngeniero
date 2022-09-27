package com.bbva.ccol.merchantsmerchantsacquirementsacquirementscontractssendv0.business;

import com.bbva.ccol.merchantsmerchantsacquirementsacquirementscontractssendv0.business.dto.BSendRequest;

/**
 * Interfaz que define el contrato para el consumo de servicios de WAS9 para la
 * notificacion
 * @author carlos.toro
 */
public interface IBSrvMerchantsSendV0 {

	/**
	 * Metodo para consumir los servicios para el envio de la notificacion de
	 * adquirencias
	 * 
	 * @param request
	 */
	void merchantsSendNotification(BSendRequest request);

}
