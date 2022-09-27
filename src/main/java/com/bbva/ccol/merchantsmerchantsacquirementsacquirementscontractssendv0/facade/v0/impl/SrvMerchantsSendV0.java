package com.bbva.ccol.merchantsmerchantsacquirementsacquirementscontractssendv0.facade.v0.impl;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bbva.ccol.merchantsmerchantsacquirementsacquirementscontractssendv0.business.IBSrvMerchantsSendV0;
import com.bbva.ccol.merchantsmerchantsacquirementsacquirementscontractssendv0.business.dto.BSendRequest;
import com.bbva.ccol.merchantsmerchantsacquirementsacquirementscontractssendv0.facade.v0.ISrvMerchantsSendV0;
import com.bbva.ccol.merchantsmerchantsacquirementsacquirementscontractssendv0.facade.v0.dto.request.SendRequest;
import com.bbva.ccol.merchantsmerchantsacquirementsacquirementscontractssendv0.facade.v0.mapper.INotificationFacadeMapper;
import com.bbva.ccol.merchantsmerchantsacquirementsacquirementscontractssendv0.facade.v0.validations.INotificationRequiredInput;
import com.bbva.ccol.merchantsmerchantsacquirementsacquirementscontractssendv0.utils.commons.enums.CallSequenceMessageEnum;
import com.bbva.ccol.merchantsmerchantsacquirementsacquirementscontractssendv0.utils.commons.log.LogUtils;
import com.bbva.ccol.merchantsmerchantsacquirementsacquirementscontractssendv0.utils.commons.validators.DtoValidator;
import com.bbva.jee.arq.spring.core.catalog.gabi.ServiceResponseInterface;
import com.bbva.jee.arq.spring.core.catalog.gabi.ServiceResponseNoContent;
import com.bbva.jee.arq.spring.core.servicing.annotations.SMC;
import com.bbva.jee.arq.spring.core.servicing.annotations.SN;
import com.bbva.jee.arq.spring.core.servicing.annotations.VN;

import lombok.Setter;

/**
 * Recibe y consolida la informacion de la adquirencia para el envio de la
 * notificacion al usuario final
 * 
 * @author carlos.toro
 *
 */
@Setter
@Service(value = "SrvMerchantsSendV0")
@SN(registryID = "SNCO1810016", logicalID = "merchants")
@VN(vnn = "v0")
@Path("/v0")
@Produces({ MediaType.APPLICATION_JSON })
@Consumes({ MediaType.APPLICATION_JSON })
public class SrvMerchantsSendV0 implements ISrvMerchantsSendV0 {

	private static final Log LOG = LogFactory.getLog(SrvMerchantsSendV0.class);

	@Autowired
	private INotificationFacadeMapper requestMapper;

	@Autowired
	private IBSrvMerchantsSendV0 bSrvMerchantsSendV0;

	/**
	 * SMC para el envio de la notificacion de adquirencias una vez se hace la
	 * vinculacion
	 * 
	 * @param request
	 */
	@Override
	@POST
	@Path("/merchants/{merchant-id}/acquirements/acquirements-contracts/send")
	@SMC(registryID = "SMGG20210881", logicalID = "postSend")
	public ServiceResponseInterface merchantsSendNotification(SendRequest request) {
		LOG.info(LogUtils.buildLogMessage(CallSequenceMessageEnum.FACADE_REQUEST, request));
		DtoValidator.validate(request, INotificationRequiredInput.class);
		BSendRequest bSendRequest = requestMapper.sendRequestToBSendRequest(request);
		bSrvMerchantsSendV0.merchantsSendNotification(bSendRequest);
		LOG.info(CallSequenceMessageEnum.FACADE_RESPONSE);
		return ServiceResponseNoContent.ServiceResponseNoContentBuilder.build();
	}

}
