package com.lannstark.lec10.kotlin

/**
 * 추상클래스에서 자동으로 만들어진 getter 를 override
 * 코틀린에서는 프로퍼티만 있어도 getter 가 자동으로 만들어짐
 * 이것을 새로 정의하기 위해서 override 키워드와 custom getter 사용해서 Java 같은 기능
 * 상위 클래스에 접근하는것 : super 동일
 * Kotlin -> backing filed 가 없는 프로퍼티를 Interface 에 만들수있다
 * 상위 클래스를 설계할 때 생성자 또는 초기화 블록에 사용되는 프로퍼티에는 open 을 피해야 한다
 * 상속 관련 키워드
 * 1) final : override 할 수 없게 한다, default 로 보이지 않게 존재한다
 * 2) open : override 열어준다
 * 3) abstract : 반드시 override 해야 한다
 * 4) override : 상위 타입을 오버라이드 하고 있다
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

    //
    override val swimAbiliity: Int
        get() = 3
}