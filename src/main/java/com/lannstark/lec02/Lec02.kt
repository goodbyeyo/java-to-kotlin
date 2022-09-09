package com.lannstark.lec02

fun main() {
    val str: String? = "ABC"
    println(str?.length)

    val nullStr: String? = null
    println(nullStr?.length ?: 0)   // null 이면 0 출력
}

// String -> null 이 들어올수 있음을 명시
// Boolean -> null 들어갈수 없으므로 ? 생략
fun startsWithA1(str: String?): Boolean {   // null 들어갈수없는 boolean
    if (str == null) {
        throw IllegalArgumentException("null이 들어왔습니다");
    }
    return str.startsWith("A")
}

fun startsWithA2(str: String?): Boolean? {  // null 들어갈수있는 Boolean
    if (str == null) {
        return null
    }
    return str.startsWith("A")
}

fun startsWithA3(str: String?): Boolean {
    // null 일수 있는 데이터는 바로 함수 호출 못함
    // return str.startsWith("A")
    if (str == null) {
        return false
    }
    // null 아닌 데이터는 확인 후 함수 호출 가능
    return str.startsWith("A")
}