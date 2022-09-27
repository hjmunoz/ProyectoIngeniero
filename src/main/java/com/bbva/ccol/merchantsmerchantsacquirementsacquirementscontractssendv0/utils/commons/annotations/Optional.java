package com.bbva.ccol.merchantsmerchantsacquirementsacquirementscontractssendv0.utils.commons.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Interfaz que representa la anotacion @Optional
 * @author carlos.toro
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD, ElementType.FIELD, ElementType.ANNOTATION_TYPE, ElementType.CONSTRUCTOR, ElementType.PARAMETER})
public @interface Optional {
    Class<?>[] groups() default {};
}
