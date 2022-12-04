package com.kotlin.lec10.kotlin

interface Swimable {

    val swimAbiliity: Int
    // getter 를 직접 구현해줄수 있다 (기본값)
    // 생략하는경우 즉 backing filed 없는 프로퍼티를 인터페이스에 만들 수 있다
        get() = 3   // 직접 넣어줄수도 있다
    fun act() {
        println("어푸 어푸")
        println(swimAbiliity)
    }
}