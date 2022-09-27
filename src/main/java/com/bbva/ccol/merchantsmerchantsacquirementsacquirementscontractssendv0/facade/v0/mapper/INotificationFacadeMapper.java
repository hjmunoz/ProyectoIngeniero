package com.bbva.ccol.merchantsmerchantsacquirementsacquirementscontractssendv0.facade.v0.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.bbva.ccol.merchantsmerchantsacquirementsacquirementscontractssendv0.business.dto.BAcquirementInformation;
import com.bbva.ccol.merchantsmerchantsacquirementsacquirementscontractssendv0.business.dto.BIdentityDocument;
import com.bbva.ccol.merchantsmerchantsacquirementsacquirementscontractssendv0.business.dto.BSendRequest;
import com.bbva.ccol.merchantsmerchantsacquirementsacquirementscontractssendv0.business.dto.BUnit;
import com.bbva.ccol.merchantsmerchantsacquirementsacquirementscontractssendv0.facade.v0.dto.AcquirementInformation;
import com.bbva.ccol.merchantsmerchantsacquirementsacquirementscontractssendv0.facade.v0.dto.IdentityDocument;
import com.bbva.ccol.merchantsmerchantsacquirementsacquirementscontractssendv0.facade.v0.dto.Unit;
import com.bbva.ccol.merchantsmerchantsacquirementsacquirementscontractssendv0.facade.v0.dto.request.SendRequest;
import com.bbva.ccol.merchantsmerchantsacquirementsacquirementscontractssendv0.utils.FormatConstants;

/**
 * Mapper de SendRequest a BSendRequest
 * @author carlos.toro
 */
@Mapper(componentModel = "spring")
public interface INotificationFacadeMapper {

	BSendRequest sendRequestToBSendRequest(SendRequest request);


	
}
	