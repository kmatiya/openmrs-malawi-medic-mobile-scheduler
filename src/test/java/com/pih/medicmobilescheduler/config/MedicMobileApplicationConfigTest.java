package com.pih.medicmobilescheduler.config;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MedicMobileApplicationConfigTest {
    @Autowired
    MedicMobileApplicationConfig medicMobileApplicationConfig;

    @Test
    public void getMedicMobileTraceReportUrl_ReturnUrlFromPropertiesFile()
    {
        String medicMobileUrl = medicMobileApplicationConfig.getMedicMobileUrl();
        String expected = "medic_mobile_test_url";
        Assert.assertEquals(expected,medicMobileUrl);
    }
    @Test
    public void  getEmrBasicAunthUsername_ReturnUsernameFromPropertiesFile()
    {
        String emrBasicAuthUsername = medicMobileApplicationConfig.getMedicMobileBasicAuthUsername();
        String expected = "test_medic_mobile_username";
        Assert.assertEquals(expected,emrBasicAuthUsername);
    }
    @Test
    public void  getEmrBasicAunthPassword_ReturnPasswordFromPropertiesFile()
    {
        String emrBasicAuthPassword = medicMobileApplicationConfig.getMedicMobileBasicAuthPassword();
        String expected = "test_medic_mobile_password";
        Assert.assertEquals(expected,emrBasicAuthPassword);
    }
}
