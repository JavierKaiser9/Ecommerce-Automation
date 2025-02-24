package saucedemoTests.base;

import dataBase.WebsiteData;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import base.BasePage;
import saucedemoPages.CartPage;
import saucedemoPages.FirstCheckoutPage;
import saucedemoPages.LoginPage;
import saucedemoPages.ProductsPage;

import static base.BasePage.delay;
import static utilities.Utility.setUtilityDriver;

public class BaseTest {

    protected WebDriver driver;
    protected BasePage basePage;
    protected LoginPage loginPage;
    protected ProductsPage productsPage;
    protected CartPage cartPage;
    protected FirstCheckoutPage firstCheckoutPage;
    protected WebsiteData websiteData;
    private String url = "https://www.saucedemo.com/";

    @BeforeClass
    public void setUp(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();;
        driver.get(url);
        basePage = new BasePage();
        basePage.setDriver(driver);
        setUtilityDriver();

        loginPage = new LoginPage();
        websiteData = new WebsiteData();
        productsPage = new ProductsPage();
        cartPage = new CartPage();
        firstCheckoutPage = new FirstCheckoutPage();

    }

    @AfterClass
    public void tearDown(){
        delay(2000);
        driver.quit();
    }
}
