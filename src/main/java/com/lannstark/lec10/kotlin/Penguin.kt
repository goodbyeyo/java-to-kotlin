package com.lannstark.lec10.kotlin

/**
 * 추상클래스에서 자동으로 만들어진 getter 를 override
 * 코틀린에서는 프로퍼티만 있어도 getter 가 자동으로 만들어짐
 * 이것을 새로 정의하기 위해서 override 키워드와 custom getter 사용해서 Java 같은 기능
 * 상위 클래스에 접근하는것 : super 동일
 */
class Penguin(
    species: String,
) : Animal(species, 2), Swimable, Flyable {

    private val wingCount: Int = 2

    override fun move() {
        println("penguin is moving")
    }

    override val legCount: Int
        get() = super.legCount + this.legCount

    override fun act() {
        super<Swimable>.act()
        super<Flyable>.act()

    }
}