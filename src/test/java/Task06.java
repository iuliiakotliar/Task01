import io.github.bonigarcia.wdm.ChromeDriverManager;
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

    @Test
    public void cartOperation(){
        ChromeDriverManager.getInstance().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://localhost/litecart");
        addPopItem(driver);
        driver.findElement(By.xpath("//*[@id=\"cart\"]/a[3]")).click();
        removeEachItem(driver);
        driver.findElement(By.xpath("//*[@id=\"site-menu\"]/ul/li[1]/a")).click();
        String quantity = driver.findElement(By.cssSelector("#cart > a.content > span.quantity")).getAttribute("textContent");

        assertEquals("0", quantity);

        driver.quit();
    }

    private void addPopItem(WebDriver driver) {
        int iteration = 0;
        Integer counter = 1;
        while(iteration < 3){
            driver.findElement(By.xpath("//*[@id=\"box-most-popular\"]//img")).click();
            if (driver.findElements(By.className("options")).size() > 0){
                new Select(driver.findElement(By.xpath("//*[@id=\"box-product\"]/div[2]/div[2]/div[5]/form/table/tbody/tr[1]/td/select"))).selectByVisibleText("Small");
            }
            driver.findElement(By.xpath("//*[@id=\"box-product\"]/div[2]/div[2]/div[5]/form/table/tbody/tr/td/button")).click();
            WebDriverWait wait = new WebDriverWait(driver, 10);
            wait.until(ExpectedConditions.attributeToBe(driver.findElement(By.cssSelector("#cart > a.content > span.quantity")), "textContent", counter.toString()));
            driver.findElement(By.xpath("//*[@id=\"site-menu\"]/ul/li[1]/a")).click();
            iteration++;
            counter++;
        }
    }

    private void removeEachItem(WebDriver driver){
        WebDriverWait wait = new WebDriverWait(driver, 10);
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        List<WebElement> els = driver.findElements(By.xpath("//*[contains(@id, 'order_confirmation-wrapper')]"));

        while(els.size() > 0){
            WebElement element = driver.findElement(By.xpath("//*[@id=\"order_confirmation-wrapper\"]/table"));
            driver.findElement(By.xpath("//button[@name='remove_cart_item']")).click();
            wait.until(ExpectedConditions.stalenessOf(element));
            els = driver.findElements(By.xpath("//*[contains(@id, 'order_confirmation-wrapper')]"));
        }
    }
}
