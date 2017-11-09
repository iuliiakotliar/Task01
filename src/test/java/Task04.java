import io.github.bonigarcia.wdm.ChromeDriverManager;
import io.github.bonigarcia.wdm.FirefoxDriverManager;
import io.github.bonigarcia.wdm.InternetExplorerDriverManager;
import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;

public class Task04 {

    private WebDriver driver;

    @Test
    public void chromeTest() {
        ChromeDriverManager.getInstance().setup();
        driver = new ChromeDriver();
        driver.get("http://localhost/litecart");
        List<String> els = getMainPageElements(driver);
        driver.findElement(By.xpath("//*[@id=\"box-campaigns\"]//img")).click();
        List<String> elsItem = getItemPageElements(driver);

        assertEquals(els.get(0), elsItem.get(0));
        assertEquals(els.get(1), elsItem.get(1));
        assertEquals(els.get(2), elsItem.get(2));
        assertEquals("rgba(119, 119, 119, 1)", els.get(3));
        assertEquals("rgba(102, 102, 102, 1)", elsItem.get(3));
        assertTrue(els.get(4).contains("line-through"));
        assertTrue(elsItem.get(4).contains("line-through"));
        assertEquals(els.get(5), elsItem.get(5));
        assertEquals(els.get(6), elsItem.get(6));
    }

    @Test
    public void firefoxTest() {
        FirefoxDriverManager.getInstance().setup();
        driver = new FirefoxDriver();
        driver.get("http://localhost/litecart");
        List<String> els = getMainPageElements(driver);
        driver.findElement(By.xpath("//*[@id=\"box-campaigns\"]/div/ul/li/a[1]/div[1]/img")).click();
        List<String> elsItem = getItemPageElements(driver);

        assertEquals(els.get(0), elsItem.get(0));
        assertEquals(els.get(1), elsItem.get(1));
        assertEquals(els.get(2), elsItem.get(2));
        assertEquals("rgb(119, 119, 119)", els.get(3));
        assertEquals("rgb(102, 102, 102)", elsItem.get(3));
        assertTrue(els.get(4).contains("line-through"));
        assertTrue(elsItem.get(4).contains("line-through"));
        assertEquals(els.get(5), elsItem.get(5));
        assertTrue(Integer.parseInt(els.get(6)) >= 600);
        assertTrue(Integer.parseInt(elsItem.get(6)) >= 600);
    }

    @Test
    public void IETest() {
        InternetExplorerDriverManager.getInstance().setup();
        driver = new InternetExplorerDriver();
        driver.get("http://localhost/litecart");
        List<String> els = getMainPageElements(driver);
        driver.findElement(By.xpath("//*[@id=\"box-campaigns\"]/div/ul/li/a[1]/div[1]/img")).click();
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        List<String> elsItem = getItemPageElements(driver);

        assertEquals(els.get(0), elsItem.get(0));
        assertEquals(els.get(1), elsItem.get(1));
        assertEquals(els.get(2), elsItem.get(2));
        assertEquals("rgba(119, 119, 119, 1)", els.get(3));
        assertEquals("rgba(102, 102, 102, 1)", elsItem.get(3));
        assertTrue(els.get(4).contains("line-through"));
        assertTrue(elsItem.get(4).contains("line-through"));
        assertEquals(els.get(5), elsItem.get(5));
        assertTrue(Integer.parseInt(els.get(6)) >= 600);
        assertTrue(Integer.parseInt(elsItem.get(6)) >= 600);

    }

    @After
    public void stop(){
        driver.quit();
    }

    private List<String> getMainPageElements(WebDriver driver) {
        WebElement nameMain = driver.findElement(By.xpath("//*[@id='box-campaigns']//div[2]"));
        WebElement regularPriceMain = driver.findElement(By.xpath("//*[@id='box-campaigns']//s"));
        WebElement discountPriceMain = driver.findElement(By.xpath("//*[@id='box-campaigns']//strong"));
        String productNameMP = nameMain.getAttribute("textContent");
        String regularPriceMP = regularPriceMain.getAttribute("textContent");
        String discountPriceMP = discountPriceMain.getAttribute("textContent");
        String regularPriceColorMP = regularPriceMain.getCssValue("color");
        String regularPriceStrikeThroughMP = regularPriceMain.getCssValue("text-decoration");
        String discountPriceColorMP = discountPriceMain.getCssValue("color");
        String discountPriceBoldMP = discountPriceMain.getCssValue("font-weight");
        return Arrays.asList(productNameMP, regularPriceMP, discountPriceMP, regularPriceColorMP, regularPriceStrikeThroughMP, discountPriceColorMP, discountPriceBoldMP);
    }

    private List<String> getItemPageElements(WebDriver driver) {
        WebElement nameItem = driver.findElement(By.xpath("//*[@id=\"box-product\"]//h1"));
        WebElement regularPriceItem = driver.findElement(By.xpath("//*[@id=\"box-product\"]//s"));
        WebElement discountPriceItem = driver.findElement(By.xpath("//*[@id=\"box-product\"]//strong"));
        String productNameIP = nameItem.getAttribute("textContent");
        String regularPriceIP = regularPriceItem.getAttribute("textContent");
        String discountPriceIP = discountPriceItem.getAttribute("textContent");
        String regularPriceColorIP = regularPriceItem.getCssValue("color");
        String regularPriceStrikeThroughIP = regularPriceItem.getCssValue("text-decoration");
        String discountPriceColorIP = discountPriceItem.getCssValue("color");
        String discountPriceBoldIP = discountPriceItem.getCssValue("font-weight");
        return Arrays.asList(productNameIP, regularPriceIP, discountPriceIP, regularPriceColorIP, regularPriceStrikeThroughIP, discountPriceColorIP, discountPriceBoldIP);
    }
}
