package com.lannstark.lec12;

import com.lannstark.lec12.kotlin.Person;

public class Lec12Main {

  public static void main(String[] args) {
    // Person.Factory.newBaby("ABC");
    Person.Companion.newBaby("ABC");  // 이름이 있는 경우
    Person.newBaby("ABC");  // 코틀린 코드에 @JvmStatic

    moveSomething(new Movable(){
      @Override
      public void move() {
        System.out.println("move");
      }
      @Override
      public void fly() {
        System.out.println("fly");
      }
    });
  }

  private static void moveSomething(Movable movable) {
    movable.move();
    movable.fly();
  }

}
