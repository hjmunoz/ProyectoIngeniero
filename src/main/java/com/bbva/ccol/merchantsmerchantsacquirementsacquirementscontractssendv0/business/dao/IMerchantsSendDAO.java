package com.bbva.ccol.merchantsmerchantsacquirementsacquirementscontractssendv0.business.dao;

import com.bbva.ccol.merchantsmerchantsacquirementsacquirementscontractssendv0.business.dto.BSendRequest;

/**
 * Interfaz que permite el acceso a datos
 * @author carlos.toro
 */
public interface IMerchantsSendDAO {

	/**
	 * Metodo que realiza el llamado al servicio de Send Amortization en WAS9 para
	 * el envio de la notificacion
	 * 
	 * @param request
	 */
	void sendNotification(BSendRequest request);

}
