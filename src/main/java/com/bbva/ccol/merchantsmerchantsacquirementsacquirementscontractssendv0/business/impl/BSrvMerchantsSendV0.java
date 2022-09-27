package com.bbva.ccol.merchantsmerchantsacquirementsacquirementscontractssendv0.business.impl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bbva.ccol.merchantsmerchantsacquirementsacquirementscontractssendv0.business.IBSrvMerchantsSendV0;
import com.bbva.ccol.merchantsmerchantsacquirementsacquirementscontractssendv0.business.dao.IMerchantsSendDAO;
import com.bbva.ccol.merchantsmerchantsacquirementsacquirementscontractssendv0.business.dto.BSendRequest;
import com.bbva.ccol.merchantsmerchantsacquirementsacquirementscontractssendv0.utils.commons.enums.CallSequenceMessageEnum;
import com.bbva.ccol.merchantsmerchantsacquirementsacquirementscontractssendv0.utils.commons.log.LogUtils;

import lombok.Setter;

/**
 * Clase que implementa la logica para el envio de la notificacion de
 * adquirencia
 * @author carlos.toro
 */
@Setter
@Component
public class BSrvMerchantsSendV0 implements IBSrvMerchantsSendV0 {

	private static final Log LOG = LogFactory.getLog(BSrvMerchantsSendV0.class);

	@Autowired
	private IMerchantsSendDAO merchantsSendDAO;

	@Override
	public void merchantsSendNotification(BSendRequest bRequest) {
		LOG.info(LogUtils.buildLogMessage(CallSequenceMessageEnum.BUSINESS_REQUEST,
				"#Llamada Business requestAcquisition"));
		merchantsSendDAO.sendNotification(bRequest);
		LOG.info(LogUtils.buildLogMessage(CallSequenceMessageEnum.BUSINESS_RESPONSE,
				"#Respuesta Business requestAcquisition"));
	}

}
