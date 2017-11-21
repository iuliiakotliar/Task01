package com.last.task.tests;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class Task09 extends TestBase{
    @Test
    public void cartOperation(){
        app.homePage.open();

        for (Integer i=1; i<4; i++) {
            app.addPopItem(i);
            assertEquals(i.toString(),app.getNumberOfProductsInCart());
        }

        while (app.isCartEmpty()){
            String beforeQuantity = app.getNumberOfProductsInCart();
            app.removeEachItem();
            app.isCartEmpty();
            assertNotEquals(beforeQuantity, app.getNumberOfProductsInCart());
        }

        assertEquals("0", app.getNumberOfProductsInCart());
    }
}
