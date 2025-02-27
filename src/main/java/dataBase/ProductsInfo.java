package dataBase;

public class ProductsInfo extends WebsiteData{

    /**
     * All Products in Ecommerce website.
     */

    private final String[] originalProductsNames;

    public ProductsInfo(){
        this.originalProductsNames = new String[]{"Sauce Labs Fleece Jacket", "Sauce Labs Backpack",
                "Sauce Labs Bolt T-Shirt","Sauce Labs Bike Light",
                "Sauce Labs Onesie", "Test.allTheThings() T-Shirt (Red)"};
    }

    public String[] getOriginalProductsNames(){
        return originalProductsNames;
    }
}