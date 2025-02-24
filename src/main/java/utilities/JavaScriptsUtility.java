package utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class JavaScriptsUtility extends Utility {

    public static void scrollToElementJS(By locator){
        WebElement element = driver.findElement(locator);
        String jsScrip = "arguments[0].scrollIntoView";
        ((JavascriptExecutor)driver).executeScript(jsScrip, element);
    }

    public static void clickJS(By locator){
        WebElement element = driver.findElement(locator);
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", element);
    }

    private static Select findDropDown(By locator){
        return new Select(driver.findElement(locator));
    }

    public static void selectByVisibleText(By locator, String userSelection){
        findDropDown(locator).selectByVisibleText(userSelection);
    }
}
