package com.bbva.ccol.merchantsmerchantsacquirementsacquirementscontractssendv0.facade.v0.impl;

import java.io.File;
import java.io.IOException;

import org.apache.commons.httpclient.HttpStatus;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mapstruct.factory.Mappers;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpMethod;

import com.bbva.ccol.merchantsmerchantsacquirementsacquirementscontractssendv0.business.dao.impl.MerchantsSendDAO;
import com.bbva.ccol.merchantsmerchantsacquirementsacquirementscontractssendv0.business.dto.BSendRequest;
import com.bbva.ccol.merchantsmerchantsacquirementsacquirementscontractssendv0.business.impl.BSrvMerchantsSendV0;
import com.bbva.ccol.merchantsmerchantsacquirementsacquirementscontractssendv0.business.service.impl.MerchantsSendClient;
import com.bbva.ccol.merchantsmerchantsacquirementsacquirementscontractssendv0.facade.v0.dto.request.SendRequest;
import com.bbva.ccol.merchantsmerchantsacquirementsacquirementscontractssendv0.facade.v0.mapper.INotificationFacadeMapper;
import com.bbva.ccol.merchantsmerchantsacquirementsacquirementscontractssendv0.utils.commons.errors.ErrorEnum;
import com.bbva.jee.arq.spring.core.catalog.gabi.ServiceResponseInterface;
import com.bbva.jee.arq.spring.core.servicing.gce.BusinessServiceException;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(MockitoJUnitRunner.class)
public class SrvMerchantsSendV0Test {

	private final static String NOTIFICATION_JSON_PATH = "src/test/resources/merchantsSendNotificationShouldReturnOkTest.json";

	private final static String NOTIFICATION_REQUIRED_ONLY_JSON_PATH = "src/test/resources/merchantsSendNotificationRequiredOnlyShouldReturnOkTest.json";

	@Mock
	private MerchantsSendClient service;

	@InjectMocks
	private MerchantsSendDAO dao = new MerchantsSendDAO();

	private SrvMerchantsSendV0 facade;

	private ObjectMapper mapper;

	private INotificationFacadeMapper facadeMapper = Mappers.getMapper(INotificationFacadeMapper.class);

	@Before
	public void init() {
		facade = new SrvMerchantsSendV0();
		BSrvMerchantsSendV0 business = new BSrvMerchantsSendV0();
		facade.setBSrvMerchantsSendV0(business);
		facade.setRequestMapper(facadeMapper);
		business.setMerchantsSendDAO(dao);
		mapper = new ObjectMapper();
		mapper.setSerializationInclusion(Include.NON_NULL);
	}

	@Test
	public void merchantsSendNotificationShouldReturnOkTest() throws Exception {
		SendRequest facadeRequest = (SendRequest) getObjectFromJSON(NOTIFICATION_JSON_PATH, SendRequest.class);

		ServiceResponseInterface serviceResponse = facade.merchantsSendNotification(facadeRequest);
		int status = serviceResponse.getHttpStatus(HttpMethod.POST);

		ArgumentCaptor<BSendRequest> argument = ArgumentCaptor.forClass(BSendRequest.class);
		Mockito.verify(service, Mockito.times(1)).sendNotification(argument.capture());
		BSendRequest bRequest = argument.getValue();
		Assert.assertEquals(facadeRequest.getAcquirementInformation().getLegalRepresentative().getEmail(),
				bRequest.getAcquirementInformation().getLegalRepresentative().getEmail());
		Assert.assertEquals(facadeRequest.getAcquirementInformation().getLegalRepresentative().getMobileNumber(),
				bRequest.getAcquirementInformation().getLegalRepresentative().getMobileNumber());
		Assert.assertEquals(facadeRequest.getAcquirementInformation().getLegalRepresentative().getFirstName(),
				bRequest.getAcquirementInformation().getLegalRepresentative().getFirstName());
		Assert.assertEquals(facadeRequest.getConditions().getFees().getItemizeFees().size(),
				bRequest.getConditions().getFees().getItemizeFees().size());
		Assert.assertEquals(HttpStatus.SC_NO_CONTENT, status);

	}

	@Test
	public void merchantsSendNotificationSoloRequeridosShouldReturnOkTest() throws Exception {
		SendRequest facadeRequest = (SendRequest) getObjectFromJSON(NOTIFICATION_REQUIRED_ONLY_JSON_PATH,
				SendRequest.class);

		ServiceResponseInterface serviceResponse = facade.merchantsSendNotification(facadeRequest);
		int status = serviceResponse.getHttpStatus(HttpMethod.POST);

		ArgumentCaptor<BSendRequest> argument = ArgumentCaptor.forClass(BSendRequest.class);
		Mockito.verify(service, Mockito.times(1)).sendNotification(argument.capture());
		BSendRequest bRequest = argument.getValue();
		Assert.assertEquals(facadeRequest.getAcquirementInformation().getLegalRepresentative().getEmail(),
				bRequest.getAcquirementInformation().getLegalRepresentative().getEmail());
		Assert.assertEquals(facadeRequest.getAcquirementInformation().getLegalRepresentative().getMobileNumber(),
				bRequest.getAcquirementInformation().getLegalRepresentative().getMobileNumber());
		Assert.assertEquals(facadeRequest.getAcquirementInformation().getLegalRepresentative().getFirstName(),
				bRequest.getAcquirementInformation().getLegalRepresentative().getFirstName());
		Assert.assertEquals(facadeRequest.getConditions().getFees().getItemizeFees().size(),
				bRequest.getConditions().getFees().getItemizeFees().size());
		Assert.assertEquals(HttpStatus.SC_NO_CONTENT, status);

	}

	@Test(expected = BusinessServiceException.class)
	public void merchantsSendNotificationShouldReturnErrorTest() throws Exception {
		SendRequest facadeRequest = (SendRequest) getObjectFromJSON(NOTIFICATION_REQUIRED_ONLY_JSON_PATH,
				SendRequest.class);
		Mockito.doThrow(
				new BusinessServiceException(ErrorEnum.TECHNICAL_ERROR.getAlias(), "Error simulado", "Error simulado"))
				.when(service).sendNotification(Mockito.any());
		facade.merchantsSendNotification(facadeRequest);

		Assert.fail("It should return BusinessServiceException");

	}

	private <T> T getObjectFromJSON(String jsonPath, Class<T> clazz) {
		try {
			return (T) mapper.readValue(new File(jsonPath), clazz);
		} catch (IOException e) {
			Assert.fail("Error al leer el json: " + jsonPath);
			return null;
		}
	}

}