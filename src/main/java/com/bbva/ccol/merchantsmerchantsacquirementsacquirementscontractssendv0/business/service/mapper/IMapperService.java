package com.bbva.ccol.merchantsmerchantsacquirementsacquirementscontractssendv0.business.service.mapper;

import com.bbva.ccol.merchantsmerchantsacquirementsacquirementscontractssendv0.business.dto.BSendRequest;

/**
 * Interface que declara los metodos para la transformacion del objeto de la
 * capa business al objeto de la capa service
 * 
 * @author carlos.toro
 *
 */
public interface IMapperService {

	public String bSendRequestToJson(BSendRequest bSendRequest, String codeTemplate);

}
