package com.kotlin.lec08;

public class Lec08Main {

  public static void main(String[] args) {
    String[] array = new String[]{"A","B","C","D","E","F"};
    printAll(array);
    printAll("A", "B", "C", "D", "E", "F");
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

  // 같은 타입의 여러 파라미터 받기(가변인자)
  // String... -> 타입...은 가변인자
  public static void printAll(String... strings) {
    for (String str : strings) {
      System.out.println(str);
    }
  }



}
