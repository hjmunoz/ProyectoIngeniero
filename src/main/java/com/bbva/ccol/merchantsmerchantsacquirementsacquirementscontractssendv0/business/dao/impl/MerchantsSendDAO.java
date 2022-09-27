package com.bbva.ccol.merchantsmerchantsacquirementsacquirementscontractssendv0.business.dao.impl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bbva.ccol.merchantsmerchantsacquirementsacquirementscontractssendv0.business.dao.IMerchantsSendDAO;
import com.bbva.ccol.merchantsmerchantsacquirementsacquirementscontractssendv0.business.dto.BSendRequest;
import com.bbva.ccol.merchantsmerchantsacquirementsacquirementscontractssendv0.business.service.IMerchantsSendClient;
import com.bbva.ccol.merchantsmerchantsacquirementsacquirementscontractssendv0.utils.commons.enums.CallSequenceMessageEnum;
import com.bbva.ccol.merchantsmerchantsacquirementsacquirementscontractssendv0.utils.commons.log.LogUtils;

import lombok.Setter;

/**
 * Clase DAO que implementa IMerchantsSendDAO
 * 
 * @author carlos.toro
 *
 */
@Setter
@Component
public class MerchantsSendDAO implements IMerchantsSendDAO {

	private static final Log LOG = LogFactory.getLog(MerchantsSendDAO.class);

	@Autowired
	private IMerchantsSendClient merchantsClient;

	/**
	 * Metodo encargado de hacer el llamado al cliente rest que consume el servicio
	 * de Send Amortization en WAS9
	 * 
	 * @param request
	 */
	@Override
	public void sendNotification(BSendRequest request) {
		LOG.info(LogUtils.buildLogMessage(CallSequenceMessageEnum.DAO_REQUEST, "#Llamada REST sendNotification"));
		merchantsClient.sendNotification(request);
		LOG.info(LogUtils.buildLogMessage(CallSequenceMessageEnum.DAO_RESPONSE, "#Respuesta REST sendNotification"));
	}

}
