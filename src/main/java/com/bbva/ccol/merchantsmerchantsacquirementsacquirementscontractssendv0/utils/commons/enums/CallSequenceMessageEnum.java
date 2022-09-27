package com.bbva.ccol.merchantsmerchantsacquirementsacquirementscontractssendv0.utils.commons.enums;

import static lombok.AccessLevel.PRIVATE;

import com.bbva.ccol.merchantsmerchantsacquirementsacquirementscontractssendv0.utils.commons.log.LogConstants;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Enum de los tipos de mensajes.
 * @author carlos.toro
 */
@AllArgsConstructor(access=PRIVATE)
@Getter
public enum CallSequenceMessageEnum {

	FACADE_STEP_REQUEST("1"),
    FACADE_STEP_RESPONSE("8"),
    BUSINESS_STEP_REQUEST("2"),
    BUSINESS_STEP_RESPONSE("7"),
    DAO_STEP_REQUEST("3"),
    DAO_STEP_RESPONSE("6"),
    SERVICE_STEP_REQUEST("4"),
    SERVICE_STEP_RESPONSE("5"),

    FACADE_REQUEST(FACADE_STEP_REQUEST.getMessage().concat(LogConstants.REQUEST)),
    FACADE_RESPONSE(FACADE_STEP_RESPONSE.getMessage().concat(LogConstants.RESPONSE)),
    BUSINESS_REQUEST(BUSINESS_STEP_REQUEST.getMessage().concat(LogConstants.REQUEST)),
    BUSINESS_RESPONSE(BUSINESS_STEP_RESPONSE.getMessage().concat(LogConstants.RESPONSE)),
    DAO_REQUEST(DAO_STEP_REQUEST.getMessage().concat(LogConstants.REQUEST)),
    DAO_RESPONSE(DAO_STEP_RESPONSE.getMessage().concat(LogConstants.RESPONSE)),
    SERVICE_REQUEST(DAO_STEP_REQUEST.getMessage().concat(LogConstants.REQUEST)),
    SERVICE_RESPONSE(DAO_STEP_RESPONSE.getMessage().concat(LogConstants.RESPONSE)),


    DAO_BEFORE_REQUEST(DAO_REQUEST.getMessage().concat("-before")),
    DAO_BEFORE_RESPONSE(DAO_RESPONSE.getMessage().concat("-before")),;

    private final String message;

}
