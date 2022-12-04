package com.kotlin.lec15.kotlin

/**
 * Collection in kotlin
 *  1) List - MutableList
 *   - 가변(Mutable) 컬력션 : 컬렉션에 element 를 추가, 삭제할수 있다
 *   - 불변 컬렉션 : 컬렉션에 element 를 추가, 삭제 할 수 없다
 *    -> 즉 컬렉션을 만들자말자 Collections.unmodifiableList()
 *    -> 불변컬렉션이라도 하더라도 Reference Type 인 Element 필드는 바꿀 수 있다
 *    -> 불변 리스트를 만들고, 꼭 필요한 경우 가변 리스트로 변경 사용 권장
 *
 *  2) Set - MutableSet
 *   - 집합은 List 와 다르게 순서가 없고 같은 element 하나만 존재
 *
 *  3) Map - MutableMap
 *   - key 통해서 접근하는 방법
 *   - getKey(), getValue() 로 조회
 *
 *  4) Collections null 가능성 : ? 위치에 따라 null 가능성 의미 달라짐
 *   - List<Int?> : 리스트 Null 들어갈 수 있지만, 리스트는 절대 null 아님
 *   - List<Int>? : 리스트 Null 들어갈 수 없지만, 리스트는 Null 일 수 있음
 *   - List<Int?>? : 리스트에 Null 들어갈 수 있고, 리스트가 Null 일 수 있음
 *
 *  5) Java 읽기 전용 컬렉션과 변경 가능 컬렉션을 구분하지 않음
 *   a. Kotlin <- Java 컬렉션 가져갈때
 *    - 플랫폼 타입 신경써야 함
  *   - Kotlin 컬렉션이 Java 에서 호출되면 컬렉션 내용이 변할수 있음 감안
 *    - Kotlin Collections.unmodifiableXXX() 활용하면 변경 막을 수는 있다
 *   b. Java <- Kotlin 컬렉션 가져갈때
 *    - 불변컬렉션 수정가능
 *    - non-nullable 컬렉션에 null 넣을수도 있다
 *
 *
 */
fun main(){

    printNumbers()

    // 값을 넣지 않는 경우 Type 명시적으로 선언해야함
    val emptyList = emptyList<Int>()

    printEmptyNumbers(emptyList)

    printMutableList()

    printSet()

    printMap()

}

private fun printMap() {
    val oldMap = mutableMapOf<Int, String>()
    oldMap[1] = "MONDAY"
    oldMap[2] = "TUESDAY"

    // 초기화 (중위 호출) , 불변
    mapOf(1 to "MONDAY", 2 to "TUESDAY")

    for (key in oldMap.keys) {
        println(key)

        // 리스트 처럼 값 꺼내기
        println(oldMap[key])
    }

    for ((key, value) in oldMap.entries) {
        println(key)
        println(value)
    }
}

fun printSet() {

    val numbers = setOf(100, 200)

    for (number in numbers) {
        println(numbers)
    }

    for((idx, value) in numbers.withIndex()) {
        println("$idx $value")
    }

    // 기본 구현체는 LinkedHashMapSet
    val array = mutableSetOf(300, 400)
    array.add(500)
    array.add(300)  // 같은값은 추가해도 변함 없음

    for (number in array) {
        println(numbers)
    }

    for((idx, value) in array.withIndex()) {
        println("$idx $value")
    }

}

private fun printMutableList() {
    val numbers = mutableListOf(100, 200)

    numbers.add(300)

    for (i in numbers.indices) {
        println("${i} ${numbers[i]}")
    }
}

private fun printNumbers() {
    val array = arrayOf(100, 200)

    // 불변 컬렉션에는 값을 추가 할 수 없다..
    // array.plus(300)

    println("${array.size}")

    for (i in array.indices) {
        println("${i} ${array[i]}")
    }

    for ((idx, value) in array.withIndex()) {
        println("$idx $value")
    }
}

// 파라미터에서 추론이 가능하면 Type 생략 가능
fun printEmptyNumbers(emptyList: List<Int>) {

    val numbers = listOf(100, 200)
    println(numbers[0])

    // for each
    for (number in numbers) {
        println(numbers)
    }

    // traditional for
    for((idx, value) in numbers.withIndex()) {
        println("$idx $value")
    }
}
