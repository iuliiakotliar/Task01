import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.List;
import static org.junit.Assert.assertTrue;

public class Task03 {

    private WebDriver driver;

    @Test
    public void getEls() {
        //create driver
        ChromeDriverManager.getInstance().setup();
        driver = new ChromeDriver();
        driver.get("http://localhost/litecart/admin");
        //log into the admin area
        driver.findElement(By.xpath("//*[@id=\"box-login\"]//tr[1]/td[2]/span/input")).sendKeys("admin");
        driver.findElement(By.xpath("//*[@id=\"box-login\"]//tr[2]/td[2]/span/input")).sendKeys("admin");
        driver.findElement(By.xpath("//*[@id=\"box-login\"]//button")).click();
        int countEls = driver.findElements(By.xpath("//*[@id=\"app-\"]")).size();
        //iterate over menu items
        for (int i = 0; i <= countEls-1; i++) {
            List<WebElement> elements = driver.findElements(By.xpath("//*[@id=\"app-\"]"));
            elements.get(i).click();
            List<WebElement> els = driver.findElements(By.xpath("//*[contains(@id, 'doc-')]"));
            //if no submenus - check that page header is present
            if (els.size()==0){
                assertTrue(driver.findElements(By.tagName("H1")).size() > 0);
            }
            //iterate over submenu items and check that header is present for them
            for (int j = 0; j <= els.size()-1; j++) {
                List<WebElement> newEls = driver.findElements(By.xpath("//*[contains(@id, 'doc-')]"));
                newEls.get(j).click();
                assertTrue(driver.findElements(By.tagName("H1")).size() > 0);
            }
        }
    }

    @After
    public void stop(){
        driver.quit();
    }
}
