import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Framestest {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("http://jqueryui.com/droppable");
        driver.switchTo().frame(driver.findElement(By.cssSelector("iframe.demo-frame")));
        driver.findElement(By.id("draggable")).click();

        Actions s = new Actions(driver);
        WebElement source = driver.findElement(By.id("draggable"));
        WebElement target = driver.findElement(By.id("droppable"));
        s.dragAndDrop(source, target).build().perform();
    }
}