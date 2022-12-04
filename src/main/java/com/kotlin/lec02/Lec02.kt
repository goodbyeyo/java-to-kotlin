package com.kotlin.lec02

fun main() {
    val str: String? = "ABC"
    println(str?.length)

    val nullStr: String? = null
    println(nullStr?.length ?: 0)   // null 이면 0 출력

    println(startWithNotNull("ABC"))
    println(startWithNotNull("BC"))
    println(startWithNotNull(null))

//    val person = Person("wook", "email")
//    startWithName(person.name)

    /**
     * @Nullable 로 선언된 필드
     * -> 함수 호출 불가능
     * Java 코드 사용할때 플랫폼 타입 사용에 유의
     * -> 코틀린이 null 관련 정보를 알수 없는 타입
     * -> Runtime 시 Exception  날 수 있다
    */
    // startWithEmail(person.email)
}

fun startWithName(str: String): Boolean {
    return str.startsWith("A")
}

fun startWithEmail(str: String): Boolean {
    return str.startsWith("A")
}

// String -> null 이 들어올수 있음을 명시
// Boolean -> null 들어갈수 없으므로 ? 생략
fun startsWithA1(str: String?): Boolean {   // null 들어갈수없는 boolean

//    if (str == null) {
//        throw IllegalArgumentException("null이 들어왔습니다");
//    }
//    return str.startsWith("A")

    return str?.startsWith("A") // null 아 아니면 실행
        ?: throw IllegalArgumentException("null이 들어왔습니다"); // null 이면 실행

}

fun startsWithA2(str: String?): Boolean? {  // null 들어갈수있는 Boolean
//    if (str == null) {
//        return null
//    }
//    return str.startsWith("A")

    // safe call은 앞에 변수가 null dㅣ면 그대로 null이 된다
    return str?.startsWith("A")
}

fun startsWithA3(str: String?): Boolean {
    // null 일수 있는 데이터는 바로 함수 호출 못함
    // return str.startsWith("A")
//    if (str == null) {
//        return false
//    }
//    // null 아닌 데이터는 확인 후 함수 호출 가능
//    return str.startsWith("A")

    return str?.startsWith("A")
        ?: false    // null 이면 flase 반환
}

fun startWithNotNull(str: String?): Boolean {
    // !! -> null 일경우에는 NullPointerException 발생함
    return str!!.startsWith("A")
}