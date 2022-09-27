package com.bbva.ccol.merchantsmerchantsacquirementsacquirementscontractssendv0.utils.commons.errors;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Errores usados por los servicios de este repositorio
 *
 * @author daniel.florez
 */
@AllArgsConstructor
public enum ErrorEnum {
    /**
     * Error de parametros invalidos
     */
    INVALID_PARAMETERS("invalidParameters"),
    /**
     * Error de parametros obligatorios faltantes
     */
    MANDATORY_PARAMETERS_MISSING("mandatoryParametersMissing"),
    /**
     * Validacion de incocredito retorna error
     */
    SEND_NOTIFICATION_FAILED("sendNotificationFailed"),
    /**
     * Obtencion del token genero error
     */
    GET_TOKEN_FAILED("getTokenFailed"),
    /**
     * Error tecnico interno
     */
    TECHNICAL_ERROR("technicalError");

    @Getter
    private final String alias;
}
