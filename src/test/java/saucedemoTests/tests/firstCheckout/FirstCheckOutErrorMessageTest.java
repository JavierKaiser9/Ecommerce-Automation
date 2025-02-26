package saucedemoTests.tests.firstCheckout;

import dataBase.UsersInfo;
import org.testng.annotations.Test;
import saucedemoPages.CartPage;
import saucedemoPages.FirstCheckoutPage;
import saucedemoPages.ProductsPage;
import saucedemoTests.base.BaseTest;

import static org.testng.Assert.assertTrue;

public class FirstCheckOutErrorMessageTest extends BaseTest {

    //UsersInfo usersInfo = usersInfo();

    @Test
    public void testFirstCheckoutErrorMessageNoName() {

        ProductsPage productsPage = loginPage.logIntoApplication(UsersInfo.correctPassword, UsersInfo.correctPassword);
        productsPage.addOrRemoveItem("add", 2);
        productsPage.addOrRemoveItem("add", 3);
        CartPage cartPage = productsPage.goToCartPage();
        FirstCheckoutPage firstCheckoutPage = cartPage.goToFirstCheckoutPage();
        firstCheckoutPage.setCustomerData("", UsersInfo.checkOutLastName, UsersInfo.postalCode);

        String errorMessage = firstCheckoutPage.getErrorMessageFirstCheckoutPage();
        assertTrue(errorMessage.contains("Error: First Name is required"));
    }

    @Test
    public void testFirstCheckoutErrorMessageNoLastName() {

        ProductsPage productsPage = loginPage.logIntoApplication(UsersInfo.correctUser, UsersInfo.correctPassword);
        productsPage.addOrRemoveItem("add", 2);
        productsPage.addOrRemoveItem("add", 4);
        CartPage cartPage = productsPage.goToCartPage();
        FirstCheckoutPage firstCheckoutPage = cartPage.goToFirstCheckoutPage();
        firstCheckoutPage.setCustomerData(UsersInfo.checkOutName, "", UsersInfo.postalCode);

        String errorMessage = firstCheckoutPage.getErrorMessageFirstCheckoutPage();
        assertTrue(errorMessage.contains("Error: Last Name is required"));
    }

    @Test
    public void testFirstCheckoutErrorMessageNoPostalCode() {

        ProductsPage productsPage = loginPage.logIntoApplication(UsersInfo.correctUser, UsersInfo.correctPassword);
        productsPage.addOrRemoveItem("add", 1);
        productsPage.addOrRemoveItem("add", 5);
        CartPage cartPage = productsPage.goToCartPage();
        FirstCheckoutPage firstCheckoutPage = cartPage.goToFirstCheckoutPage();
        firstCheckoutPage.setCustomerData(UsersInfo.checkOutName, UsersInfo.checkOutLastName, "");

        String errorMessage = firstCheckoutPage.getErrorMessageFirstCheckoutPage();
        assertTrue(errorMessage.contains("Error: Postal Code is required"));
    }
}
