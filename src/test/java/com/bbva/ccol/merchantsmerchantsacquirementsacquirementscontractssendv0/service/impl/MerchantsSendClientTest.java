package com.bbva.ccol.merchantsmerchantsacquirementsacquirementscontractssendv0.service.impl;

import static org.mockito.Mockito.when;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

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

import com.bbva.ccol.merchantsmerchantsacquirementsacquirementscontractssendv0.business.dto.BSendRequest;
import com.bbva.ccol.merchantsmerchantsacquirementsacquirementscontractssendv0.business.service.impl.MerchantsSendClient;
import com.bbva.ccol.merchantsmerchantsacquirementsacquirementscontractssendv0.business.service.mapper.impl.MapperService;
import com.bbva.ccol.merchantsmerchantsacquirementsacquirementscontractssendv0.facade.v0.dto.request.SendRequest;
import com.bbva.ccol.merchantsmerchantsacquirementsacquirementscontractssendv0.facade.v0.mapper.INotificationFacadeMapper;
import com.bbva.ccol.merchantsmerchantsacquirementsacquirementscontractssendv0.utils.ConfigurationConstants;
import com.bbva.ccol.merchantsmerchantsacquirementsacquirementscontractssendv0.utils.ConfigurationProperties;
import com.bbva.jee.arq.spring.core.rest.IRestConnector;
import com.bbva.jee.arq.spring.core.rest.RestConnectorFactory;
import com.bbva.jee.arq.spring.core.rest.RestConnectorResponse;
import com.bbva.jee.arq.spring.core.rest.RestConnectorType;
import com.bbva.jee.arq.spring.core.servicing.configuration.ConfigurationManager;
import com.bbva.jee.arq.spring.core.servicing.gce.BusinessServiceException;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(MockitoJUnitRunner.class)
public class MerchantsSendClientTest {

	private final static String REQUEST_WAS9_JSON_PATH = "src/test/resources/merchantsSendNotificationWAS9Request.json";

	private final static String NOTIFICATION_JSON_PATH = "src/test/resources/merchantsSendNotificationShouldReturnOkTest.json";

	@Mock
	private ConfigurationManager configurationManager;

	@InjectMocks
	private ConfigurationProperties configurationProperties;

	@Mock
	private RestConnectorFactory restConnectorFactory;

	@Mock
	IRestConnector iRestConnector;

	@InjectMocks
	private MerchantsSendClient service = new MerchantsSendClient();

	private INotificationFacadeMapper facadeMapper = Mappers.getMapper(INotificationFacadeMapper.class);

	private ObjectMapper mapper;

	@Before
	public void init() {
		mapper = new ObjectMapper();
		mapper.setSerializationInclusion(Include.NON_NULL);
		service.setMapper(new MapperService());
		service.setConfigurationProperties(configurationProperties);
		when(configurationManager.getProperty(ConfigurationConstants.SEND_AMORTIZATION_URL))
				.thenReturn("https://bbvaaliadosde.co.igrupobbva:9444/amortization_send/v0/send/");
		when(restConnectorFactory.getRestConnector(RestConnectorType.BASIC)).thenReturn(iRestConnector);
	}

	@Test
	public void sendNotificationShouldReturnOkTest() throws Exception {
		RestConnectorResponse response = new RestConnectorResponse();
		response.setStatusCode(HttpStatus.SC_OK);
		response.setResponseBody(
				"Mensaje Email con codigo : 000004 enviado correctamente al email: juan.saldarriaga@exodus.com.co.");
		when(iRestConnector.doPost(Mockito.eq("https://bbvaaliadosde.co.igrupobbva:9444/amortization_send/v0/send/"),
				Mockito.any(), Mockito.any(), Mockito.any())).thenReturn(response);

		SendRequest facadeRequest = (SendRequest) getObjectFromJSON(NOTIFICATION_JSON_PATH, SendRequest.class);
		BSendRequest bRequest = facadeMapper.sendRequestToBSendRequest(facadeRequest);

		service.sendNotification(bRequest);
		ArgumentCaptor<String> argument = ArgumentCaptor.forClass(String.class);
		Mockito.verify(iRestConnector, Mockito.times(1)).doPost(Mockito.anyString(), Mockito.any(), Mockito.any(),
				argument.capture());

		String was9Request = new String(Files.readAllBytes(Paths.get(REQUEST_WAS9_JSON_PATH)),
				StandardCharsets.UTF_8.name());
		//Assert.assertEquals(was9Request, argument.getValue());
	}

	@Test(expected = BusinessServiceException.class)
	public void sendNotificationShouldReturnErrorTest() throws Exception {
		RestConnectorResponse response = new RestConnectorResponse();
		response.setStatusCode(HttpStatus.SC_BAD_REQUEST);
		response.setResponseBody("Error enviando el mensaje");
		when(iRestConnector.doPost(Mockito.eq("https://bbvaaliadosde.co.igrupobbva:9444/amortization_send/v0/send/"),
				Mockito.any(), Mockito.any(), Mockito.any())).thenReturn(response);

		SendRequest facadeRequest = (SendRequest) getObjectFromJSON(NOTIFICATION_JSON_PATH, SendRequest.class);
		BSendRequest bRequest = facadeMapper.sendRequestToBSendRequest(facadeRequest);
		service.sendNotification(bRequest);

		Assert.fail("It should throw BusinessServiceException");

	}

	@Test(expected = BusinessServiceException.class)
	public void sendNotificationShouldThrowExceptionTest() throws Exception {
		when(iRestConnector.doPost(Mockito.eq("https://bbvaaliadosde.co.igrupobbva:9444/amortization_send/v0/send/"),
				Mockito.any(), Mockito.any(), Mockito.any())).thenThrow(new NullPointerException("nulo"));

		SendRequest facadeRequest = (SendRequest) getObjectFromJSON(NOTIFICATION_JSON_PATH, SendRequest.class);
		BSendRequest bRequest = facadeMapper.sendRequestToBSendRequest(facadeRequest);

		service.sendNotification(bRequest);
		Assert.fail("It should throw exception");

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