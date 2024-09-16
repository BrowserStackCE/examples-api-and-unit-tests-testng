package com.browserstack.tests.unit;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.browserstack.pages.Item;
import com.browserstack.pages.ShoppingCart;

public class ShoppingCartTest {

  private ShoppingCart cart;

  @BeforeMethod
  public void setUp() {
    cart = new ShoppingCart();
  }

  @Test
  public void testAddItems() {
    cart.addItem(new Item("Laptop", 1000));
    cart.addItem(new Item("Mouse", 50));
    Assert.assertEquals(cart.getItemCount(), 2);
    Assert.assertEquals(cart.getTotalPrice(), 1050);
  }

  @Test
  public void testEmptyCart() {
    Assert.assertEquals(cart.getItemCount(), 0);
    Assert.assertEquals(cart.getTotalPrice(), 0);
  }
}
