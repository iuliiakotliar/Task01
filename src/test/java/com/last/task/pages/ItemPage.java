package com.last.task.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class ItemPage extends Page{
    public ItemPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public ItemPage open(){
        driver.findElement(By.xpath("//*[@id=\"box-most-popular\"]//img")).click();
        return this;
    }
}
