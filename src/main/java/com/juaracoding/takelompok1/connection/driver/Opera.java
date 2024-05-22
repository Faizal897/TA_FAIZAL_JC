package com.juaracoding.takelompok1.connection.driver;

import com.juaracoding.pcmautomation.connection.DriverStrategy;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.managers.OperaDriverManager;
import org.openqa.selenium.WebDriver;

public class Opera implements DriverStrategy {

    @Override
    public WebDriver setStrategy() {
        WebDriverManager.operadriver().setup();
        WebDriver driver = (WebDriver) new OperaDriverManager();

        return driver;
    }
}
