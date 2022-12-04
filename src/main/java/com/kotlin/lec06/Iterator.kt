package com.kotlin.lec06

fun main(){

    // 시작값 1, 끝값 3, 공차 1
    for (i in 1..3) {
        println(i)
    }

    // 시작 값 3, 끝값 1, 공차 -1
    for (i in 3 downTo 1) {
      println(i)
    }

    // 시작값 1, 끝값 5, 공차 2
    for (i in 1..5 step 2) {
        println(i)
    }

    // downTo, step -> 함수에 해당한다
    
}