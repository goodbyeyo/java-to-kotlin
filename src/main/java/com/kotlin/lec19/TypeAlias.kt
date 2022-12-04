package com.kotlin.lec19

import com.kotlin.lec18.Fruit
import com.kotlin.lec19.ex1.printHelloWorld as printHelloWorldEx1
import com.kotlin.lec19.ex2.printHelloWorld as printHelloWorldEx2

/**
 * Type Alias
 * - 긴 이름의 클래스 혹은 함수 타입이 있을때 축약하거나 더 좋은 이름을 쓰고 싶은 경우 사용
 * - 다른 패키지의 같은 이름 함수 동시에 가져오고 싶은 경우
 */

fun filterFruits(fruits: List<Fruit>, filter: (Fruit) -> Boolean) {
}

typealias FruitFilter = (Fruit) -> Boolean

fun filterFruits2(fruits: List<Fruit>, filter: FruitFilter) {
}

data class TypeAlias(
    val name: String
)

// 이름이 긴 클래스를 컬렉션에 사용할때 간단히 줄일수 있다
typealias  TAMap = Map<String, TypeAlias>

// 동일한 이름의 다른 함수를 재정의해서 사용
fun main() {
    printHelloWorldEx1()
    printHelloWorldEx2()
}

