package com.juaracoding.takelompok1.impl.imam;

import com.juaracoding.pcmautomation.connection.Constants;
import com.juaracoding.pcmautomation.selenium.page.practicetestautomation.LoginPage;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class MenuOneNegatif {

    public WebDriver driver;
    private static ExtentTest extentTest;
    private LoginPage loginPage ;

    public MenuOneNegatif(){
        this.driver = MenuOneOutlineHooks.driver;
        loginPage = new LoginPage(driver);
        extentTest = MenuOneOutlineHooks.extentTest;
    }

/** start  - case ke 1 dari login negatif */
    @When("Pta002 Mengakses Halaman Website")
    public void pta002_mengakses_halaman_website(){
        this.driver.get(Constants.URL_LOGIN);
        extentTest.log(LogStatus.PASS, "Pta002 Mengakses Halaman Website");
    }

    @And("Pta002 Mengkosongkan Field Untuk Login")
    public void pta002_mengkosongkan_field_untuk_login(){
        loginPage.clear();
        extentTest.log(LogStatus.PASS, "Pta002 Mengkosongkan Field Untuk Login");
    }

    @And("Pta002 Input Username Kosong")
    public void pta002_input_username_kosong(){
        loginPage.inputUsername("");
        extentTest.log(LogStatus.PASS, "Pta002 Input Username Kosong");
    }

    @And("Pta002 Input Password Kosong")
    public void pta002_input_password_kosong(){
        loginPage.inputPassword("");
        extentTest.log(LogStatus.PASS, "Pta002 Input Password Kosong");
    }

    @And("Pta002 Menekan Tombol Login")
    public void pta002_menekan_tombol_login(){
        loginPage.clickLogin();
        extentTest.log(LogStatus.PASS, "Pta002 Menekan Tombol Login");
    }
    /** end  - case ke 1 dari login negatif */
    @Then("Pta002 Validasi Login Error Empty String")
    public void pta002_validasi_login_error_empty_string(){
        String strLoginError = loginPage.notificationLoginError();
        Assert.assertEquals("Your username is invalid!",strLoginError);
        extentTest.log(LogStatus.PASS, "Pta002 Validasi Login Error Empty String");
    }

    /** start  - case ke 2 dari login negatif */
    @When("Pta003 Mengkosongkan Field Untuk Login")
    public void pta003_mengkosongkan_field_untuk_login(){
        loginPage.clear();
        extentTest.log(LogStatus.PASS, "Pta003 Mengkosongkan Field Untuk Login");
    }

    @And("Pta003 Input Username Valid")
    public void pta003_input_username_valid(){
        loginPage.inputUsername("student");
        extentTest.log(LogStatus.PASS, "Pta003 Input Username Valid");
    }

    @And("Pta003 Input Password Salah")
    public void pta003_input_password_salah(){
        loginPage.inputPassword("password@1234");
        extentTest.log(LogStatus.PASS, "Pta003 Input Password Salah");
    }

    @And("Pta003 Menekan Tombol Login")
    public void pta003_menekan_tombol_login(){
        loginPage.clickLogin();
        extentTest.log(LogStatus.PASS, "Pta003 Menekan Tombol Login");
    }

    @Then("Pta003 Validasi Login Error Password Salah")
    public void pta003_validasi_login_error_password_salah(){
        Assert.assertEquals("Your password is invalid!",loginPage.notificationLoginError());
        extentTest.log(LogStatus.PASS, "Pta003 Validasi Login Error Password Salah");
    }

/** end  - case ke 2 dari login negatif */

    /** start  - case ke 3 dari login negatif */
    
    

}