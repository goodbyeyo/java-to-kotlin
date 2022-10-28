package com.lannstark.lec09

import java.lang.IllegalArgumentException

fun main() {
    val person = Person("wook", 10)
    // getter, setter 없이 바로 접근 가능
    println(person.name)
    person.age=20
    println(person.age)

    // java 객체도 getter, setter 없이 접근가능
    val javaPerson = JavaPerson("sangwook", 30)
    println(javaPerson.name)
    println(javaPerson.age)

    // 두번째 부생성자 호출
    // 역순으로 실행
    // 초기화 블록 -> 첫번째 생성자 -> 두번째 생성자
    Person3()
}
public class Person constructor(name: String, age: Int) {
    val name: String = name
    var age: Int = age
}
/**
 * public 생략가능
 * constructor 생략가능
 */
class Person2 (name: String, age: Int) {
    val name = name
    var age = age
}

/* 클래스의 필드 선언과 생성자를 동시에 선언 할 수 있다 */
// 주생성자 : 반드시 존재해야 함
// 단, 주생성자에 파라미터가 하나도 없다면 생략 가능함
// Converting 과 같은 경우 부생성자를 사용 할 수 있지만
// 그보다는 정적 팩토리 메소드를 추천
class Person3 (
    val name: String,
    val age: Int) {

    // 초기화 블록 : 생성자가 호출되는 시점에 호출
    // example : value generator or validation
    init {
        if (age < 0) {
            throw IllegalArgumentException("나이는 ${age} 일 수 없습니다")
        }
        println("초기화 블록")
    }

    // 생성자 추가하는 경우
    constructor(name: String): this(name, 1){
        println("첫번째 부생성자")
    }

    // 부생성자 : secondary constructor
    // 최종적으로 주생성자를 this 로 호출해야 한다.
    // body를 가질수 있다
    constructor(): this("홍길동") {
        println("두번째 부생성자")
    }

//    fun isAdult(): Boolean {
//        return this.age >= 20
//    }

    // custom getter
    val isAdult: Boolean
        get() = this.age >= 20

    // 객체의 속성이라면 -> custom getter
    // 그렇지 않다면 -> 함수

    val email: String = name
        get() = field.uppercase()
}


class Student()


