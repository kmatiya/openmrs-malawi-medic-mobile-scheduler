package com.pih.medicmobilescheduler.emr;

import com.pih.medicmobilescheduler.config.EmrApplicationConfig;
import org.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestTemplate;

@Component
public class TraceReportService {
    @Autowired
    EmrApplicationConfig emrApplicationConfig;


    public ResponseEntity<String> getTraceReport(String date)
    {
        final String TRACE_URL = emrApplicationConfig.getEmrTraceReportUrl()+ "?date="+date;

        // create headers
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setBasicAuth(emrApplicationConfig.getEmrBasicAuthUsername(),emrApplicationConfig.getEmrBasicAuthPassword());

        // create request
        HttpEntity<String> request = new HttpEntity<>(headers);
        try
        {
            // make a request
            ResponseEntity<String> response = new RestTemplate().exchange(TRACE_URL, HttpMethod.GET, request, String.class);
            return response;
        }catch (HttpClientErrorException ex)
        {
            return new ResponseEntity<>(ex.getResponseBodyAsString(), HttpStatus.valueOf(ex.getStatusCode().value()));
        }
        catch (ResourceAccessException ex)
        {
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
