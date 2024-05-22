package com.juaracoding.takelompok1.impl.fabian;

import com.juaracoding.pcmautomation.connection.Constants;
import com.juaracoding.pcmautomation.connection.DriverSingleton;
import com.juaracoding.pcmautomation.cucumber.practicetestautomation.scenariomapping.LoginTesting;
import com.juaracoding.pcmautomation.util.GlobalFunction;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import io.cucumber.java.*;
import org.openqa.selenium.WebDriver;

import java.io.IOException;

public class LoginOutlineHooks {
	public static WebDriver driver;
	public static ExtentTest extentTest;
	public static ExtentReports reports = new ExtentReports(GlobalFunction.rootProject+"/practiceautomation-report/extentreport/login.html");
	private static LoginTesting[] tests = LoginTesting.values();
	private static final int[] DATA_OUTLINE = {1,1,1,1};
	private String testReport = "";
	
	@Before
	public void setUp() {		
		DriverSingleton.getInstance(Constants.FIREFOX);
		driver = DriverSingleton.getDriver();
		testReport = tests[GlobalFunction.testCount].getTestName();
		extentTest = reports.startTest(testReport);
		if(GlobalFunction.countOutline==DATA_OUTLINE[GlobalFunction.testCount])
		{
			GlobalFunction.countOutline=0;
			GlobalFunction.testCount++;
		}
		GlobalFunction.countOutline++;
	}
	
	@AfterStep
	public void getResultStatus(Scenario scenario) throws IOException {
		if(scenario.isFailed()) {
			String screenshotPath = GlobalFunction.getScreenshot(driver, "PTA_LoginOutlineHooks"+scenario.getName().replace(" ", "_"));
			extentTest.log(LogStatus.FAIL, scenario.getName()+"\n"
					+extentTest.addScreenCapture(screenshotPath));;
		}
	}
	
	@After
	public void closeObject() {
		reports.endTest(extentTest);
		reports.flush();
	}
	
	@AfterAll
	public static void closeBrowser() {
		GlobalFunction.delay(Constants.TIMEOUT_DELAY, Constants.GLOB_PARAM_DELAY);
		DriverSingleton.closeObjectInstance();
	}
}