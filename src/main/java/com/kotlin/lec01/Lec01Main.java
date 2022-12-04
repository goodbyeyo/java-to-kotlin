package com.kotlin.lec01;

import java.util.Arrays;
import java.util.List;

public class Lec01Main {

  public static void main(String[] args) {
    long number1 = 10L; // (1)
    final long number2 = 10L; // (2)

    Long number3 = 1_000L; // (3)
    Person person = new Person("wook"); // (4)

    try {
      List<Integer> numbers = Arrays.asList(1, 2);
      // Array.asList는 사이즈가 생성과 동시에 지정되어서
      // add(원소를 추가하면) UnsupportedOperationException 발생
      // ArrayList 일때만 추가 가능하다
      numbers.add(3, 4);
      System.out.println("numbers = " + numbers.toString());
    }catch (UnsupportedOperationException e){
      System.out.println("e.toString() = " + e.toString());
    }
  }

}
