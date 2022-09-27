package com.bbva.ccol.merchantsmerchantsacquirementsacquirementscontractssendv0.business.service.mapper.impl;

import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.core.Response;

import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;

import com.bbva.ccol.merchantsmerchantsacquirementsacquirementscontractssendv0.business.dto.BItemizeFee;
import com.bbva.ccol.merchantsmerchantsacquirementsacquirementscontractssendv0.business.dto.BSendRequest;
import com.bbva.ccol.merchantsmerchantsacquirementsacquirementscontractssendv0.business.service.dto.EmailAmortization;
import com.bbva.ccol.merchantsmerchantsacquirementsacquirementscontractssendv0.business.service.dto.Variables;
import com.bbva.ccol.merchantsmerchantsacquirementsacquirementscontractssendv0.business.service.mapper.IMapperService;
import com.bbva.ccol.merchantsmerchantsacquirementsacquirementscontractssendv0.utils.FormatConstants;
import com.bbva.ccol.merchantsmerchantsacquirementsacquirementscontractssendv0.utils.commons.errors.ErrorEnum;
import com.bbva.jee.arq.spring.core.servicing.gce.BusinessServiceException;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Mapper para la transformacion de los objetos de negocio a los objetos de la
 * capa service
 * 
 * @author carlos.toro
 *
 */
@Service
public class MapperService implements IMapperService {

	private static final Log LOG = LogFactory.getLog(MapperService.class);

	private static final int NOMBRE_EMPRESA = 1;
	private static final int REFERENCIA = 2;
	private static final int FECHA_CONTRATACION = 3;
	private static final int HORA_CONTRATACION = 4;
	private static final int USUARIO = 5;
	private static final int VISA_CREDITO = 8;
	private static final int VISA_DEBITO = 9;
	private static final int VISA_ELECTRON = 11;
	private static final int MASTER_CREDITO = 12;
	private static final int MASTER_MAESTRO = 13;
	private static final int MASTER_DEBITO = 14;

	@Override
	public String bSendRequestToJson(BSendRequest bSendRequest, String codeTemplate) {
		String mapIn = "";
		ObjectMapper objectMapper = new ObjectMapper();
		List<String> lstTo = new ArrayList<>();
		lstTo.add(bSendRequest.getAcquirementInformation().getLegalRepresentative().getEmail());

		EmailAmortization emailAmortization = new EmailAmortization();
		emailAmortization.setTo(lstTo);
		emailAmortization.setCode(codeTemplate);

		List<Variables> lstVariables = new ArrayList<>();
		lstVariables.add(
				new Variables(NOMBRE_EMPRESA, bSendRequest.getAcquirementInformation().getBusiness().getLegalName()));
		lstVariables.add(new Variables(REFERENCIA, bSendRequest.getContractInformation().getReference()));
		DateFormat format = new SimpleDateFormat(FormatConstants.EMAIL_DATE_FORMAT);
		lstVariables.add(new Variables(FECHA_CONTRATACION,
				format.format(bSendRequest.getAcquirementInformation().getCompletionDate())));
		DateFormat timeFormat = new SimpleDateFormat(FormatConstants.EMAIL_TIME_FORMAT);
		lstVariables.add(new Variables(HORA_CONTRATACION,
				timeFormat.format(bSendRequest.getAcquirementInformation().getCompletionDate())));
		if (bSendRequest.getContractInformation().getBusinessAgent() != null) {
			lstVariables.add(new Variables(USUARIO, bSendRequest.getContractInformation().getBusinessAgent().getId()));
		}
		List<BItemizeFee> fees = bSendRequest.getConditions().getFees().getItemizeFees();
		NumberFormat formatter = new DecimalFormat("#0.00");
		for (BItemizeFee fee : fees) {
			switch (fee.getFeeType()) {
			case VISA_CREDIT:
				lstVariables.add(new Variables(VISA_CREDITO,
						formatter.format(fee.getItemizeFeeUnit().getAmount().doubleValue())));
				break;
			case VISA_DEBIT:
				lstVariables.add(new Variables(VISA_DEBITO,
						formatter.format(fee.getItemizeFeeUnit().getAmount().doubleValue())));
				break;
			case VISA_ELECTRON:
				lstVariables.add(new Variables(VISA_ELECTRON,
						formatter.format(fee.getItemizeFeeUnit().getAmount().doubleValue())));
				break;
			case MASTER_CREDIT:
				lstVariables.add(new Variables(MASTER_CREDITO,
						formatter.format(fee.getItemizeFeeUnit().getAmount().doubleValue())));
				break;
			case MASTER_DEBIT:
				lstVariables.add(new Variables(MASTER_DEBITO,
						formatter.format(fee.getItemizeFeeUnit().getAmount().doubleValue())));
				break;
			case MASTER_MAESTRO:
				lstVariables.add(new Variables(MASTER_MAESTRO,
						formatter.format(fee.getItemizeFeeUnit().getAmount().doubleValue())));
				break;
			}

		}

		emailAmortization.setLstVariablesTemplate(lstVariables);
		try {
			objectMapper.setSerializationInclusion(Include.NON_NULL);
			emailAmortization.setDataJson(objectMapper.writeValueAsString(bSendRequest));
			mapIn = objectMapper.writeValueAsString(emailAmortization);
		} catch (JsonProcessingException e) {
			LOG.error("Error al convertir el objeto request: " + e.getMessage(), e);
			throw new BusinessServiceException(ErrorEnum.SEND_NOTIFICATION_FAILED.getAlias(), e.getMessage(),
					Response.Status.fromStatusCode(HttpStatus.SC_BAD_REQUEST).name());
		}

		return mapIn;
	}
}
