package com.kotlin.lec10.kotlin

/**
 * extends 대신 : 사용
 * : 다음에 상위 클래스의 생성자를 바로 호출한다
 * override 지시어를 붙여준다
 */
class Cat (
    species: String
) : Animal (species, 4) {

    override fun move() {
        println("cat is moving")
    }
}
