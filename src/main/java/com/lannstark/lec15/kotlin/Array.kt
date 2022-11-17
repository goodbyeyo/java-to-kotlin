package com.lannstark.lec15.kotlin

/**
 * Collection in kotlin
 * 1) List - MutableList
 *  - 가변(Mutable) 컬력션 : 컬렉션에 element 를 추가, 삭제할수 있다
 *  - 불변 컬렉션 : 컬렉션에 element 를 추가, 삭제 할 수 없다
 *   -> 즉 컬렉션을 만들자말자 Collections.unmodifiableList()
 *   -> 불변컬렉션이라도 하더라도 Reference Type 인 Element 필드는 바꿀 수 있다
 *   -> 불변 리스트를 만들고, 꼭 필요한 경우 가변 리스트로 변경 사용 권장
 *
 * 2) Set - MutableSet
 *  - 집합은 List 와 다르게 순서가 없고 같은 element 하나만 존재
 *
 * 3) Map - MutableMap
 *
 * (1) List
 * 가변(Mutable) 컬력션 : 컬렉션에 element 를 추가, 삭제할수 있다
 * 불변 컬렉션 : 컬렉션에 element 를 추가, 삭제 할 수 없다
 *   -> 즉 컬렉션을 만들자말자 Collections.unmodifiableList()
 *   -> 불변컬렉션이라도 하더라도 Reference Type 인 Element 필드는 바꿀 수 있다
 *
 * 불변 리스트를 만들고, 꼭 필요한 경우 가변 리스트로 변경
 *
 * (2)
 */
fun main(){

    printNumbers()

    // 값을 넣지 않는 경우 Type 명시적으로 선언해야함
    val emptyList = emptyList<Int>()

    printEmptyNumbers(emptyList)

    printMutableList()

    printSet()

    val oldMap = mutableMapOf<Int, String>()
    oldMap[1] = "MONDAY"
    oldMap[2] = "TUESDAY"

    // 초기화 (중위 호출)
    mapOf(1 to "MONDAY", 2 to "TUESDAY")

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
