package com.bbva.ccol.merchantsmerchantsacquirementsacquirementscontractssendv0.utils.commons.validators;

import java.io.File;
import java.io.IOException;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import com.bbva.ccol.merchantsmerchantsacquirementsacquirementscontractssendv0.facade.v0.dto.request.SendRequest;
import com.bbva.ccol.merchantsmerchantsacquirementsacquirementscontractssendv0.facade.v0.validations.INotificationRequiredInput;
import com.bbva.jee.arq.spring.core.servicing.gce.BusinessServiceException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(MockitoJUnitRunner.class)
public class DtoValidatorTest {

	private final static String NOTIFICATION_JSON_PATH = "src/test/resources/merchantsSendNotificationShouldReturnOkTest.json";

	private ObjectMapper mapper;

	@Before
	public void init() {
		mapper = new ObjectMapper();
	}

	@Test
	public void validateShouldReturnOkTest() throws Exception {
		SendRequest facadeRequest = (SendRequest) getObjectFromJSON(NOTIFICATION_JSON_PATH, SendRequest.class);
		try {
			DtoValidator.validate(facadeRequest, new Class[] { INotificationRequiredInput.class });
		} catch (Exception e) {
			Assert.fail("It should return OK");
		}
	}

	@Test(expected = BusinessServiceException.class)
	public void validateShouldThrowExceptionTest() throws Exception {
		SendRequest facadeRequest = (SendRequest) getObjectFromJSON(NOTIFICATION_JSON_PATH, SendRequest.class);
		facadeRequest.setAcquirementInformation(null);
		DtoValidator.validate(facadeRequest, new Class[] { INotificationRequiredInput.class });
	}

	@Test(expected = BusinessServiceException.class)
	public void validateShouldThrowException2Test() throws Exception {
		DtoValidator.validate(null, new Class[] { INotificationRequiredInput.class });
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