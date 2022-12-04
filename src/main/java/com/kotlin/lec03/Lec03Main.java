package com.kotlin.lec03;

public class Lec03Main {

  public static void main(String[] args) {
  }

  public static void printAgeIfPerson(Object obj) {
    /**
     * instanceof
     * 변수가 주어진 타입이면 true, 그렇지 않으면 false
     */
    if (obj instanceof Person) {
      Person person = (Person) obj;
      System.out.println(person.getAge());
    }
  }

}
