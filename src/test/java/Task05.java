import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import java.io.File;
import java.sql.Timestamp;

import static org.junit.Assert.assertTrue;

public class Task05 {
    private WebDriver driver;

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

        String duckName = "My Duck" + new Timestamp(System.currentTimeMillis());

        //general tab
        driver.findElement(By.xpath("//*[@id=\"tab-general\"]//input")).click();
        driver.findElement(By.name("name[en]")).sendKeys(duckName);
        driver.findElement(By.name("code")).sendKeys("007");
        driver.findElement(By.xpath("//*[@id=\"tab-general\"]//tr[2]/td[1]/input")).click();
        new Select(driver.findElement(By.name("default_category_id"))).selectByVisibleText("Rubber Ducks");
        driver.findElement(By.name("product_groups[]")).click();
        driver.findElement(By.name("quantity")).clear();
        driver.findElement(By.name("quantity")).sendKeys("77");
        new Select(driver.findElement(By.name("quantity_unit_id"))).selectByVisibleText("pcs");
        new Select(driver.findElement(By.name("delivery_status_id"))).selectByVisibleText("3-5 days");
        new Select(driver.findElement(By.name("sold_out_status_id"))).selectByVisibleText("Temporary sold out");
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource("mondrian.jpg").getFile());
        WebElement fileField = driver.findElement(By.name("new_images[]"));
        fileField.sendKeys(file.getAbsolutePath());
        driver.findElement(By.name("date_valid_from")).sendKeys("11/01/2017");
        driver.findElement(By.name("date_valid_to")).sendKeys("11/01/2018");

        //information tab
        driver.findElement(By.xpath("//*[@id=\"content\"]//li[2]/a")).click();
        new Select(driver.findElement(By.name("manufacturer_id"))).selectByVisibleText("ACME Corp.");
        new Select(driver.findElement(By.name("supplier_id"))).selectByVisibleText("-- Select --");
        driver.findElement(By.name("keywords")).sendKeys("modern art, duck");
        driver.findElement(By.name("short_description[en]")).sendKeys("Mondrian duck");
        driver.findElement(By.className("trumbowyg-editor")).sendKeys("Piet Mondrian duck will make your bath time modern.");
        driver.findElement(By.name("head_title[en]")).sendKeys("Mondrian duck");
        driver.findElement(By.name("meta_description[en]")).sendKeys("So meta");

        //prices tab
        driver.findElement(By.xpath("//*[@id=\"content\"]//li[4]/a")).click();
        driver.findElement(By.name("purchase_price")).clear();
        driver.findElement(By.name("purchase_price")).sendKeys("77.00");
        new Select(driver.findElement(By.name("purchase_price_currency_code"))).selectByVisibleText("Euros");
        new Select(driver.findElement(By.name("tax_class_id"))).selectByVisibleText("-- Select --");
        driver.findElement(By.name("gross_prices[USD]")).clear();
        driver.findElement(By.name("gross_prices[USD]")).sendKeys("89.65");
        driver.findElement(By.name("gross_prices[EUR]")).clear();
        driver.findElement(By.name("gross_prices[EUR]")).sendKeys("77.00");

        driver.findElement(By.xpath("//*[@id=\"content\"]/form/p/span/button[1]")).click();
        Boolean isPresent = driver.findElements(By.linkText(duckName)).size() > 0;

        assertTrue(isPresent);
    }

    @After
    public void stop(){
        driver.quit();
    }
}
