import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.AbstractWebDriverEventListener;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import java.util.List;

import static org.junit.Assert.assertTrue;

public class Task08 {
    private static EventFiringWebDriver driver;

    @Test
    public void getEls() {
        //create driver
        ChromeDriverManager.getInstance().setup();
        driver = new EventFiringWebDriver(new ChromeDriver());
        driver.register(new EventsListener());
        driver.get("http://localhost/litecart/admin");
        //log into the admin area
        driver.findElement(By.name("username")).sendKeys("admin");
        driver.findElement(By.name("password")).sendKeys("admin");
        driver.findElement(By.name("login")).click();
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

    public static class EventsListener extends
            AbstractWebDriverEventListener {
        @Override
        public void beforeFindBy(By by, WebElement element, WebDriver driver){
            System.out.println(by);
        }

        @Override
        public void afterFindBy(By by, WebElement element, WebDriver driver){
            System.out.println(by + " found");
        }

        @Override
        public void onException(Throwable throwable, WebDriver driver){
            System.out.println(throwable);
        }

    }
}
