package com.bbva.ccol.merchantsmerchantsacquirementsacquirementscontractssendv0.utils.commons.log;

import static lombok.AccessLevel.PRIVATE;

import org.apache.commons.lang.StringUtils;

import com.bbva.ccol.merchantsmerchantsacquirementsacquirementscontractssendv0.utils.commons.enums.CallSequenceMessageEnum;

import lombok.NoArgsConstructor;

/**
 * Clase util para logs.
 * @author carlos.toro
 */
@NoArgsConstructor(access=PRIVATE)
public class LogUtils {

    /**
     * Metodo encargado de construir mensaje para logs.
     * @param messageEnum tipo de mensaje.
     * @param filter elemento a imprimir.
     * @return mensaje
     */
    public static String buildLogMessage(CallSequenceMessageEnum messageEnum, String filter) {
        return StringUtils.join(new Object[]{messageEnum.getMessage(), ", filter=", filter});
    }

    /**
     * Metodo encargado de construir mensaje para logs.
     * @param messageEnum tipo de mensaje.
     * @param object data a imprimir.
     * @return mensaje
     */
    public static String buildLogMessage(CallSequenceMessageEnum messageEnum, Object object) {
        return StringUtils.join(new Object[]{messageEnum.getMessage(), ", ", object != null ? object.toString() : object});
    }
    
}