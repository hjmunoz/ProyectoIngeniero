package com.bbva.ccol.merchantsmerchantsacquirementsacquirementscontractssendv0.facade.v0.dto;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonTypeInfo;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME,
include = JsonTypeInfo.As.EXISTING_PROPERTY,
property = "Unit")
public class Unit implements Serializable {/**
	 * 
	 */
	private static final long serialVersionUID = 506016118271453044L;

}
