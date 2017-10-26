import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.List;
import static org.junit.Assert.assertTrue;

public class Task03 {
    @Test
    public void getEls() {
        //create driver
        ChromeDriverManager.getInstance().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://localhost/litecart/admin");
        //log into the admin area
        driver.findElement(By.xpath("//*[@id=\"box-login\"]/form/div[1]/table/tbody/tr[1]/td[2]/span/input")).sendKeys("admin");
        driver.findElement(By.xpath("//*[@id=\"box-login\"]/form/div[1]/table/tbody/tr[2]/td[2]/span/input")).sendKeys("admin");
        driver.findElement(By.xpath("//*[@id=\"box-login\"]/form/div[2]/button")).click();
        //iterate over menu items
        for (int i = 0; i <= 16; i++) {
            List<WebElement> elements = driver.findElements(By.xpath("//*[@id=\"app-\"]"));
            elements.get(i).click();
            List<WebElement> els = driver.findElements(By.xpath("//*[contains(@id, 'doc-')]"));
            //if no submenus - check that page header is present
            if (els.size()==0){
                Boolean isPresent = driver.findElements(By.tagName("H1")).size() > 0;
                assertTrue(isPresent);
            }
            //iterate over submenu items and check that header is present for them
            for (int j = 0; j <= els.size()-1; j++) {
                List<WebElement> newEls = driver.findElements(By.xpath("//*[contains(@id, 'doc-')]"));
                newEls.get(j).click();
                Boolean isPresent = driver.findElements(By.tagName("H1")).size() > 0;
                assertTrue(isPresent);
            }
        }
        driver.quit();
    }
}
