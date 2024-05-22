package com.juaracoding.takelompok1.connection.driver;

import com.juaracoding.pcmautomation.connection.DriverStrategy;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.safari.SafariDriver;

public class Safari implements DriverStrategy {

	@Override
	public WebDriver setStrategy() {
		WebDriverManager.safaridriver().setup();
		WebDriver driver = new SafariDriver();
		
		return driver;
	}
}
