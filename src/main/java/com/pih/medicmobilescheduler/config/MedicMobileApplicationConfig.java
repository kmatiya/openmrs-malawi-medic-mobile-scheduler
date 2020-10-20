package com.pih.medicmobilescheduler.config;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Component
public class MedicMobileApplicationConfig {
    private static final Log log = LogFactory.getLog(MedicMobileApplicationConfig.class);

    private static final String MEDIC_MOBILE_URL = "medic_mobile.trace_url";
    private static final String MEDIC_MOBILE_BASIC_AUTH_USERNAME = "medic_mobile.basic_authentication.username";
    private static final String MEDIC_MOBILE_BASIC_AUTH_PASSWORD = "medic_mobile.basic_authentication.password";

    @Autowired
    Environment environment;

    public String getMedicMobileUrl()
    {
       return environment.getProperty(MEDIC_MOBILE_URL);
    }
    public String getMedicMobileBasicAuthUsername()
    {
        return environment.getProperty(MEDIC_MOBILE_BASIC_AUTH_USERNAME);
    }
    public String getMedicMobileBasicAuthPassword()
    {
        return environment.getProperty(MEDIC_MOBILE_BASIC_AUTH_PASSWORD);
    }
}
