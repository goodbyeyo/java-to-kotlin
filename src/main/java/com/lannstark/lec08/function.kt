package com.lannstark.lec08

class function {

    fun main(){

    }

    // 접근지시어 public 은 생략가능
    // Block { }을 사용하는 경우에는 반환 타입이 Unit 아니면
    // 명시적으로 작성해주어야 한다
   fun max(a: Int, b: Int) = if(a > b) a else b

}