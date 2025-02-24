package saucedemoPages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Random;

import static utilities.JavaScriptsUtility.*;

public class ProductsPage extends BasePage {

    private String productsId;
    private boolean productStatus;
    private String productsMainRoot;
    private String[] addOrRemove = {"add-to-cart-", "remove-"};
    private String[] productsNames = {"fleece-jacket", "backpack", "bolt-t-shirt"
            ,"bike-light", "onesie", "test.allthethings()-t-shirt-(red)"};

    private By logOutButton = By.id("logout_sidebar_link");
    private By menuListButton = By.id("react-burger-menu-btn");
    private By productsHeader = By.xpath("//span[@class='title']");
    private By carBadge = By.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[3]/a[1]/span[1]");
    private By dropDown = By.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/span[1]/select[1]");
    private By firstProductValue = By.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[2]/div[1]");
    private By accessCartPage = By.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[3]/a[1]");

    /**
     * Generates a list of four numbers simulating human interaction.
     *
     * First, it picks three unique random numbers between 0 and 5.
     * Then, it selects one of them randomly and adds it as the fourth number.
     *
     * @return A list of four integers where the first three are unique,
     *         and the fourth is a duplicate of one of the first three
     *         to be removed as a product.
     */

    public List<Integer> generateNumbers(){
        Random random = new Random();
        List<Integer> numbers = new ArrayList<>();

        while (numbers.size()<3){
            int num = random.nextInt(6);
            if (!numbers.contains(num)){
                numbers.add(num);
            }
        }
        int fourthNumber = numbers.get(random.nextInt(3));
        numbers.add(fourthNumber);

        return numbers;
    }

    /**
     * ProductsPage Methods
     */

    public boolean isProductsHeaderDisplayed(){
        return find(productsHeader).isDisplayed();
    }

    public boolean checkProductSelection(String productsId){
        return find(By.id(productsId)).isDisplayed();
    }

    public String checkFirstProductValue(){
        return find(firstProductValue).getText();
    }

    public void selectFromDropDown(String userSelection){
        selectByVisibleText(dropDown,userSelection);
    }

    public LoginPage logOutApplication(){
        click(menuListButton);
        clickJS(logOutButton);
        return new LoginPage();
    }

    public CartPage goToCartPage(){
        clickJS(accessCartPage);
        return new CartPage();
    }

    public String addOrRemoveItem(String selection, int customerPick){

        if (customerPick == 5){
            productsMainRoot = "";   // Because of product's name Error.
        } else
            productsMainRoot = "sauce-labs-";

        if (Objects.equals(selection, "add")){
            productsId = addOrRemove[0] + productsMainRoot + productsNames[customerPick];
            productStatus = find(By.id(productsId)).isDisplayed();
            if(productStatus){
                System.out.println("Added product: " + productsNames[customerPick]);
                click(By.id(productsId));
                productsId = addOrRemove[1] + productsMainRoot + productsNames[customerPick];
            } else {
                System.out.println("The product" + productsNames[customerPick] + " was already selected");
            }

        } else if(Objects.equals(selection, "remove")){
            productsId = addOrRemove[1] + productsMainRoot + productsNames[customerPick];
            productStatus = find(By.id(productsId)).isDisplayed();
            if(productStatus){
                System.out.println("Removed product: " + productsNames[customerPick]);
                clickJS(By.id(productsId));
                productsId = addOrRemove[0] + productsMainRoot + productsNames[customerPick];
            } else {
                System.out.println("The product" + productsNames[customerPick] + " was already removed");
            }

        } else {
            System.out.println("Incorrect Input");
        }

        return productsId;  // Save selected products.
    }
}