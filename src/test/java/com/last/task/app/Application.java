package com.last.task.app;

import com.last.task.pages.CheckoutPage;
import com.last.task.pages.HomePage;
import com.last.task.pages.ItemPage;
import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;

public class Application {

    private WebDriver driver;

    public CheckoutPage checkoutPage;
    public HomePage homePage;
    public ItemPage itemPage;

    public Application(){
        ChromeDriverManager.getInstance().setup();
        driver = new ChromeDriver();
        checkoutPage = new CheckoutPage(driver);
        homePage = new HomePage(driver);
        itemPage = new ItemPage(driver);
    }

    public  void quit(){
        driver.quit();
    }

    public void addPopItem(Integer counter) {
        itemPage.open();
        if (driver.findElements(By.className("options")).size() > 0){
                new Select(driver.findElement(By.name("options[Size]"))).selectByVisibleText("Small");
        }
        driver.findElement(By.name("add_cart_product")).click();
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.attributeToBe(driver.findElement(By.className("quantity")), "textContent", counter.toString()));
    }

    public void removeEachItem(){
        checkoutPage.open();
        WebDriverWait wait = new WebDriverWait(driver, 10);
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        WebElement element = driver.findElement(By.id("order_confirmation-wrapper"));
        driver.findElement(By.name("remove_cart_item")).click();
        wait.until(ExpectedConditions.stalenessOf(element));
    }

    public String getNumberOfProductsInCart(){
        homePage.open();
        String quantity = driver.findElement(By.cssSelector("#cart > a.content > span.quantity")).getAttribute("textContent");
        return quantity;
    }

    public boolean isCartEmpty(){
        checkoutPage.open();
        return driver.findElements(By.xpath("//*[contains(@id, 'order_confirmation-wrapper')]")).size() > 0;
    }
}
