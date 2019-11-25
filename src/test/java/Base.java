import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Base {

    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();

        String[] itemsNeeded = {"Cucumber", "Brocolli", "Beetroot", "Carrot"};

        driver.get("https://rahulshettyacademy.com/seleniumPractise/");
//        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        WebDriverWait w = new WebDriverWait(driver, 5);

        addItems(driver, itemsNeeded); //Utility Added (refactored)

        driver.findElement(By.cssSelector("[class='cart-icon'] img")).click();
        driver.findElement(By.cssSelector("[class='action-block'] button")).click();
        w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input.promoCode")));

        driver.findElement(By.cssSelector("[class='promoCode']")).sendKeys("rahulshettyacademy");
        driver.findElement(By.cssSelector("[class='promoBtn']")).click();


        w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[class='promoInfo']")));

        System.out.println(driver.findElement(By.cssSelector("[class='promoInfo']")).getText());

//        String successMessage = "Promo code applied successfully!";
//        Assert.assertEquals(successMessage, "Promo code applied successfully!");

        }

        @Test
        public static void addItems(WebDriver driver, String[] itemsNeeded){
            int j = 0;

            List<WebElement> products = driver.findElements(By.cssSelector("h4.product-name"));
            for (int i = 0; i <products.size() ; i++) {

                String[] name = products.get(i).getText().split("-");
                String formattedName = name[0].trim();

                //check weather name you extracted is present or not
                //convert array into arraylist for easy search
                List itemsNeededList = Arrays.asList(itemsNeeded);

                if(itemsNeededList.contains(formattedName)){
                    j++;
                    driver.findElements(By.cssSelector("[class='product-action'] button")).get(i).click();
                    if(j == itemsNeeded.length){ break;}
                }
            }
        }
}
