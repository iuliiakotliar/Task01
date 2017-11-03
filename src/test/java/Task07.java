import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Task07 {
    @Test
    public void linksAreOpened() {
        ChromeDriverManager.getInstance().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://localhost/litecart/admin");
        driver.findElement(By.xpath("//*[@id='box-login']//tr[1]/td[2]/span/input")).sendKeys("admin");
        driver.findElement(By.xpath("//*[@id='box-login']//tr[2]/td[2]/span/input")).sendKeys("admin");
        driver.findElement(By.xpath("//*[@id='box-login']//button")).click();
        driver.get("http://localhost/litecart/admin/?app=countries&doc=countries");
    }
}
