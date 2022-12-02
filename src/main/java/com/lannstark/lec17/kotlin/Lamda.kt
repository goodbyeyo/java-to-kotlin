package com.lannstark.lec17.kotlin

import com.lannstark.lec17.Fruit
import java.io.BufferedReader
import java.io.FileReader

/**
 * 코들린에서 람다를 다루는 방법
 * 1. Java 에서 람다를 다루기 위한 노력
 *  - Java 에서 함수는 변수에 할당되거나 파라미터로 전달 할 수 없다 : 2급 시민
 *
 * 2. 코틀린에서의 람다
 *  - 코틀린에서 함수는 그 자체로 값이 될 수 있다.
 *  - 변수에 할당할수도, 파라미터로 넘길수도 있다.
 *  - Kotlin 에서 함수는 1급 시민 (Java 는 2급 시민)
 *  - 마지막 파라미터가 함수인 경우, 소괄호 밖에 람다 사용 가능
 *  - 마지막 파라미터인 람다를 쓸 때는 소활호 밖으로 람다를 뺄 수 있다
 *   -> 그 파라미터를 it 을 통해 접근할수 있다
 *   람다의 마지막 expression 결과는 람다의 반환 값
 *   - 코틀린에서 Closure 사용하여 non-final 변수(가변 변수)도 람다에서 사용 할 수 있다
 *
 * 3. Closure
 *  - Java 에서 람다를 쓸 때 사용 할 수 있는 변수에 제약이 있다
 *   -> 즉 람다 밖에 있는 변수를 사용하지 못한다
 *  - 코틀린에서는 람다가 시작하는 지점에 참조하고 있는 변수들을 모두 포획하여 그 정보를 가지고 있다
 *   -> 이렇게 해야만 람다를 진정한 일급 시민으로 간주 할수 있다
 *   -> 이 데이터 구조를 Colsure 라고 부른다
 *
 * 4. try with resources
 */

fun main() {
    val fruits = listOf(
    Fruit("사과", 1_000),
    Fruit("사과", 1_200),
    Fruit("사과", 1_200),
    Fruit("사과", 1_500),
    Fruit("바나나", 3_000),
    Fruit("바나나", 3_200),
    Fruit("바나나", 2_500),
    Fruit("수박", 10_000),
    )

    // 람다를 만드는 방법 1
    val isApple = fun(fruit: Fruit): Boolean {
        return fruit.name == "사과"
    }

    // Fruit 받아서 Boolean 반환
    val isAppleRename: (Fruit) -> Boolean = fun(fruit: Fruit): Boolean {
        return fruit.name == "사과"
    }

    // 람다를 만드는 방법 2
    val isApple2 = { fruit: Fruit -> fruit.name == "사과"}
    val isApple2Rename: (Fruit) -> Boolean = { fruit: Fruit -> fruit.name == "사과"}

    isApple(fruits[0])
    isApple.invoke(fruits[0])

    // 람다를 직접 호출하는 방법 1
    isApple(Fruit("사과", 1000))
    isApple.invoke(Fruit("사과", 1000))

    filterFruits(fruits, isApple)

    filterFruits(fruits, fun(fruit: Fruit): Boolean {
        return fruit.name == "사과"
    })

    // filterFruits(fruits, { fruit: Fruit -> fruit.name == "사과"})
    // { } 함수를 밖으로 뺄수 있다 -> 함수를 호출할때 가장 마지막 파라미터로 전달
    // 마지막 파라미터가 함수인 경우, 소괄호 밖에 람다 사용 가능
    filterFruits(fruits) { fruit: Fruit -> fruit.name == "사과" }

    // Fruit 생략 가능
    filterFruits(fruits) { fruit -> fruit.name == "사과" }

    // 이름(fruit) 변경 가능
    filterFruits(fruits) { a -> a.name == "사과" }

    // 람다를 작성할때, 람다의 파라미터를 it 으로 직접 참조 할 수 있다
    filterFruits(fruits) { it.name == "사과"}

    // 람다를 여러줄 작성 할수 있고 마지막 줄의 결과가 람다의 반환값이다
    filterFruits(fruits) {fruit ->
        println("사과만 받는다")
        fruit.name == "사과"
    }

    closure(fruits)

    val isApple3: (Fruit) -> Boolean = { fruit: Fruit -> fruit.name == "사과" }
    filterFruits2(fruits, isApple3)

}

fun closure(fruits: List<Fruit>) {
    var targetFruitName = "바나나"
    targetFruitName = "수박"
    filterFruits(fruits) { it.name == targetFruitName }
}

private fun filterFruits(
    fruits: List<Fruit>, filter: (Fruit) -> Boolean
): List<Fruit> {
    val results = mutableListOf<Fruit>()
    for (fruit in fruits) {
        if (filter(fruit)) {
            results.add(fruit)
        }
    }
    return results
}

/**
 * filter 라는 함수 자체를 파라미터로 받게 하는 방법
 * -> 그 함수를 invoke 혹은 소괄호로 호출 가능
 */
private fun filterFruits2(fruits: List<Fruit>, filter: (Fruit) -> Boolean): List<Fruit> {
    val results = mutableListOf<Fruit>()
    for (fruit in fruits) {
        if (filter.invoke(fruit)) {
            results.add(fruit)
        }
    }
    return results
}

fun readFile(path: String) {
    BufferedReader(FileReader(path)).use { reader ->
        println(reader.readLine())
    }
}
