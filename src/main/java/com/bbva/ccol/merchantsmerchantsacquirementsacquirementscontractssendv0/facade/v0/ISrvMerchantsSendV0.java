package com.bbva.ccol.merchantsmerchantsacquirementsacquirementscontractssendv0.facade.v0;

import com.bbva.ccol.merchantsmerchantsacquirementsacquirementscontractssendv0.facade.v0.dto.request.SendRequest;
import com.bbva.jee.arq.spring.core.catalog.gabi.ServiceResponseInterface;

/**
 * Interfaz que define el contrato para el envio de la notificacion
 * @author carlos.toro
 */
public interface ISrvMerchantsSendV0 {
	/**
	 * Metodo que recibe la informacion de la adquirencia para consolidarla y enviar
	 * la notificacion al usuario final
	 * 
	 * @param request
	 * @return ServiceResponseInterface
	 */
	ServiceResponseInterface merchantsSendNotification(SendRequest request);
}
