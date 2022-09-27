package com.bbva.ccol.merchantsmerchantsacquirementsacquirementscontractssendv0.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bbva.jee.arq.spring.core.servicing.configuration.ConfigurationManager;

/**
 * Clase que permite el acceso a las propiedades de configuracion
 * 
 * @author carlos.toro
 *
 */
@Component("configurationProperties")
public class ConfigurationProperties {

	@Autowired
	private ConfigurationManager configurationManager;

	public String getProperty(String key) {
		return configurationManager.getProperty(key);
	}

}
