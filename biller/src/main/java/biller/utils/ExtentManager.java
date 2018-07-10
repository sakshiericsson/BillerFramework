package biller.utils;

import com.relevantcodes.extentreports.ExtentReports;

public class ExtentManager {

	private static ExtentReports extent;
	private static ExtentHtmlReporter htmlReporter;
	private static String filePath = "./extentreport.html";


	public static ExtentReports GetExtent() {
		if (extent != null) {
			return extent;
		} else {
			extent = new ExtentReports();
			extent.attachReporter(getHtmlReporter());
			extent.setSystemInfo("Host Name", "Sakshi");
			
			extent.setAnalysisStrategy(AnalysisStrategy.CLASS);
			return extent;
		}
	}

	public static ExtentHtmlReporter getHtmlReporter() {

		htmlReporter = new ExtentHtmlReporter(filePath);
				
		htmlReporter.setAppendExisting(false);
		htmlReporter.loadXMLConfig(System.getProperty("user.dir")+"\\src\\test\\java\\ReportsConfig.xml");

		return htmlReporter;
	}


}
