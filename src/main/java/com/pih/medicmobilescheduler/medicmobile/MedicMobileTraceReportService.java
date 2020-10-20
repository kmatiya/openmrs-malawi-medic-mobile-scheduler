package com.pih.medicmobilescheduler.medicmobile;

import com.pih.medicmobilescheduler.config.MedicMobileApplicationConfig;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

@Component
public class MedicMobileTraceReportService {
    @Autowired
    MedicMobileApplicationConfig medicMobileApplicationConfig;

    public ResponseEntity<String> postTraceReportToMedicMobile(JSONObject traceReport)
    {
        final String MEDIC_MOBILE_TRACE_URL = medicMobileApplicationConfig.getMedicMobileUrl();

        // create headers
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setBasicAuth(medicMobileApplicationConfig.getMedicMobileBasicAuthUsername(),medicMobileApplicationConfig.getMedicMobileBasicAuthPassword());

        // create request
        HttpEntity<String> request = new HttpEntity<>(traceReport.toString(),headers);
        try {
            // make a request
            return new RestTemplate().postForEntity(MEDIC_MOBILE_TRACE_URL, request, String.class);
        }
        catch (HttpClientErrorException ex)
        {
            return new ResponseEntity<>(ex.getResponseBodyAsString(), HttpStatus.valueOf(ex.getStatusCode().value()));
        }
    }
}
