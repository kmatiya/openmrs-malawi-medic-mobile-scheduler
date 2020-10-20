package com.pih.medicmobilescheduler.emr;

import com.sun.management.jmx.Trace;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TraceReportServiceTest {

    @Autowired
    TraceReportService traceReportService = new TraceReportService();

    @Test
    public void getTraceReport_CorrectDate_ReturnTraceReport()
    {
        ResponseEntity<String> traceReportServiceResponse = traceReportService.getTraceReport("2020-10-23");
        String kj = "";

    }
}
