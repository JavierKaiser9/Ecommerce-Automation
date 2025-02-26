package saucedemoTests.tests.firstCheckout;

import dataBase.ProductsInfo;
import dataBase.UsersInfo;
import org.testng.Assert;
import org.testng.annotations.Test;
import saucedemoPages.SecondCheckoutPage;
import saucedemoTests.base.BaseTest;

import static org.testng.Assert.assertTrue;

public class FirstCheckOutErrorMessageTest extends BaseTest {

    @Test
    public void testFirstCheckoutErrorMessageNoName() {

        loginPage.logIntoApplication(UsersInfo.correctUser, UsersInfo.correctPassword);
        productsPage.addOrRemoveItem("add", 2);
        productsPage.addOrRemoveItem("add", 3);
        productsPage.goToCartPage();
        cartPage.goToFirstCheckoutPage();
        firstCheckoutPage.setCustomerData("", UsersInfo.checkOutLastName, UsersInfo.postalCode);

        String errorMessage = firstCheckoutPage.getErrorMessageFirstCheckoutPage();
        assertTrue(errorMessage.contains("Error: First Name is required"));
    }

    @Test
    public void testFirstCheckoutErrorMessageNoLastName() {

        loginPage.logIntoApplication(UsersInfo.correctUser, UsersInfo.correctPassword);
        productsPage.addOrRemoveItem("add", 2);
        productsPage.addOrRemoveItem("add", 4);
        productsPage.goToCartPage();
        cartPage.goToFirstCheckoutPage();
        firstCheckoutPage.setCustomerData(UsersInfo.checkOutName, "", UsersInfo.postalCode);

        String errorMessage = firstCheckoutPage.getErrorMessageFirstCheckoutPage();
        assertTrue(errorMessage.contains("Error: Last Name is required"));
    }

    @Test
    public void testFirstCheckoutErrorMessageNoPostalCode() {

        loginPage.logIntoApplication(UsersInfo.correctUser, UsersInfo.correctPassword);
        productsPage.addOrRemoveItem("add", 1);
        productsPage.addOrRemoveItem("add", 5);
        productsPage.goToCartPage();
        cartPage.goToFirstCheckoutPage();
        firstCheckoutPage.setCustomerData(UsersInfo.checkOutName, UsersInfo.checkOutLastName, "");

        String errorMessage = firstCheckoutPage.getErrorMessageFirstCheckoutPage();
        assertTrue(errorMessage.contains("Error: Postal Code is required"));
    }
}
