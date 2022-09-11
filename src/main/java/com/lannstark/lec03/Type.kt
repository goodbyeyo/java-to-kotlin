package com.lannstark.lec03

/**
 * is, as
 * - value is Type : type check
 * - value as Type : type casting, type 아니면 -> class cast exception
 * - value as? Type : type casing, type 아니거나 null 이면 ->  null
 */

/**
 * Any
 * - 자바의 Object 역할(모든 객체의 최상위 타입)
 * - 모든 Primitive Type 최상의 타입도 Any
 * - Any 자체로는 null 포함할수 없기때문에 null 포함하고 싶다면 Any? 로 표현한다
 * - Any -> equals, hashCode, toString 존재함
 */

/**
 * Unit
 * - Unit -> 자바의 void 동일한 역할
 * - Java void 차이점 : Unit -> 그자체로 타입 인자로 사용 가능
 * - 함수형 프로그래밍에서 Unit -> 단 하나의 인스턴스만 갖는 타입을 의미
 * - 즉 코트린 Unit -> 실제 존재하는 타입이라는 것을 표함
 */

/**
 * Nothing
 * - Nothing -> 함ㅁ수가 정상적으로 끝나지 않았다는 사실을 표현하는 역할
 * - 무조건 예외를 반환하는 함수 / 무한 루프 함수
 * fun fail(message: String): Nothing {
 *   throw IllegalArgumentException(message)
 */

/**
 * String indexing
 * - ${변수} 사용 권장
 * - 1) 가독성
 * - 2) 일괄 변환
 * - 3) 정규식 활용
 * - """ """.trimIndent()
 * - 문자열에서 문자를 가져올때 [] 사용
 */

fun main() {
    val number1: Int? = 3

    // null 일수 있으므로 ? 추가 ?: -> null 일때 리턴값 정의
    val number2: Long = number1?.toLong() ?: 0L
    printAgeIfPerson2(null)


    val person = Person("wook", 10)
    println("이름 : ${person.name}")

    val name = "sangwook"
    println("이름 : $name ")

    val email ="email@naver.com"
    val str = """
        abc@naver.com
        def@gmail.com
        ghi@kakao.com
    """.trimIndent()
    println(str)

    val str1 = "ABC"
    println(str1[0])
    println(str1[1])
    println(str1[2])
}

//fun printAgeIfPerson(obj: Objects) {
fun printAgeIfPerson(obj: Any) {
    if (obj is Person) {
        // as Persion은 생략가능
        // obj라는 변수를 Person 타입으로 간주한다
        // val person = obj as Person

        // val person = obj
        // println(person.age)
        // -> inline
        println(obj.age) // smart casting
    }

//    if (obj !is Person) {
//        return null
//    }
}

fun printAgeIfPerson2(obj: Any?) {
    val person = obj as? Person
    println(person?.age)
}

