package base;
import io.opentelemetry.api.internal.Utils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.logging.Logger;


public class BasePage {

    public static WebDriver driver;

    public static void setDriver(WebDriver driver) {
        BasePage.driver = driver;
    }

    protected WebElement find(By locator){
        return driver.findElement(locator);
    }

    protected void set(By locator, String text){
        find(locator).clear();
        find(locator).sendKeys(text);
    }

    protected void click(By locator){
        find(locator).click();
    }

    /**
     * Delay if needed for tester visualization
     */

    public static void delay(int milliseconds){
        try{
            Thread.sleep(milliseconds);
        } catch(InterruptedException exc){
            Logger.getLogger(Utils.class.getName()).warning("Thread sleep interrupted" + exc.getMessage());
            Thread.currentThread().interrupt();
        }
    }
}