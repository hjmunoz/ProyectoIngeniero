package com.bbva.ccol.merchantsmerchantsacquirementsacquirementscontractssendv0.business.service;

import com.bbva.ccol.merchantsmerchantsacquirementsacquirementscontractssendv0.business.dto.BSendRequest;

/**
 * Interface que declara los metodos para el consumo del servicio Send
 * Amortization desplegado en WAS9
 * 
 * @author carlos.toro
 *
 */
public interface IMerchantsSendClient {

	/**
	 * Metodo que realiza el llamado al servicio de Send Amortization en WAS9 para
	 * el envio de la notificacion
	 * 
	 * @param request
	 */
	void sendNotification(BSendRequest request);

}
