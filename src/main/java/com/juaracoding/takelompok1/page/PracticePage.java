package com.juaracoding.takurniawan.page;

import com.juaracoding.pcmautomation.connection.Constants;
import com.juaracoding.pcmautomation.connection.DriverSingleton;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PracticePage {
    private WebDriver driver;
    @FindBy(xpath = "//h1[@class='post-title']")
    private WebElement labelMenuPractice;
    @FindBy(xpath = "//a[normalize-space()='Test Exceptions']")
    private WebElement btnMenuTextException;

    public PracticePage() {
        this.driver= DriverSingleton.getDriver();
        PageFactory.initElements(driver,this);
    }

    public PracticePage(WebDriver driver) {
        this.driver= driver;
        PageFactory.initElements(driver,this);
    }

    public WebElement goToMenuTextException(){
        return btnMenuTextException;
    }

    public String menuPracticeValidation(){
        return labelMenuPractice==null?"":new WebDriverWait(driver, Duration.ofSeconds(Constants.TIMEOUT_DELAY))
                .until(ExpectedConditions.visibilityOf(labelMenuPractice)).getText();
    }


}