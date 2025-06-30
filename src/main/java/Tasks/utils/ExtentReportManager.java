package Tasks.utils;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportManager {
    private static ExtentReports extent;

    public static ExtentReports getReporter() {
        if (extent == null) {
            ExtentSparkReporter spark = new ExtentSparkReporter("target/ExtentReports/ExtentReport.html");
            extent = new ExtentReports();
            extent.attachReporter(spark);
        }
        return extent;
    }
}
