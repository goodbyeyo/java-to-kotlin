package com.kotlin.lec01

fun main() {
    /**
     * 1. 변수 : var(Variable) : 변경가능 , val(Value) : read-only
     * 모든 변수는 우선 val로 만들고 꼭 필요한 경우 var로 변경한다 (for clean code)
     * val 컬렉션에는 element를 추가할수 있다
     */
    var number1 = 10L   // Variable (가변)
    number1 = 11L

    val number2 = 10L    // Value (불변)
    // number2 = 12L   // compile error

    var number3: Long = 10L  // Type 명시적 작성 가능

    var number4: Long
    number4 = 5L
    println(number4)    // 초기화하지않으면 complie error

    var number5: Long
    number5 = 6L
    println(number5)

    /**
     *  2. Primitive Type, Reference Type
     *  연산할때는 Reference Type 쓰지 말것 : Effective Java
     *  -> Boxing, Unboxing -> 불필요한 객체생성이 일어나기때문
     *  Kotlin official document
     *  숫자, 문자, boolean과 같은 몇몇 타입은 내부적으로 특별한 표현을 갖는다
     *  이 타입들은 실행시에 Primitive value로 표현되지만 코드에서는 평범한 클래스처럼 보인다.
     *  -> 즉 프로그래머가 boxing, unboxing을 고려하지 않아도 되도록 kotlin이 알아서 처리해준다
     */


    /**
     *  3. nullable 변수
     *  Kotlin에서 null이 변수에 들어갈 수 있다면 "타입?"dmf 사용해야 한다
     */
    var number6: Long? = 1_000L
    number6 = null

    /**
     * 4. Kotlin 객체 인스턴스화
     * Kotlin에서 객체 인스턴스화 할때에는 new를 붙이지 않아야 한다
     */
    var person = Person("wook")

    /**
     * [정리]
     * * 모든 변수는 var / val을 붙여주어야한다
     * 타입을 명시적으로 작성하지 않아도 타입이 추론된다
     * Primitive Type과 Reference Type을 구분하지 않아도 된다
     * Null이 들어갈 수 있는 변수는 타입뒤에 ?을 붙여주어야 한다 : 전혀 다른타입으로 간주
     * 객체를 인스턴스화 할때 new를 붙이지 않아야 한다
     */

}