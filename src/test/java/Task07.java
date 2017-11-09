import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class Task07 {
    private WebDriver driver;

    @Test
    public void linksAreOpened() {
        ChromeDriverManager.getInstance().setup();
        driver = new ChromeDriver();
        driver.get("http://localhost/litecart/admin");
        driver.findElement(By.name("username")).sendKeys("admin");
        driver.findElement(By.name("password")).sendKeys("admin");
        driver.findElement(By.name("login")).click();
        driver.get("http://localhost/litecart/admin/?app=countries&doc=countries");
        driver.findElement(By.xpath("//*[@id=\"content\"]/div/a")).click();

        List<WebElement> els = driver.findElements(By.xpath("//*[contains(@class, 'fa fa-external-link')]"));
        for (WebElement el: els
             ) {
            WebDriverWait wait = new WebDriverWait(driver, 10);
            driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
            String originalW = driver.getWindowHandle();
            Set<String> existWs = driver.getWindowHandles();
            el.click();
            String newW = wait.until(anyWindowOtherThan(existWs));
            driver.switchTo().window(newW);
            driver.close();
            driver.switchTo().window(originalW);
        }
    }

    @After
    public void stop(){
        driver.quit();
    }

    private ExpectedCondition<String> anyWindowOtherThan(Set<String> windows) {
        return (WebDriver input) -> {
            Set<String> handles = driver.getWindowHandles();
            handles.removeAll(windows);
            return handles.size() > 0 ? handles.iterator().next() : null;
        };
    }
}
