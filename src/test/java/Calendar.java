import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class Calendar {
    public static void main(String[] args){
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.orbitz.com/");
        driver.findElement(By.cssSelector("[id='package-departing-hp-package']")).click();


        List<WebElement> dates = driver.findElements(By.className(".datepicker-cal-date"));

        for (int i = 0; i < dates.size(); i++) {

            String text = driver.findElements(By.className(".datepicker-cal-date")).get(i).getText();

            if(!dates.get(i).getAttribute("class").equals("datepicker-cal-date disabled")){
                if(dates.get(i).getAttribute("data-day").equalsIgnoreCase("28")){
                    driver.findElements(By.cssSelector(".datapicker-cal-date")).get(i).click();
                    break;
                }
            }
        }
    }
}
