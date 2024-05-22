package com.juaracoding.takelompok1.impl.imam;

import com.juaracoding.pcmautomation.connection.Constants;
import com.juaracoding.pcmautomation.selenium.page.practicetestautomation.HomePage;
import com.juaracoding.pcmautomation.selenium.page.practicetestautomation.LoginPage;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

/**
 *  URL : https://practicetestautomation.com/practice-test-login/
 */
public class MenuOnePositif {
    public WebDriver driver;
    private static ExtentTest extentTest;
    private LoginPage loginPage ;
    private HomePage homePage;

    public MenuOnePositif(){
        this.driver = MenuOneOutlineHooks.driver;
        loginPage = new LoginPage(driver);
        homePage = new HomePage(driver);
        extentTest = MenuOneOutlineHooks.extentTest;
    }

    @When("Pta001 Mengakses Halaman Website")
    public void pta001_mengakses_halaman_website(){
        this.driver.get(Constants.URL_LOGIN);
        extentTest.log(LogStatus.PASS, "Pta001 Mengakses Halaman Website");
    }

    @And("Pta001 Mengkosongkan Field Untuk Login")
    public void pta001_mengkosongkan_field_untuk_login(){
        loginPage.clear();
        extentTest.log(LogStatus.PASS, "Pta001 Mengkosongkan Field Untuk Login");
    }

//    @And("^Pta001 Input (.*) dan (.*) Valid$")
    @And("^Pta001 Input (.*) Valid$")
    public void pta001_input_username_valid(String username){
        loginPage.inputUsername(username);//STEP-2
        extentTest.log(LogStatus.PASS, "Pta001 input Username Valid");
    }

    @And("^Pta001 Input (.*) Valid Two$")
//    public void pta001_input_valid_two(String password){
    public void pta001_input_password_valid_two(String password){
        loginPage.inputPassword(password);//STEP-3
        extentTest.log(LogStatus.PASS, "Pta001 input Password Valid Two");
    }

    @And("Pta001 Menekan Tombol Login")
    public void pta001_menekan_tombol_login(){
        loginPage.clickLogin();//STEP-4
        extentTest.log(LogStatus.PASS, "Pta001 Menekan Tombol Login");
    }

    @Then("Pta001 Validasi Label Sukses Di Halaman Home Page")
    public void pta001_validasi_label_sukses_di_halaman_home_page(){
        String strValidation = homePage.homePageValidation();
//        System.out.println("Home Page Validation "+strValidation);
        Assert.assertEquals("Congratulations student. You successfully logged in!",strValidation);//STEP-5
        extentTest.log(LogStatus.PASS, "Pta001 Validasi Label Sukses Di Halaman Home Page");
    }

    @When("Pta001 Klik Tombol Logout")
    public void pta001_menekan_tombol_logout(){
        homePage.logout();
        extentTest.log(LogStatus.PASS, "Pta001 Menekan Tombol Logout");
    }

    @Then("Pta001 Validasi Halaman Login")
    public void pta001_validasi_halaman_login(){
        String strLoginFormValidation = loginPage.loginFormValidation();//setelah logout
        Assert.assertEquals("Test login",strLoginFormValidation);
        extentTest.log(LogStatus.PASS, "Pta001 Validasi Halaman Login");
    }

//    @Then("Pta001 Menutup Browser")
//    public void pta001_menutup_browser(){
//        DriverSingleton.closeObjectInstance();
//    }
}