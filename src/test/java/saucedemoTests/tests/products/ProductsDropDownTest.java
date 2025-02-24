package saucedemoTests.tests.products;

import static org.testng.Assert.*;

import dataBase.UsersInfo;
import org.testng.annotations.Test;
import saucedemoPages.LoginPage;
import saucedemoPages.ProductsPage;
import saucedemoTests.base.BaseTest;
import utilities.JavaScriptsUtility;
import static utilities.JavaScriptsUtility.clickJS;

public class ProductsDropDownTest extends BaseTest {

    @Test
    public void testProductsHeaderIsDisplayed() {
        ProductsPage productsPage = loginPage.
                logIntoApplication(UsersInfo.correctUser, UsersInfo.correctPassword);
        productsPage.selectFromDropDown("Price (high to low)");
        String firstProductValue = productsPage.checkFirstProductValue();
        assertEquals(firstProductValue,"$49.99");
        System.out.println();
    }
}
