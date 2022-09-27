package com.bbva.ccol.merchantsmerchantsacquirementsacquirementscontractssendv0.utils.commons.validators;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.bbva.ccol.merchantsmerchantsacquirementsacquirementscontractssendv0.utils.commons.annotations.Optional;
import com.bbva.ccol.merchantsmerchantsacquirementsacquirementscontractssendv0.utils.commons.errors.ErrorEnum;
import com.bbva.ccol.merchantsmerchantsacquirementsacquirementscontractssendv0.utils.commons.interfaces.IDTOInOptionalAttributes;
import com.bbva.ccol.merchantsmerchantsacquirementsacquirementscontractssendv0.utils.commons.interfaces.IDTOOutOptionalAttributes;
import com.bbva.jee.arq.spring.core.servicing.gce.BusinessServiceException;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

/**
 * Validador de propiedades con javax.<br/>
 * Hace uso de {@link BusinessServiceException} para informar de los errores
 * @author carlos.toro
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class DtoValidator {
    private static final Log log = LogFactory.getLog(DtoValidator.class);
    private static final String NOT_NULL = "constraints.NotNull";
    private static final String NOT_EMPTY = "constraints.NotEmpty";
    private static final String NOT_BLANK = "constraints.NotBlanl";

    /**
     * Valida un dto
     * @param dto el dto a validar
     * @param groups los grupos a validar
     * @param <T> el tipo del dto
     */
    public static <T> void validate(T dto, Class<?>... groups) {
        if (dto == null) {
            throw new BusinessServiceException(ErrorEnum.MANDATORY_PARAMETERS_MISSING.getAlias());
        } else {
            Set<ConstraintViolation<T>> violationsSet = Validation.buildDefaultValidatorFactory().getValidator().validate(dto, groups);
            if (hasViolations(violationsSet)) {
                List<String> attributes = validateOptionalParameters(dto);

                for (ConstraintViolation<T> tConstraintViolation : violationsSet) {
                    String propertyViolated = tConstraintViolation.getPropertyPath().toString();
                    String message = propertyViolated + " " + tConstraintViolation.getMessage();
                    log.error(message);
                    if (!isOptional(propertyViolated, attributes)) {
                        throwBusinessException(tConstraintViolation, message);
                    }
                }
            }

        }
    }

    private static boolean isOptional(String propertyViolated, List<String> attributes) {
        boolean isOptional = false;
        for (Iterator<String> var10 = attributes.iterator(); var10.hasNext(); isOptional = false) {
            String value = var10.next();
            if (propertyViolated.replace("\\.", "").contains(value)) {
                isOptional = true;
                break;
            }
        }
        return isOptional;
    }

    private static <T> List<String> validateOptionalParameters(T dto) {
        Class<?> objectToValidate = dto.getClass();
        Field[] attributes = objectToValidate.getDeclaredFields();
        List<String> attributeList = new ArrayList<>();

        for (Field value : attributes) {
            Optional annotation = value.getAnnotation(Optional.class);
            if (annotation != null) {
                Class<?>[] groups = annotation.groups();

                for (Class<?> group : groups) {
                    if (group == IDTOInOptionalAttributes.class || group == IDTOOutOptionalAttributes.class) {
                        attributeList.add(value.getName());
                    }
                }
            }
        }

        return attributeList;
    }

    private static <T> boolean hasViolations(Set<ConstraintViolation<T>> violationsSet) {
        return java.util.Optional.ofNullable(violationsSet).filter(v -> !v.isEmpty()).map(Set::iterator).map(Iterator::next).isPresent();
    }

    private static <T> void throwBusinessException(ConstraintViolation<T> violation, String message) {
        String messageViolation = violation.getConstraintDescriptor().getMessageTemplate();
        if (messageViolation.contains(NOT_NULL) || messageViolation.contains(NOT_EMPTY) || messageViolation.contains(NOT_BLANK)) {
            throw new BusinessServiceException(ErrorEnum.MANDATORY_PARAMETERS_MISSING.getAlias(), message);
        } else {
            throw new BusinessServiceException(ErrorEnum.INVALID_PARAMETERS.getAlias(), message);
        }
    }
}