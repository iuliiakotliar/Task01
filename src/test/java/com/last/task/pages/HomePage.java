package com.last.task.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends Page{
    public HomePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public HomePage open(){
        driver.get("http://localhost/litecart");
        return  this;
    }

    public String getQuantity(){
        String quantity = driver.findElement(By.cssSelector("#cart > a.content > span.quantity")).getAttribute("textContent");
        return quantity;
    }
}
