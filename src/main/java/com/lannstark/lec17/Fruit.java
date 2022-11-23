package com.lannstark.lec17;

import java.util.Arrays;

public class Fruit implements FruitFilter {

  private final String name;
  private final int price;

  public Fruit(String name, int price) {
    this.name = name;
    this.price = price;
  }

  public String getName() {
    return name;
  }

  public int getPrice() {
    return price;
  }

  public boolean isApple() {
    return this.name.equals("사과");
  }


  @Override
  public boolean isSelected(Fruit fruit) {
    return Arrays.asList("사과", "바나나")
            .contains(fruit.getName()) && fruit.getPrice() > 5_000;
  }
}
