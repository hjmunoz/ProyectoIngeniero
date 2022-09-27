package com.bbva.ccol.merchantsmerchantsacquirementsacquirementscontractssendv0.business.service.impl;

import java.util.HashMap;

import javax.annotation.Resource;
import javax.ws.rs.core.Response;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bbva.ccol.merchantsmerchantsacquirementsacquirementscontractssendv0.business.dto.BSendRequest;
import com.bbva.ccol.merchantsmerchantsacquirementsacquirementscontractssendv0.business.service.IMerchantsSendClient;
import com.bbva.ccol.merchantsmerchantsacquirementsacquirementscontractssendv0.business.service.mapper.IMapperService;
import com.bbva.ccol.merchantsmerchantsacquirementsacquirementscontractssendv0.utils.ConfigurationConstants;
import com.bbva.ccol.merchantsmerchantsacquirementsacquirementscontractssendv0.utils.ConfigurationProperties;
import com.bbva.ccol.merchantsmerchantsacquirementsacquirementscontractssendv0.utils.commons.enums.CallSequenceMessageEnum;
import com.bbva.ccol.merchantsmerchantsacquirementsacquirementscontractssendv0.utils.commons.errors.ErrorEnum;
import com.bbva.ccol.merchantsmerchantsacquirementsacquirementscontractssendv0.utils.commons.log.LogUtils;
import com.bbva.jee.arq.spring.core.rest.IRestConnector;
import com.bbva.jee.arq.spring.core.rest.RestConnectorFactory;
import com.bbva.jee.arq.spring.core.rest.RestConnectorResponse;
import com.bbva.jee.arq.spring.core.rest.RestConnectorType;
import com.bbva.jee.arq.spring.core.servicing.gce.BusinessServiceException;

import lombok.Setter;

/**
 * Clase que implementa IMerchantsSendClient
 * 
 * @author carlos.toro
 *
 */
@Setter
@Component
public class MerchantsSendClient implements IMerchantsSendClient {

	private static final Log LOG = LogFactory.getLog(MerchantsSendClient.class);

	@Resource(name = "configurationProperties")
	private ConfigurationProperties configurationProperties;

	@Autowired
	RestConnectorFactory restConnectorFactory;

	@Autowired
	IMapperService mapper;

	/**
	 * Metodo que implementa la logica para el llamado al servicio Send Amortization
	 * para el envio de la notificacion de alta de adquirencias
	 */
	@Override
	public void sendNotification(BSendRequest bSendRequest) {
		LOG.info(LogUtils.buildLogMessage(CallSequenceMessageEnum.SERVICE_STEP_REQUEST, bSendRequest));

		String sendAmortizationServiceUrl = configurationProperties
				.getProperty(ConfigurationConstants.SEND_AMORTIZATION_URL);
		String codeTemplate = bSendRequest.getCodeTemplate() != null ? bSendRequest.getCodeTemplate() : configurationProperties.getProperty(ConfigurationConstants.CODE_TEMPLATE); 
		LOG.debug(LogUtils.buildLogMessage(CallSequenceMessageEnum.SERVICE_REQUEST,
				String.format("#Propiedad URL -> %s", sendAmortizationServiceUrl)));
		LOG.debug(LogUtils.buildLogMessage(CallSequenceMessageEnum.SERVICE_REQUEST,
				String.format("#Propiedad CODE_TEMPLATE -> %s", codeTemplate)));

		IRestConnector iRestConnector = restConnectorFactory.getRestConnector(RestConnectorType.BASIC);
		RestConnectorResponse response;
		try {
			String sendNotificationPayload = mapper.bSendRequestToJson(bSendRequest, codeTemplate);
			LOG.info(LogUtils.buildLogMessage(CallSequenceMessageEnum.SERVICE_STEP_REQUEST, sendNotificationPayload));

			response = iRestConnector.doPost(sendAmortizationServiceUrl, null, headers(), sendNotificationPayload);
			LOG.info("RESPUESTA SERVICIO: " + response.getResponseBody());
		} catch (Exception e) {
			throw new BusinessServiceException(ErrorEnum.TECHNICAL_ERROR.getAlias(), e.getCause(), e.getMessage());
		}
		if (response.getStatusCode() != Response.Status.OK.getStatusCode()) {
			LOG.error("Error al enviar el email Amortization : " + response.getStatusCode());
			throw new BusinessServiceException(ErrorEnum.TECHNICAL_ERROR.getAlias(),
					Response.Status.fromStatusCode(response.getStatusCode()).name(),
					String.valueOf(response.getStatusCode()), response.getResponseBody());
		}
	}

	/**
	 * Metodo para definir los headers en el llamado del servicio
	 * 
	 * @return Lista de headers para incluir en la peticion
	 */
	private HashMap<String, String> headers() {
		HashMap<String, String> optionalHeaders = new HashMap<>();
		optionalHeaders.put("Content-Type", "application/json");
		return optionalHeaders;
	}

}
