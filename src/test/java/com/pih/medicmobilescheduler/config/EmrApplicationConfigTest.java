package com.pih.medicmobilescheduler.config;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EmrApplicationConfigTest {

    @Autowired
    EmrApplicationConfig emrApplicationConfig;

    @Test
    public void getEmrTraceReportUrl_ReturnUrlFromPropertiesFile()
    {
        String emrTraceReportUrl = emrApplicationConfig.getEmrTraceReportUrl();
        String expected = "test_url";
        Assert.assertEquals(expected,emrTraceReportUrl);
    }
    @Test
    public void  getEmrBasicAunthUsername_ReturnUsernameFromPropertiesFile()
    {
        String emrBasicAuthUsername = emrApplicationConfig.getEmrBasicAuthUsername();
        String expected = "test_emr_username";
        Assert.assertEquals(expected,emrBasicAuthUsername);
    }
    @Test
    public void  getEmrBasicAunthPassword_ReturnPasswordFromPropertiesFile()
    {
        String emrBasicAuthPassword = emrApplicationConfig.getEmrBasicAuthPassword();
        String expected = "test_emr_password";
        Assert.assertEquals(expected,emrBasicAuthPassword);
    }
}
