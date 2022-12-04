package com.kotlin.lec19

/**
 * return : 기본적으로 가장 가까운 enclosing function 또는 익명함수로 값이 반환
 * break : 가장 가까운 로프 제거
 * continue : 가장 가까운 루프를 다음 step 으로
 *
 * 라벨을 사용한 Jump -> 사용하지 않는 것을 추천천
 * Takeif :주어진 조건을 만족하면 그값을 리턴, 그렇지 않으면 null 리턴 
 * TakeUnless : 주어진 조건을 만족하지 않으면 그 값을 리턴, 그렇지 않으면 null 리턴
 */

fun main() {

    val numbers = listOf(1, 2, 3, 4, 5, 6, 7)
    numbers.map { number -> number +1 }
        .forEach{println(it)}

    for (number in numbers) {
        println(number)
        if (number == 2) {
            break
        }
    }

    numbers.forEach { number ->
        if (number == 2) {
          // break 사용 불가능
        }
    }

    run {
        numbers.forEach { number ->
            if (number == 4) {
                return@run  // breack
            }
        }
    }

    run {
        numbers.forEach { number ->
            if (number == 4) {
                return@forEach // continue
            }
        }
    }

    loop@ for (i in 1..100) {
        for (j in 1..100) {
            if (j == 4) {
                break@loop // 첫번째 for 문을 멈춘다
            }
            println("${i} ${j}")
        }
    }

    for (number in numbers) {
        fun getNumberOfNull(): Int? {
            return if (number <= 0) {
                null
            } else {
                number
            }
        }
    }

    for (number in numbers) {
        fun getNumberOrNull2(): Int? {
            return number.takeIf { it > 0 }
        }
    }

    for (number in numbers) {
        fun getNumberOrNull3(): Int? {
            return number.takeUnless { it <= 0 }
        }
    }
}