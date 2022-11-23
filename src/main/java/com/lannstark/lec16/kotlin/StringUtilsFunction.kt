package com.lannstark.lec16.kotlin

import com.lannstark.lec16.Person

/**
 * 1) 확장함수
 * - fun 확장하려는클래스(수신객체 타입) 함수이름(파라미터): 리턴타입 {
 *     this(수신객체) 이용해서 실제 클래스 안의 값에 접근
 * - 확장함수는 원본클래스에 private 또는 protected 멤버 접근 불가능
 * - 멤버함수와 확장함수 중 멤버함수에 우선권
 *   -> 둘의 시그니처가 같다면 멤버함수가 우선 호출된다
 * - 확장함수는 현재 타입을 기준으로 호출된다
 *   -> 해당 변수의 현재타입, 즉 정적인 타입에 의해 어떤 확장함수가 호출될지 결정
 *
 * 2) 중위함수
 *  - infix 함수
 *  - infix : 멤버함수에도 붙일수 있다
 *
 * 3) InLine 함수
 *  - 함수가 호출되는 대신, 함수를 호출한 지점에 함수 본문을 그대로 사용
 *  - 함수를 파라미터로 전달할때에 오버헤드를 줄일 수 있다
 *  - 다만 inline 함수 사용은 성능 측정과 함께 신중하게 사용되어야 함
 *
 * 4) 지역함수
 *  - 함수로 추출할 경우 해당 함수를 지금 함수 내에서만 사용하고 싶은 경우
 *  - depth 가 싶어지고, 코드 not clean
 *  - 사용 잘 하지 않음
 */

fun main() {
    val str = "ABC"
    val str2: String = "ABCDE"
    println(str2.lastChar())

    val person = Person("황","상욱", 100)

    println(person.nextYearAge())   // 멤버 함수 호출 (우선)
    duplicateFunction(firstName = "Hwang", lastName = "SangWook")
    localFunction(firstName = "Sang", lastName = "Wook")

}

fun localFunction(firstName: String, lastName: String) {
    fun validateName(name: String, fieldName: String) {
        if (name.isEmpty()) {
            throw java.lang.IllegalArgumentException("${fieldName} 공백불가 : 현재값 : $name" )
        }
    }
}

fun duplicateFunction(firstName : String, lastName : String): Person {
    if (firstName.isEmpty()) {
        throw java.lang.IllegalArgumentException("firstName 공백불가 : 현재값 : $firstName" )
    }

    if (lastName.isEmpty()) {
        throw java.lang.IllegalArgumentException("lastName 공백불가 : 현재값 : $lastName" )
    }

    return Person(firstName, lastName, 1)
}

fun String.lastChar() : Char {
    // 코틀린에서 문자열은 [ ] 통해서 접근
    // 함수 안에서는 this(수신객체) 통해서 인스턴스 접근 가능
    return this[this.length - 1]
}

// 확장함수
fun Person.nextYearAge(): Int {
    println("확장함수")
    return this.age + 1

}