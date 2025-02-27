package saucedemoTests.base;

import dataBase.ProductsInfo;
import dataBase.UsersInfo;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import base.BasePage;
import org.testng.annotations.BeforeMethod;
import saucedemoPages.*;

import java.io.File;
import java.io.IOException;

import static base.BasePage.delay;
import static utilities.Utility.setUtilityDriver;

public class BaseTest {

    protected WebDriver driver;
    protected BasePage basePage;
    protected LoginPage loginPage;
    protected UsersInfo usersInfo;
    protected ProductsInfo productsInfo;
    private String url = "https://www.saucedemo.com/";

    @BeforeClass
    public void setUp(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(url);
    }

    @BeforeMethod
    public void loadApplication(){
        basePage = new BasePage();
        basePage.setDriver(driver);
        setUtilityDriver();

        loginPage = new LoginPage();
        usersInfo = new UsersInfo();
        productsInfo = new ProductsInfo();
    }

    @AfterMethod
    public void takeFailedResultsScreenshot(ITestResult testResult){
        if (ITestResult.FAILURE == testResult.getStatus()){
            TakesScreenshot screenshot = (TakesScreenshot) driver;
            File source = screenshot.getScreenshotAs(OutputType.FILE);
            File destination = new File(System.getProperty("user.dir") +
                    "/resources/screenshots/(" + java.time.LocalDate.now() +
                    testResult.getName() + ".png");
            try {
                FileHandler.copy(source,destination);
            } catch (IOException e){
                throw new RuntimeException(e);
            }
            System.out.println("Screenshot Located at: " + destination);
        }
    }

    @AfterClass
    public void tearDown(){
        delay(2000);
        driver.quit();
    }
}
