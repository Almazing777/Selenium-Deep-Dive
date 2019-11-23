import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.util.Arrays;
import java.util.List;

public class base {

    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        //expected array
        int j = 0;

        String[] itemsNeeded = {"Cucumber", "Brocolli", "Beetroot"};

        driver.get("https://rahulshettyacademy.com/seleniumPractise/");
        Thread.sleep(500);

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
                if(j == 3){ break;}
            }
        }
    }
}
