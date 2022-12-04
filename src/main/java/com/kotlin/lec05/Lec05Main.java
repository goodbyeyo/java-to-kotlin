package com.kotlin.lec05;

public class Lec05Main {

  public static void main(String[] args) {
  }

  private void validateScoreIsNotNegative(int score) {
    if (score < 0) {
      throw new IllegalArgumentException(String.format("%s는 0보다 작을 수 없습니다"));
    }
  }

  private void validateScore(int score){
    if (0 <= score && score <= 100) {
      throw new IllegalArgumentException(String.format("%s는 0부터 100 사이여야 합니다"));
    }
  }

  public String getPassOrFail(int score) {
    return score >= 50 ? "P" : "F";
  }

  // 2. if-else
  private String getGrade(int score) {
    if (score >= 90) {
      return "A";
    } else if (score >= 80) {
      return "B";
    } else if (score >= 70) {
      return "C";
    } else {
      return "D";
    }
  }

  // 3. switch
  private String getGradeWithSwitch(int score) {
    return switch (score / 10) {
      case 9 -> "A";
      case 8 -> "B";
      case 7 -> "C";
      default -> "D";
    };
  }

  private boolean startsWithA(Object obj){
    if(obj instanceof String) {
      return ((String) obj).startsWith("A");
    }else {
      return false;
    }
  }

  private void judgeNumber(int number) {
    if(number == 1 || number == 0 || number == -1 ){
      System.out.println("number = " + number);
    }else{
      System.out.println("1, 0, -1 이 아닙니다");
    }
  }

  private void judgeNumber2(int number) {
    if (number == 0) {
      System.out.println("주어진 숫자는 0입니다");
      return;
    }

    if (number % 2 == 0) {
      System.out.println("주어진 숫자는 짝수입니다");
      return;
    }

    System.out.println("주어진 숫자는 홀수입니다");
  }

}
