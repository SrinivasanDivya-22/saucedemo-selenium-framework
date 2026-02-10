package util;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentManager {

    private static ExtentReports extent;

    public static ExtentReports getInstance() {
        if (extent == null) {

            ExtentSparkReporter reporter =
                    new ExtentSparkReporter("reports/AutomationReport.html");

            reporter.config().setDocumentTitle("SauceDemo Automation Report");
            reporter.config().setReportName("UI Automation Test Results");

            extent = new ExtentReports();
            extent.attachReporter(reporter);

            extent.setSystemInfo("Tester", "Divya");
            extent.setSystemInfo("Framework", "Selenium + TestNG + POM");

        }
        return extent;
    }
}
