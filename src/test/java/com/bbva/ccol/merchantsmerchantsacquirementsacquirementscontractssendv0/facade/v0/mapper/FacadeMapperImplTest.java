package com.bbva.ccol.merchantsmerchantsacquirementsacquirementscontractssendv0.facade.v0.mapper;

import java.io.File;
import java.io.IOException;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mapstruct.factory.Mappers;
import org.mockito.junit.MockitoJUnitRunner;

import com.bbva.ccol.merchantsmerchantsacquirementsacquirementscontractssendv0.business.dto.BSendRequest;
import com.bbva.ccol.merchantsmerchantsacquirementsacquirementscontractssendv0.facade.v0.dto.DataphoneTypeEnum;
import com.bbva.ccol.merchantsmerchantsacquirementsacquirementscontractssendv0.facade.v0.dto.DocumentTypeEnum;
import com.bbva.ccol.merchantsmerchantsacquirementsacquirementscontractssendv0.facade.v0.dto.GenderEnum;
import com.bbva.ccol.merchantsmerchantsacquirementsacquirementscontractssendv0.facade.v0.dto.ScheduleEnum;
import com.bbva.ccol.merchantsmerchantsacquirementsacquirementscontractssendv0.facade.v0.dto.request.SendRequest;
import com.bbva.ccol.merchantsmerchantsacquirementsacquirementscontractssendv0.facade.v0.mapper.INotificationFacadeMapper;
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(MockitoJUnitRunner.class)
public class FacadeMapperImplTest {

	INotificationFacadeMapper facadeMapper = Mappers.getMapper(INotificationFacadeMapper.class);

	private final static String NOTIFICATION_JSON_PATH = "src/test/resources/merchantsSendNotificationShouldReturnOkTest.json";

	ObjectMapper mapper = new ObjectMapper();;

	@Test
	public void facadeMapperTest() throws Exception {
		BSendRequest bRequest = facadeMapper.sendRequestToBSendRequest(null);
		Assert.assertNull(bRequest);

		SendRequest facadeRequest = (SendRequest) getObjectFromJSON(NOTIFICATION_JSON_PATH, SendRequest.class);
		for (DocumentTypeEnum documentTypeEnum : DocumentTypeEnum.values()) {
			testDocumentTypeEnum(documentTypeEnum, facadeRequest);
		}

		for (ScheduleEnum scheduleEnum : ScheduleEnum.values()) {
			testScheduleEnum(scheduleEnum, facadeRequest);
		}

		for (DataphoneTypeEnum dataphoneType : DataphoneTypeEnum.values()) {
			testDataphoneTypeEnum(dataphoneType, facadeRequest);
		}

		for (GenderEnum gender : GenderEnum.values()) {
			testGenderEnum(gender, facadeRequest);
		}

	}

	private void testGenderEnum(GenderEnum gender, SendRequest request) {
		request.getAcquirementInformation().getLegalRepresentative().setGender(gender);
		BSendRequest bRequest = facadeMapper.sendRequestToBSendRequest(request);
		Assert.assertEquals(gender.name(),
				bRequest.getAcquirementInformation().getLegalRepresentative().getGender().name());
	}

	private void testDataphoneTypeEnum(DataphoneTypeEnum dataphoneType, SendRequest request) {
		request.getAcquirementInformation().getInstallationData().setDataphoneType(dataphoneType);
		BSendRequest bRequest = facadeMapper.sendRequestToBSendRequest(request);
		Assert.assertEquals(dataphoneType.name(),
				bRequest.getAcquirementInformation().getInstallationData().getDataphoneType().name());
	}

	private void testScheduleEnum(ScheduleEnum scheduleEnum, SendRequest request) {
		request.getAcquirementInformation().getInstallationData().setSchedule(scheduleEnum);
		BSendRequest bRequest = facadeMapper.sendRequestToBSendRequest(request);
		Assert.assertEquals(scheduleEnum.name(),
				bRequest.getAcquirementInformation().getInstallationData().getSchedule().name());
	}

	private void testDocumentTypeEnum(DocumentTypeEnum documentType, SendRequest request) {
		request.getAcquirementInformation().getLegalRepresentative().getIdentityDocument().getDocumentType()
				.setId(documentType);
		BSendRequest bRequest = facadeMapper.sendRequestToBSendRequest(request);
		Assert.assertEquals(documentType.name(), bRequest.getAcquirementInformation().getLegalRepresentative()
				.getIdentityDocument().getDocumentType().getId().name());
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