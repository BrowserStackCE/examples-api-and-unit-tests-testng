package com.browserstack.pages;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {

  private final List<Item> items = new ArrayList<>();

  public void addItem(Item item) {
    items.add(item);
  }

  public int getTotalPrice() {
    return items.stream().mapToInt(Item::getPrice).sum();
  }

  public int getItemCount() {
    return items.size();
  }
}
