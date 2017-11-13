package com.last.task.tests;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Task09 extends TestBase{
    @Test
    public void cartOperation(){
        app.homePage.open();
        app.addPopItem();
        app.checkoutPage.open();
        app.removeEachItem();
        app.homePage.open();
        String actualValue = app.homePage.getQuantity();

        assertEquals("0", actualValue);
    }
}
