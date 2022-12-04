package com.kotlin.lec19

/**
 * 구조분해
 * - 복합적인 값을 분해하여 여러 변수를 한 번에 초기화하는 것
 * - Data Class -> componentN 함수를 자동으로 만들어준다
 * - 구조분해 문법을 쓴다는 것 -> componentN 함수를 호출한다는 것
 */

//data class Person(
//    val name: String,
//    val age : Int
//)

class Person(
    val name: String,
    val age : Int
){
    operator fun component1() : String {
        return this.name
    }
    operator fun component2() : Int {
        return this.age
    }
}


fun main() {

    val person = com.kotlin.lec19.Person("황상욱", 30)

    // val name = person.component1()  // get first property
    // val age = person.component2()   // get second property
    val (name, age) = person
    // val( age, name) = person    // name <- age , name <- age

    println("이름 : ${name}, 나이 : ${age} ")

    val map = mapOf(1 to "A", 2 to "B")
    // 구조분해 문법 사용
    for ((key, value) in map.entries) {

    }
}