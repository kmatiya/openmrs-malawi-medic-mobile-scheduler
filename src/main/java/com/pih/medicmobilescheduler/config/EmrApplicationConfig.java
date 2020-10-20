package com.pih.medicmobilescheduler.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Component
public class EmrApplicationConfig {
    private static final String EMR_TRACE_REPORT_URL = "emr.trace_url";
    private static final String EMR_BASIC_AUTH_USERNAME = "emr.basic_authentication.username";
    private static final String EMR_BASIC_AUTH_PASSWORD = "emr.basic_authentication.password";
    @Autowired
    Environment environment;

    public String getEmrTraceReportUrl()
    {
        return environment.getProperty(EmrApplicationConfig.EMR_TRACE_REPORT_URL);
    }
    public String getEmrBasicAuthUsername()
    {
        return environment.getProperty(EmrApplicationConfig.EMR_BASIC_AUTH_USERNAME);
    }
    public String getEmrBasicAuthPassword()
    {
        return environment.getProperty(EmrApplicationConfig.EMR_BASIC_AUTH_PASSWORD);
    }

}
