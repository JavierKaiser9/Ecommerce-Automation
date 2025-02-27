package saucedemoTests.tests.products;

import org.testng.annotations.Test;
import saucedemoPages.ProductsPage;
import saucedemoTests.base.BaseTest;
import static org.testng.Assert.*;

public class ProductsSelectionTest extends BaseTest {

    @Test
    public void selectProduct(){

        String[] validation = new String[4];

        ProductsPage productsPage = loginPage.logIntoApplication(usersInfo.getCorrectUser(), usersInfo.getCorrectPassword());
        var customerPick = productsPage.generateNumbers(); // This method simulates 3 random picks and one removal.

        validation[0] = productsPage.addOrRemoveItem("add", customerPick.get(0));
        validation[1] = productsPage.addOrRemoveItem("add", customerPick.get(1));
        validation[2] = productsPage.addOrRemoveItem("add", customerPick.get(2));
        validation[3] = productsPage.addOrRemoveItem("remove", customerPick.get(3));


        // Assert the current product status.
       for (int i = 0; i < validation.length-1; i++) {
            if (customerPick.get(i).equals(customerPick.getLast())) {
                assertTrue(productsPage.checkProductSelection(validation[3]));
                System.out.println("ID: " + validation[3] + " -> Confirmed");
            } else {
                assertTrue(productsPage.checkProductSelection(validation[i]));
                System.out.println("ID: " + validation[i] + " -> Confirmed");
            }
        }
    }
}