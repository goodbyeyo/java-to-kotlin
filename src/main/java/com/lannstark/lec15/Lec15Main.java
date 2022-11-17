package com.lannstark.lec15;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Lec15Main {

  public static void main(String[] args) {

    int[] array = {100, 200};

    for (int i = 0; i < array.length; i++) {
      System.out.printf("%s %s", i, array[i]);
    }

    // jdk 8
    final List<Integer> numberss = Arrays.asList(100, 200);

    // jdk 9
    final List<Integer> numbers = List.of(100, 200);

    // 하나를 가져오가
    System.out.println("numbers2 = " + numbers);

    // for each
    for (int number : numbers) {
      System.out.println("number = " + number);
    }

    // traditional for
    for (int i = 0; i < numbers.size() ; i++) {
      System.out.printf("%s %s,", i, numbers.get(i));
    }

    // Jdk 8
    Map<Integer, String> oldMap = new HashMap<>();
    oldMap.put(1, "MONDAY");
    oldMap.put(2, "TUESDAY");

    // jdk 9
    Map.of(1, "MONDAY", 2, "TUESDAY");

  }

}
