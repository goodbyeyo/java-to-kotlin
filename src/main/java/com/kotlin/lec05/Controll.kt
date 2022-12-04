package com.kotlin.lec05

import java.sql.DriverManager.println

/**
 * Java - if-else
 *  -> Statement : 프로그램의 문장, 하나의 값으로 도출되지 않는다
 * Kotlin -if-else
 *  -> Expression : 하나의 값으로 도출되는 문장
 *  -> Kotlin 에서는 is-else 를 expression 으로 사용할수 있기때문에 3항 연산자가 없다
 */

// 1. if
fun validateScoreIsNotNegative(score: Int) {
    if( score < 0 ) {
        throw IllegalArgumentException("${score} 는 0보다 작을수 없습니다")
    }
}

fun validateScore(score: Int) {
    if( score !in 0..100 ) {
        throw IllegalArgumentException("${score} 는 0부터 100 사이여야 합니다")
    }
}

// 2. Expression & Statement
fun getPassOrFail(score: Int): String {
    return if( score > 50 ) {
        "P"
    }else{
        "F"
    }
}

// 3. when - java (switch)
/**
 * when ( 값 ) {
 *  조건부 -> 어떠한 구문
 *  else -> 어떠한 구문
 *  조건부에는 어떠한 expression 이라도 들어갈 수 있다(ex. is Type)
 */
fun getGrade(score: Int): String? {
    return if (score >= 90) {
        "A"
    } else if (score >= 80) {
        "B"
    } else if (score >= 70) {
        "C"
    } else {
        "D"
    }
}

fun getGradeWithSwitch(score: Int): String {
    return when(score) {
        9 -> "A"
        8 -> "B"
        7 -> "C"
        else -> "D"
    }
}
fun getGradeWithSwitch2(score: Int): String {
    return when(score) {
        in 99..90 -> "A"
        in 89..80 -> "B"
        in 79..70 -> "C"
        else -> "D"
    }
}

fun startsWithA(obj: Any): Boolean {
    return when (obj) {
        is String -> obj.equals("A")
        else -> false
    }
}

fun judgeNumber(number: Int){
    when (number) {
        1, 0, -1 -> println(number.toString())
        else -> println("1, 0, -1 이 아닙니다")

    }
}

fun judgeNumber2(number: Int) {
    when {
        number == 0 -> println("주어진 숫자는 0입니다")
        number % 2 == 0 -> println("주어진 숫자는 짝수입니다")
        else -> println("주어진 숫자는 홀수입니다")
    }
}