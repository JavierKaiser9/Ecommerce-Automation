package saucedemoTests.tests.firstCheckout;

import org.testng.annotations.Test;
import saucedemoPages.CartPage;
import saucedemoPages.FirstCheckoutPage;
import saucedemoPages.ProductsPage;
import saucedemoTests.base.BaseTest;

import static org.testng.Assert.assertTrue;

public class FirstCheckOutErrorMessageTest extends BaseTest {

    @Test
    public void testFirstCheckoutErrorMessageNoName() {

        ProductsPage productsPage = loginPage.logIntoApplication(usersInfo.getCorrectUser(), usersInfo.getCorrectPassword());
        productsPage.addOrRemoveItem("add", 0);
        productsPage.addOrRemoveItem("add", 1);
        CartPage cartPage = productsPage.goToCartPage();
        FirstCheckoutPage firstCheckoutPage = cartPage.goToFirstCheckoutPage();
        firstCheckoutPage.setCustomerData("", usersInfo.getCheckOutLastName(), usersInfo.getPostalCode());

        String errorMessage = firstCheckoutPage.getErrorMessageFirstCheckoutPage();
        assertTrue(errorMessage.contains("Error: First Name is required"));
    }

    @Test
    public void testFirstCheckoutErrorMessageNoLastName() {

        ProductsPage productsPage = loginPage.logIntoApplication(usersInfo.getCorrectUser(), usersInfo.getCorrectPassword());
        productsPage.addOrRemoveItem("add", 2);
        productsPage.addOrRemoveItem("add", 4);
        CartPage cartPage = productsPage.goToCartPage();
        FirstCheckoutPage firstCheckoutPage = cartPage.goToFirstCheckoutPage();
        firstCheckoutPage.setCustomerData(usersInfo.getCheckOutName(), "", usersInfo.getPostalCode());

        String errorMessage = firstCheckoutPage.getErrorMessageFirstCheckoutPage();
        assertTrue(errorMessage.contains("Error: Last Name is required"));
    }

    @Test
    public void testFirstCheckoutErrorMessageNoPostalCode() {

        ProductsPage productsPage = loginPage.logIntoApplication(usersInfo.getCorrectUser(), usersInfo.getCorrectPassword());
        productsPage.addOrRemoveItem("add", 1);
        productsPage.addOrRemoveItem("add", 5);
        CartPage cartPage = productsPage.goToCartPage();
        FirstCheckoutPage firstCheckoutPage = cartPage.goToFirstCheckoutPage();
        firstCheckoutPage.setCustomerData(usersInfo.getCheckOutName(), usersInfo.getCheckOutLastName() , "");

        String errorMessage = firstCheckoutPage.getErrorMessageFirstCheckoutPage();
        assertTrue(errorMessage.contains("Error: Postal Code is required"));
    }
}