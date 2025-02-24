package saucedemoTests.tests.cart;

import dataBase.ProductsInfo;
import dataBase.UsersInfo;
import org.testng.annotations.Test;
import saucedemoPages.ProductsPage;
import saucedemoTests.base.BaseTest;
import static org.testng.Assert.*;

public class CartTest extends BaseTest {

    @Test
    public void cartTest(){
        String[] productsToCheck = {ProductsInfo.originalProductsNames[2],ProductsInfo.originalProductsNames[3]};

        loginPage.logIntoApplication(UsersInfo.correctUser, UsersInfo.correctPassword);
        productsPage.addOrRemoveItem("add", 2);
        productsPage.addOrRemoveItem("add", 3);
        productsPage.goToCartPage();
        var cartInformation = cartPage.getCartInformation();
        assertTrue(cartPage.checkProductsAdded(cartInformation,productsToCheck));

    }
}
