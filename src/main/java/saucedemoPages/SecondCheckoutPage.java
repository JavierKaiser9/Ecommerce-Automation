package saucedemoPages;

import base.BasePage;
import org.openqa.selenium.By;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SecondCheckoutPage extends BasePage {

    private By cartList = By.xpath("//div[@class='cart_list']");
    private By subTotal = By.xpath("//div[@class='summary_subtotal_label']");
    private By purchaseTotal = By.xpath("//div[@class='summary_total_label']");


    public String getProductsListInformation(){
        return find(cartList).getText();
    }

    public String calculateSubTotal(String list){
        BigDecimal totalValue= BigDecimal.ZERO;
        Pattern pricePattern = Pattern.compile("\\$(\\d+\\.\\d{2})"); // Format $XX.XX
        Matcher matcher = pricePattern.matcher(list);
        while (matcher.find()){
            BigDecimal price = new BigDecimal(matcher.group(1));
            totalValue = totalValue.add(price);
        }
        // Apply 8% Tax
        BigDecimal taxRate = new BigDecimal("0.08");
        BigDecimal totalWithTax = totalValue.multiply(BigDecimal.ONE.add(taxRate));

        // Correct presentation format
        totalWithTax = totalWithTax.setScale(2, RoundingMode.HALF_UP);
        return totalWithTax.toString();
    }

    public String getDisplayedSubtotal(){
        return find(subTotal).getText();
    }

    public String getDisplayedTotal(){
        Pattern pattern = Pattern.compile("\\d+\\.\\d{2}");
        Matcher matcher = pattern.matcher(find(purchaseTotal).getText());

        if(matcher.find()){
            return matcher.group(); // Extract only the numbers uf the String
        }
        return "No value detected";
    }

}
