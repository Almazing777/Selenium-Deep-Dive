import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ActionsAjax {
    public static void main(String[] args){
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.amazon.com/");
        driver.manage().window().maximize();

        Actions a = new Actions(driver);
        WebElement move = driver.findElement(By.cssSelector("a[id='nav-link-accountList']"));

        a.moveToElement(driver.findElement(By.id("twotabsearchtextbox"))).click().keyDown(Keys.SHIFT).sendKeys("hello").doubleClick().build().perform();
        //moves to specific element
        a.moveToElement(move).contextClick().build().perform();

    }
}
