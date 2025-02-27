package saucedemoTests.tests.products;

import org.testng.annotations.Test;
import saucedemoPages.ProductsPage;
import saucedemoTests.base.BaseTest;

import static org.testng.Assert.*;

public class ProductsCounterTest extends BaseTest {

    @Test
    public void productsCounterTest(){

        ProductsPage productsPage = loginPage.logIntoApplication(usersInfo.getCorrectUser(), usersInfo.getCorrectPassword());
        productsPage.addOrRemoveItem("add", 1);
        productsPage.addOrRemoveItem("add", 3);
        productsPage.addOrRemoveItem("add", 5);

        String numberOfProductsRegistered = productsPage.getNumberOfItemsSelected();
        String expectedNumber = "3";

        System.out.println("Number Displayed:" + numberOfProductsRegistered);

        assertEquals(numberOfProductsRegistered, expectedNumber);

    }
}
