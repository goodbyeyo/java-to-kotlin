package com.lannstark.lec14.kotlin

/**
 * Data class
 *  - equals, hashCode, toString 자동으로 만들어준다
 * Enum class
 *  - when 과 함께 쓰면 유용
 * Sealed class : 봉인된 클래스
 *  - enum 과 달리 클래스를 상속받을 수 있다.
 *  - 하위 클래스는 멀티 인스턴스가 가능하다.
 */
fun main(){
    val value1 = PersonDto("황상욱", 30)
    val value2 = PersonDto("황상욱", 30)

    println(value1)
    println(value1 == value2)
}
data class PersonDto (
    val name: String,
    val age: Int
)
