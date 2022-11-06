package com.lannstark.lec12.kotlin

fun main() {

}

class Person (
    var name: String,
    var age: Int,
) {
    // static 대신 사용 ( = 동행객체 )
    companion object {
        val MIN_AGE = 1
        fun newBaby(name: String): Person {
            return Person(name, MIN_AGE)
        }
    }
}