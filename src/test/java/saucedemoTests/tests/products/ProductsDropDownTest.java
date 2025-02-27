package saucedemoTests.tests.products;

import org.testng.annotations.Test;
import saucedemoPages.ProductsPage;
import saucedemoTests.base.BaseTest;

import static org.testng.Assert.*;

public class ProductsDropDownTest extends BaseTest {

    @Test
    public void testProductsHeaderIsDisplayed() {
        ProductsPage productsPage = loginPage.logIntoApplication(usersInfo.getCorrectUser(), usersInfo.getCorrectPassword());

        productsPage.selectFromDropDown("Price (high to low)");
        String firstProductValue = productsPage.checkFirstProductValue();
        assertEquals(firstProductValue,"$49.99");
    }
}