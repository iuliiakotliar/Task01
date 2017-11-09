import io.github.bonigarcia.wdm.ChromeDriverManager;
import io.github.bonigarcia.wdm.FirefoxDriverManager;
import io.github.bonigarcia.wdm.InternetExplorerDriverManager;
import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class Task01 {

    private WebDriver driver;

    @Test
    public void googleTest(){
        ChromeDriverManager.getInstance().setup();
        driver = new ChromeDriver();
        driver.get("http://google.com");
    }

    @Test
    public void firefoxTest(){
        FirefoxDriverManager.getInstance().setup();
        driver= new FirefoxDriver();
        driver.get("http://google.com");
    }

    @Test
    public void IETest(){
        InternetExplorerDriverManager.getInstance().setup();
        driver = new InternetExplorerDriver();
        driver.get("http://google.com");
    }

    @After
    public void stop(){
        driver.quit();
    }
}
