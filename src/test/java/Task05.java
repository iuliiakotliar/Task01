import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import java.io.File;

import static org.junit.Assert.assertTrue;

public class Task05 {
    public WebDriver driver;

    @Test
    public void addItem(){
        ChromeDriverManager.getInstance().setup();
        driver = new ChromeDriver();
        driver.get("http://localhost/litecart/admin");
        driver.findElement(By.xpath("//*[@id=\"box-login\"]//tr[1]/td[2]/span/input")).sendKeys("admin");
        driver.findElement(By.xpath("//*[@id=\"box-login\"]//tr[2]/td[2]/span/input")).sendKeys("admin");
        driver.findElement(By.xpath("//*[@id=\"box-login\"]//button")).click();
        driver.findElement(By.xpath("//*[@id='app-'][2]/a/span")).click();
        driver.findElement(By.xpath("//*[@id=\"content\"]/div[1]/a[2]/i")).click();
        //general tab
        driver.findElement(By.xpath("//*[@id=\"tab-general\"]//input")).click();
        driver.findElement(By.xpath("//*[@id=\"tab-general\"]//span/input")).sendKeys("My Duck");
        driver.findElement(By.xpath("//*[@id=\"tab-general\"]//td/input")).sendKeys("007");
        driver.findElement(By.xpath("//*[@id=\"tab-general\"]//tr[2]/td[1]/input")).click();
        new Select(driver.findElement(By.xpath("//*[@id=\"tab-general\"]//tr[5]/td/select"))).selectByVisibleText("Rubber Ducks");
        driver.findElement(By.xpath("//*[@id=\"tab-general\"]//tr[7]/td/div/table/tbody/tr[2]/td[1]/input")).click();
        driver.findElement(By.xpath("//*[@id=\"tab-general\"]//tr[8]/td/table/tbody/tr/td[1]/input")).clear();
        driver.findElement(By.xpath("//*[@id=\"tab-general\"]//tr[8]/td/table/tbody/tr/td[1]/input")).sendKeys("77");
        new Select(driver.findElement(By.xpath("//*[@id='tab-general']//tr[8]/td/table/tbody/tr/td[2]/select"))).selectByVisibleText("pcs");
        new Select(driver.findElement(By.xpath("//*[@id='tab-general']//tr[8]/td/table/tbody/tr/td[3]/select"))).selectByVisibleText("3-5 days");
        new Select(driver.findElement(By.xpath("//*[@id='tab-general']//tr[8]/td/table/tbody/tr/td[4]/select"))).selectByVisibleText("Temporary sold out");
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource("mondrian.jpg").getFile());
        WebElement fileField = driver.findElement(By.name("new_images[]"));
        fileField.sendKeys(file.getAbsolutePath());
        driver.findElement(By.xpath("//*[@id=\"tab-general\"]//tr[10]/td/input")).sendKeys("11/01/2017");
        driver.findElement(By.xpath("//*[@id=\"tab-general\"]//tr[11]/td/input")).sendKeys("11/01/2018");
        //information tab
        driver.findElement(By.xpath("//*[@id=\"content\"]//li[2]/a")).click();
        new Select(driver.findElement(By.xpath("//*[@id=\"tab-information\"]//tr[1]/td/select"))).selectByVisibleText("ACME Corp.");
        new Select(driver.findElement(By.xpath("//*[@id=\"tab-information\"]//tr[2]/td/select"))).selectByVisibleText("-- Select --");
        driver.findElement(By.xpath("//*[@id=\"tab-information\"]//tr[3]/td/input")).sendKeys("modern art, duck");
        driver.findElement(By.xpath("//*[@id=\"tab-information\"]//tr[4]/td/span/input")).sendKeys("Mondrian duck");
        driver.findElement(By.xpath("//*[@id=\"tab-information\"]//tr[5]/td/span/div/div[2]")).sendKeys("Piet Mondrian duck will make your bath time modern.");
        driver.findElement(By.xpath("//*[@id=\"tab-information\"]//tr[6]/td/span/input")).sendKeys("Mondrian duck");
        driver.findElement(By.xpath("//*[@id=\"tab-information\"]//tr[7]/td/span/input")).sendKeys("So meta");
        //prices tab
        driver.findElement(By.xpath("//*[@id=\"content\"]//li[4]/a")).click();
        driver.findElement(By.xpath("//*[@id=\"tab-prices\"]/table[1]/tbody/tr/td/input")).clear();
        driver.findElement(By.xpath("//*[@id=\"tab-prices\"]/table[1]/tbody/tr/td/input")).sendKeys("77.00");
        new Select(driver.findElement(By.xpath("//*[@id=\"tab-prices\"]/table[1]/tbody/tr/td/select"))).selectByVisibleText("Euros");
        new Select(driver.findElement(By.xpath("//*[@id=\"table-prices\"]/tbody/tr[1]/td/select"))).selectByVisibleText("-- Select --");
        driver.findElement(By.xpath("//*[@id=\"tab-prices\"]/table[3]/tbody/tr[2]/td[2]/input")).clear();
        driver.findElement(By.xpath("//*[@id=\"tab-prices\"]/table[3]/tbody/tr[2]/td[2]/input")).sendKeys("89.65");
        driver.findElement(By.xpath("//*[@id=\"tab-prices\"]/table[3]/tbody/tr[3]/td[2]/input")).clear();
        driver.findElement(By.xpath("//*[@id=\"tab-prices\"]/table[3]/tbody/tr[3]/td[2]/input")).sendKeys("77.00");
        driver.findElement(By.xpath("//*[@id=\"content\"]/form/p/span/button[1]")).click();
        Boolean isPresent = driver.findElements(By.linkText("My Duck")).size() > 0;

        assertTrue(isPresent);
    }

    @After
    public void stop(){
        driver.quit();
    }
}
