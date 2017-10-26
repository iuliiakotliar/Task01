import io.github.bonigarcia.wdm.ChromeDriverManager;
import io.github.bonigarcia.wdm.FirefoxDriverManager;
import io.github.bonigarcia.wdm.InternetExplorerDriverManager;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import java.util.concurrent.TimeUnit;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;

public class Task04 {

    @Test
    public void chromeTest() {
        //create driver
        ChromeDriverManager.getInstance().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://localhost/litecart");
        //get all the needed attributes' values on the main page
        String productNameMP = driver.findElement(By.xpath("//*[@id=\"box-campaigns\"]/div/ul/li/a[1]/div[2]")).getAttribute("textContent");
        String regularPriceMP = driver.findElement(By.xpath("//*[@id=\"box-campaigns\"]/div/ul/li/a[1]/div[4]/s")).getAttribute("textContent");
        String discountPriceMP = driver.findElement(By.xpath("//*[@id=\"box-campaigns\"]/div/ul/li/a[1]/div[4]/strong")).getAttribute("textContent");
        String regularPriceColorMP = driver.findElement(By.xpath("//*[@id=\"box-campaigns\"]/div/ul/li/a[1]/div[4]/s")).getCssValue("color");
        String regularPriceStrikeThroughMP = driver.findElement(By.xpath("//*[@id=\"box-campaigns\"]/div/ul/li/a[1]/div[4]/s")).getCssValue("text-decoration");
        String discountPriceColorMP = driver.findElement(By.xpath("//*[@id=\"box-campaigns\"]/div/ul/li/a[1]/div[4]/strong")).getCssValue("color");
        String discountPriceBoldMP = driver.findElement(By.xpath("//*[@id=\"box-campaigns\"]/div/ul/li/a[1]/div[4]/strong")).getCssValue("font-weight");
        //click on the item
        driver.findElement(By.xpath("//*[@id=\"box-campaigns\"]/div/ul/li/a[1]/div[1]/img")).click();
        //get all the needed attributes' values on the item page
        String productNameIP = driver.findElement(By.xpath("//*[@id=\"box-product\"]/div[1]/h1")).getAttribute("textContent");
        String regularPriceIP = driver.findElement(By.xpath("//*[@id=\"box-product\"]/div[2]/div[2]/div[2]/s")).getAttribute("textContent");
        String discountPriceIP = driver.findElement(By.xpath("//*[@id=\"box-product\"]/div[2]/div[2]/div[2]/strong")).getAttribute("textContent");
        String regularPriceColorIP = driver.findElement(By.xpath("//*[@id=\"box-product\"]/div[2]/div[2]/div[2]/s")).getCssValue("color");
        String regularPriceStrikeThroughIP = driver.findElement(By.xpath("//*[@id=\"box-product\"]/div[2]/div[2]/div[2]/s")).getCssValue("text-decoration");
        String discountPriceColorIP = driver.findElement(By.xpath("//*[@id=\"box-product\"]/div[2]/div[2]/div[2]/strong")).getCssValue("color");
        String discountPriceBoldIP = driver.findElement(By.xpath("//*[@id=\"box-product\"]/div[2]/div[2]/div[2]/strong")).getCssValue("font-weight");

        assertEquals(productNameMP, productNameIP);
        assertEquals(regularPriceMP, regularPriceIP);
        assertEquals(discountPriceMP, discountPriceIP);
        assertEquals("rgba(119, 119, 119, 1)", regularPriceColorMP);
        assertEquals("rgba(102, 102, 102, 1)", regularPriceColorIP);
        assertTrue(regularPriceStrikeThroughMP.contains("line-through"));
        assertTrue(regularPriceStrikeThroughIP.contains("line-through"));
        assertEquals(discountPriceColorMP, discountPriceColorIP);
        assertEquals(discountPriceBoldMP, discountPriceBoldIP);

        driver.quit();
    }

    @Test
    public void firefoxTest(){
        //create driver
        FirefoxDriverManager.getInstance().setup();
        WebDriver driver = new FirefoxDriver();
        driver.get("http://localhost/litecart");
        //get all the needed attributes' values on the main page
        String productNameMP = driver.findElement(By.xpath("//*[@id=\"box-campaigns\"]/div/ul/li/a[1]/div[2]")).getAttribute("textContent");
        String regularPriceMP = driver.findElement(By.xpath("//*[@id=\"box-campaigns\"]/div/ul/li/a[1]/div[4]/s")).getAttribute("textContent");
        String discountPriceMP = driver.findElement(By.xpath("//*[@id=\"box-campaigns\"]/div/ul/li/a[1]/div[4]/strong")).getAttribute("textContent");
        String regularPriceColorMP = driver.findElement(By.xpath("//*[@id=\"box-campaigns\"]/div/ul/li/a[1]/div[4]/s")).getCssValue("color");
        String regularPriceStrikeThroughMP = driver.findElement(By.xpath("//*[@id=\"box-campaigns\"]/div/ul/li/a[1]/div[4]/s")).getCssValue("text-decoration");
        String discountPriceColorMP = driver.findElement(By.xpath("//*[@id=\"box-campaigns\"]/div/ul/li/a[1]/div[4]/strong")).getCssValue("color");
        String discountPriceBoldMP = driver.findElement(By.xpath("//*[@id=\"box-campaigns\"]/div/ul/li/a[1]/div[4]/strong")).getCssValue("font-weight");
        //click on the item
        driver.findElement(By.xpath("//*[@id=\"box-campaigns\"]/div/ul/li/a[1]/div[1]/img")).click();
        //get all the needed attributes' values on the item page
        String productNameIP = driver.findElement(By.xpath("//*[@id=\"box-product\"]/div[1]/h1")).getAttribute("textContent");
        String regularPriceIP = driver.findElement(By.xpath("//*[@id=\"box-product\"]/div[2]/div[2]/div[2]/s")).getAttribute("textContent");
        String discountPriceIP = driver.findElement(By.xpath("//*[@id=\"box-product\"]/div[2]/div[2]/div[2]/strong")).getAttribute("textContent");
        String regularPriceColorIP = driver.findElement(By.xpath("//*[@id=\"box-product\"]/div[2]/div[2]/div[2]/s")).getCssValue("color");
        String regularPriceStrikeThroughIP = driver.findElement(By.xpath("//*[@id=\"box-product\"]/div[2]/div[2]/div[2]/s")).getCssValue("text-decoration");
        String discountPriceColorIP = driver.findElement(By.xpath("//*[@id=\"box-product\"]/div[2]/div[2]/div[2]/strong")).getCssValue("color");
        String discountPriceBoldIP = driver.findElement(By.xpath("//*[@id=\"box-product\"]/div[2]/div[2]/div[2]/strong")).getCssValue("font-weight");

        assertEquals(productNameMP, productNameIP);
        assertEquals(regularPriceMP, regularPriceIP);
        assertEquals(discountPriceMP, discountPriceIP);
        assertEquals("rgb(119, 119, 119)", regularPriceColorMP);
        assertEquals("rgb(102, 102, 102)", regularPriceColorIP);
        assertTrue(regularPriceStrikeThroughMP.contains("line-through"));
        assertTrue(regularPriceStrikeThroughIP.contains("line-through"));
        assertEquals(discountPriceColorMP, discountPriceColorIP);
        assertTrue(Integer.parseInt(discountPriceBoldMP) >= 600);
        assertTrue(Integer.parseInt(discountPriceBoldIP) >= 600);

        driver.quit();
    }

    @Test
    public void IETest(){
        //create driver
        InternetExplorerDriverManager.getInstance().setup();
        WebDriver driver = new InternetExplorerDriver();
        driver.get("http://localhost/litecart");
        //get all the needed attributes' values on the main page
        String productNameMP = driver.findElement(By.xpath("//*[@id=\"box-campaigns\"]/div/ul/li/a[1]/div[2]")).getAttribute("textContent");
        String regularPriceMP = driver.findElement(By.xpath("//*[@id=\"box-campaigns\"]/div/ul/li/a[1]/div[4]/s")).getAttribute("textContent");
        String discountPriceMP = driver.findElement(By.xpath("//*[@id=\"box-campaigns\"]/div/ul/li/a[1]/div[4]/strong")).getAttribute("textContent");
        String regularPriceColorMP = driver.findElement(By.xpath("//*[@id=\"box-campaigns\"]/div/ul/li/a[1]/div[4]/s")).getCssValue("color");
        String regularPriceStrikeThroughMP = driver.findElement(By.xpath("//*[@id=\"box-campaigns\"]/div/ul/li/a[1]/div[4]/s")).getCssValue("text-decoration");
        String discountPriceColorMP = driver.findElement(By.xpath("//*[@id=\"box-campaigns\"]/div/ul/li/a[1]/div[4]/strong")).getCssValue("color");
        String discountPriceBoldMP = driver.findElement(By.xpath("//*[@id=\"box-campaigns\"]/div/ul/li/a[1]/div[4]/strong")).getCssValue("font-weight");
        //click on the item
        driver.findElement(By.xpath("//*[@id=\"box-campaigns\"]/div/ul/li/a[1]/div[1]/img")).click();
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        //get all the needed attributes' values on the item page
        String productNameIP = driver.findElement(By.xpath("//*[@id=\"box-product\"]/div[1]/h1")).getAttribute("textContent");
        String regularPriceIP = driver.findElement(By.xpath("//*[@id=\"box-product\"]/div[2]/div[2]/div[2]/s")).getAttribute("textContent");
        String discountPriceIP = driver.findElement(By.xpath("//*[@id=\"box-product\"]/div[2]/div[2]/div[2]/strong")).getAttribute("textContent");
        String regularPriceColorIP = driver.findElement(By.xpath("//*[@id=\"box-product\"]/div[2]/div[2]/div[2]/s")).getCssValue("color");
        String regularPriceStrikeThroughIP = driver.findElement(By.xpath("//*[@id=\"box-product\"]/div[2]/div[2]/div[2]/s")).getCssValue("text-decoration");
        String discountPriceColorIP = driver.findElement(By.xpath("//*[@id=\"box-product\"]/div[2]/div[2]/div[2]/strong")).getCssValue("color");
        String discountPriceBoldIP = driver.findElement(By.xpath("//*[@id=\"box-product\"]/div[2]/div[2]/div[2]/strong")).getCssValue("font-weight");

        assertEquals(productNameMP, productNameIP);
        assertEquals(regularPriceMP, regularPriceIP);
        assertEquals(discountPriceMP, discountPriceIP);
        assertEquals("rgba(119, 119, 119, 1)", regularPriceColorMP);
        assertEquals("rgba(102, 102, 102, 1)", regularPriceColorIP);
        assertTrue(regularPriceStrikeThroughMP.contains("line-through"));
        assertTrue(regularPriceStrikeThroughIP.contains("line-through"));
        assertEquals(discountPriceColorMP, discountPriceColorIP);
        assertTrue(Integer.parseInt(discountPriceBoldMP) >= 600);
        assertTrue(Integer.parseInt(discountPriceBoldIP) >= 600);

        driver.quit();
    }
}
