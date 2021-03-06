package com.last.task.tests;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class Task09 extends TestBase{
    @Test
    public void cartOperation(){
        for (Integer i=1; i<4; i++) {
            app.addPopularItem(i);
            assertEquals(i.toString(),app.getNumberOfProductsInCart());
        }
        while (app.isCartEmpty()){
            String beforeQuantity = app.getNumberOfProductsInCart();
            app.removeOneItem();
            assertNotEquals(beforeQuantity, app.getNumberOfProductsInCart());
        }
        assertEquals("0", app.getNumberOfProductsInCart());
    }
}
