package com.kotlin.lec04

/**
 * java -> 동일성 == , 동등성 equals 호출
 * kotlin -> 동일성 === , 동등성 == 호출 (-> equals 호출)
 * lazy 연산 수행 -> a() || b() -> a() 만 만족하면 b() 수행하지않고 실행
 * in / !in - 컬렉션이나 범위에 포함되어 있다, 포함되어 있지 않다
 * a..b - a 부터 b 까지 범위객체를 생성한다
 * a[i] - a 의 특정 인덱스 i 값을 가져온다
 */
fun main() {

    val money1 = JavaMoney(2_000L)
    val money2 = JavaMoney(1_000L)

    if (money1 > money2) {
        println("money1이 money2보다 큽니다")
    }

    println(money1 + money2)
}