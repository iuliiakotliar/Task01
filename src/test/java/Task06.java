import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.List;
import java.util.concurrent.TimeUnit;
import static org.junit.Assert.assertEquals;

public class Task06 {

    private WebDriver driver;

    @Test
    public void cartOperation(){
        ChromeDriverManager.getInstance().setup();
        driver = new ChromeDriver();
        driver.get("http://localhost/litecart");
        addPopItem();
        driver.findElement(By.xpath("//*[@id=\"cart\"]/a[3]")).click();
        removeEachItem();
        driver.findElement(By.xpath("//*[@id=\"site-menu\"]/ul/li[1]/a")).click();
        String quantity = driver.findElement(By.cssSelector("#cart > a.content > span.quantity")).getAttribute("textContent");

        assertEquals("0", quantity);
    }

    @After
    public void stop(){
        driver.quit();
    }

    private void addPopItem() {
        int iteration = 0;
        Integer counter = 1;
        while(iteration < 3){
            driver.findElement(By.xpath("//*[@id=\"box-most-popular\"]//img")).click();
            if (driver.findElements(By.className("options")).size() > 0){
                new Select(driver.findElement(By.name("options[Size]"))).selectByVisibleText("Small");
            }
            driver.findElement(By.name("add_cart_product")).click();
            WebDriverWait wait = new WebDriverWait(driver, 10);
            wait.until(ExpectedConditions.attributeToBe(driver.findElement(By.className("quantity")), "textContent", counter.toString()));
            driver.findElement(By.xpath("//*[@id=\"site-menu\"]/ul/li[1]/a")).click();
            iteration++;
            counter++;
        }
    }

    private void removeEachItem(){
        WebDriverWait wait = new WebDriverWait(driver, 10);
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        List<WebElement> els = driver.findElements(By.xpath("//*[contains(@id, 'order_confirmation-wrapper')]"));

        while(els.size() > 0){
            WebElement element = driver.findElement(By.id("order_confirmation-wrapper"));
            driver.findElement(By.name("remove_cart_item")).click();
            wait.until(ExpectedConditions.stalenessOf(element));
            els = driver.findElements(By.xpath("//*[contains(@id, 'order_confirmation-wrapper')]"));
        }
    }
}
