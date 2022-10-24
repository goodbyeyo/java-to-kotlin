package com.lannstark.lec08;

public class Lec08Main {

  public static void main(String[] args) {

  }

  public int max(int a, int b) {
    if (a > b) {
      return a;
    }
    return b;
  }

  public void repeat(String str, int num, boolean useNewLine){
    for(int i = 0; i < num; i++){
      if(useNewLine){
        System.out.println(str);
      }else {
        System.out.println(str);
      }
    }
  }

  // OverLoading
  public void repeat(String str, int num) {
    repeat(str, num, true);
  }

  // OverLoading
  public void repeat(String str) {
    repeat(str, 3, true);
  }

  public static void printAll(String... strings) {
    for (String str : strings) {
      System.out.println(str);
    }
  }



}
