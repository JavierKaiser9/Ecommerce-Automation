package saucedemoTests.tests.products;

import dataBase.UsersInfo;
import org.testng.annotations.Test;
import saucedemoPages.ProductsPage;
import saucedemoTests.base.BaseTest;

import static org.testng.Assert.assertEquals;
import static utilities.JavaScriptsUtility.acceptAlert;
import static utilities.JavaScriptsUtility.getAlertText;

public class ProductsAlertTest extends BaseTest {

    @Test
    public void checkProductsPageAlarm(){

        String expectedAlertText = "Sorting is broken! This error has been reported to Backtrace.";

        ProductsPage productsPage = loginPage.logIntoApplication(UsersInfo.registeredUsers[1],
                UsersInfo.correctPassword);
        productsPage.selectFromDropDown("Price (high to low)");
        assertEquals(getAlertText(), expectedAlertText,
                "No Text Founded");
        acceptAlert();

    }

}
