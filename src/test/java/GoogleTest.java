import io.github.bonigarcia.wdm.ChromeDriverManager;
import io.github.bonigarcia.wdm.FirefoxDriverManager;
import io.github.bonigarcia.wdm.InternetExplorerDriverManager;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class GoogleTest {

    @Test
    public void googleTest(){
        ChromeDriverManager.getInstance().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://google.com");
        driver.quit();
    }

    @Test
    public void firefoxTest(){
        FirefoxDriverManager.getInstance().setup();
        WebDriver driver= new FirefoxDriver();
        driver.get("http://google.com");
        driver.quit();
    }

    @Test
    public void IETest(){
        InternetExplorerDriverManager.getInstance().setup();
        WebDriver driver = new InternetExplorerDriver();
        driver.get("http://google.com");
        driver.quit();
    }
}
