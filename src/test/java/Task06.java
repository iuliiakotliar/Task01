//import io.github.bonigarcia.wdm.ChromeDriverManager;
//import org.junit.Test;
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.support.ui.Select;
//import org.openqa.selenium.support.ui.WebDriverWait;
//
//import java.util.concurrent.TimeUnit;
//
//public class Task06 {
//
//    @Test
//    public void cartOperation(){
//        ChromeDriverManager.getInstance().setup();
//        WebDriver driver = new ChromeDriver();
//        driver.get("http://localhost/litecart");
//        addPopItem(driver);
//        //addPopItem(driver);
//        //addPopItem(driver);
//
//    }
//
//    private void addPopItem(WebDriver driver) {
//        driver.findElement(By.xpath("//*[@id=\"box-most-popular\"]//img")).click();
//        if (driver.select){
//            new Select(driver.findElement(By.xpath("//*[@id=\"box-product\"]/div[2]/div[2]/div[5]/form/table/tbody/tr[1]/td/select"))).selectByVisibleText("Small");
//        }
//        driver.findElement(By.xpath("//*[@id=\"box-product\"]/div[2]/div[2]/div[5]/form/table/tbody/tr/td/button")).click();wait();
//        WebDriverWait wait = new WebDriverWait(driver, 10);
//        WebElement element = wait.until()
//
//        //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//        driver.findElement(By.xpath("//*[@id=\"site-menu\"]/ul/li[1]/a")).click();
////        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
//    }
//}
