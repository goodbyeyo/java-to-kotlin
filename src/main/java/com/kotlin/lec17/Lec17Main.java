package com.kotlin.lec17;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Lec17Main {

  public static void main(String[] args) {
    List<Fruit> fruits = Arrays.asList(
        new Fruit("사과", 1_000),
        new Fruit("사과", 1_200),
        new Fruit("사과", 1_200),
        new Fruit("사과", 1_500),
        new Fruit("바나나", 3_000),
        new Fruit("바나나", 3_200),
        new Fruit("바나나", 2_500),
        new Fruit("수박", 10_000)
    );
  }

  private List<Fruit> findApples(List<Fruit> fruits) {
    List<Fruit> apples = new ArrayList<Fruit>();
    for (Fruit fruit : fruits) {
      if (fruit.getName().equals("사과")) {
        apples.add(fruit);
      }
    }
    return apples;
  }

  private List<Fruit> findBananas(List<Fruit> fruits) {
    List<Fruit> apples = new ArrayList<Fruit>();
    for (Fruit fruit : fruits) {
      if (fruit.getName().equals("바나나")) {
        apples.add(fruit);
      }
    }
    return apples;
  }

  private List<Fruit> filterFruits(List<Fruit> fruits, Predicate<Fruit> fruitFilter) {
    List<Fruit> results = new ArrayList<>();
    for (Fruit fruit : fruits) {
      if (fruitFilter.test(fruit)) {
        results.add(fruit);
      }
    }
    return results;
  }

//  filtersFruits(fruits, fruit -> fruit.getName().equals("사과"));

  private List<Fruit> filtersFruits(List<Fruit> fruits, Predicate<Fruit> fruitFilter) {
    List<Fruit> results = new ArrayList<>();
    for (Fruit fruit :fruits) {
      if (fruitFilter.test(fruit)) {
        results.add(fruit);
      }
    }
    return results;
  }

  private List<Fruit> filtersFruitsWithStream(List<Fruit> fruits, Predicate<Fruit> fruitFilter) {
    return fruits.stream()
            .filter(fruitFilter)
            .collect(Collectors.toList());
  }

}
