package com.lannstark.lec09

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
class Person3 (
    val name: String,
    val age: Int) {
}
    // 초기화 블록 : 생성자가 호출되는 시점에 호출
    // example : value generator or validation
cd