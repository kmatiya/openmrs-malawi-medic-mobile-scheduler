package com.pih.medicmobilescheduler;

import com.pih.medicmobilescheduler.emr.TraceReportService;
import com.pih.medicmobilescheduler.medicmobile.MedicMobileTraceReportService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.Date;

@SpringBootApplication
public class MedicMobileSchedulerApplication {

	private static final Log log = LogFactory.getLog(MedicMobileSchedulerApplication.class);
	@Autowired
	TraceReportService traceReportService;
	@Autowired
	MedicMobileTraceReportService medicMobileTraceReportService;


	public static void main(String[] args) {

		// Initialize environment
		ApplicationContext context = SpringApplication.run(MedicMobileSchedulerApplication.class, args);
		MedicMobileSchedulerApplication app = context.getBean(MedicMobileSchedulerApplication.class);


		// Request for trace report
		ResponseEntity<String> traceReportServiceResponse = app.getTraceReportService().getTraceReport("2019-05-17");
		try
		{
			if(traceReportServiceResponse.getStatusCode().is2xxSuccessful())
			{
				JSONArray traceReportArrayDataFormatted = new JSONArray(traceReportServiceResponse.getBody());
				JSONObject traceReportMedicMobileFormat = new JSONObject();
				traceReportMedicMobileFormat.put("docs",traceReportArrayDataFormatted);
				System.out.println(traceReportMedicMobileFormat);
				ResponseEntity<String> responseFromMedicMobile = app.getMedicMobileTraceReportService().postTraceReportToMedicMobile(traceReportMedicMobileFormat);
				System.out.println(responseFromMedicMobile.getBody());
				log.info("Trace report generated successfully at "+new Date());
			}
			else
			{
				log.error(traceReportServiceResponse.getStatusCode()+"---"+traceReportServiceResponse.getBody());
			}
		} catch (Exception ex)
		{
			log.error(ex.getMessage()+"---"+ Arrays.toString(ex.getStackTrace()));
		}

	}
	public TraceReportService getTraceReportService()
	{
		return traceReportService;
	}
	public MedicMobileTraceReportService getMedicMobileTraceReportService()
	{
		return medicMobileTraceReportService;
	}
}
