package com.kotlin.lec20

import com.kotlin.lec12.kotlin.Person

/**
 * scope : 영역
 * function : 함수
 *
 * scope function : 람다를 사용해 일시적인 영역을 만들고 코드를 더 간결하게 만들거나, method chaning 활용하는 함수
 * 종류
 *  1. let : 확장함수 O, 람다의 결과를 반환, it 사용(확장함수의 수신객체를 호출할때)
 *  2. run : 확장함수 O, 람다의 결과를 반환, this 사용
 *  3. also : 확장함수 O, 객체 그 자체를 반환, it 사용
 *  4. apply : 확장함수 O, 객체 그 자체를 반환, this 사용
 *  5. with : 확장함수 아님
 *   - with(파라미터, 람다) : this 를 사용해 접근, this 생략 가능
 *
 * 확장함수의 특징
 *  - 멤버변수를 사용하는것처럼 사용된다
 *  - 본인 자신을 this 로 호출하고, 생략할 수 있다
 *
 * this : 생략이 가능한 대신, 다른 이름을 붙일 수 없다
 * it : 생략이 불가능한 대신, 다른 이름을 붙일 수 있다
 *
 * let 사용시기
 * - 1. 하나 이상의 함수를 call chain 결과로 호출할때
 * - 2. non-null 값에 대해서만  code block 을 실행시킬때
 * - 3. 일회성으로 제한된 영역에 지역 변수를 만들때
 *
 * scope function 사용
 * run : 객체 초기화와 반환값 계산을 동시에 해야 할때 사용
 * apply : 객체 그 자체가 반환된다, 객체 설정을 할때 객체를 수정하는 로직이 call chain 중간에 필요할때
 * also : 객체 그 자체가 반환, 객체를 수정하는 로직이 call chain 중간에 필요할때
 * with : 특정 객체를 다른 객체로 변환해야하는데 모듈간의 의존성에 의해 정적팩토리 혹은 toClass 함수를 만들기 어려울때
 *  -> 객체를 Converting 해야 하는데 한쪽에 로직을 넣기 어려울때
 */

data class Person (
    val name: String,
    val age: Int
)

fun main() {
    letItem()
    runItem()
    applyItem()
    alsoItem()
    example()
}

fun printPerson(person: Person?) {
    // Safe Call (?.) 사용 : person null 아닐때 let 호출
    person?.let{
        println(it.name)
        println(it.age)
    }
//    if (person != null) {
//        println(person.name)
//        println(person.age)
//    }

    val value1 = person?.let {  // return age
        it.age
    }

    val value2 = person?.run {  // return age
        this.age
    }

    val value3 = person?.also { // return Person
        it.age
    }

    val value4 = person?.apply { // return Person
        this.age
    }

    // 하나 이상의 함수를 call chain 결과로 호출할때
    val strings = listOf("APPLE", "CAR", "BANANA")
    strings.map { it.length }
        .filter { it > 3 }
        .let(::println) // let { length -> println(length) }

    // non-null 값에 대해서만  code block 을 실행시킬때
    val str: String? = "apple"
    val length = str?.let { // null 일수도 있는 문자열
        println(it.uppercase())
        it.length
    }
}

fun letItem() {
    // 일회성으로 제한된 영역에 지역 변수를 만들때
    val numbers = listOf("one", "two", "three", "four", "five", "six", "seven", "eight")
    val modifiedFirstItem = numbers.first() // 첫번째 원소를 가져와서
        .let { firstItem ->  // 첫번째 원소에 대한 가공
            if (firstItem.length >= 5) firstItem else "!$firstItem!"
        }.uppercase()
    println(modifiedFirstItem)  // 출력
}

fun runItem() {
    // 객체를 만들어 DB에 바로 저장하고 그 인스턴스를 활용
    val person = Person("wook", 30).run(PersonRepository::save)

    val person2 = Person("wook", 30).run {
        // hobby = "영화"
        PersonRepository.save(this)
    }

    val person3 = PersonRepository.save(Person("wook", 30))
}

fun applyItem() {
    fun createPerson(
        name: String,
        age: Int,
        hobby: String,
    ): Person {
        return Person(
            name = name,
            age = age
        ).apply{
//        this.hobby = hobby
        }
    }
    val person = Person("wook",30)
    // person.apply { this.growOld() }
        .let { println(it) }
}

fun alsoItem() {
    mutableListOf("one", "two", "three")
        .also { println("the list elements before adding new one : $it") }
        .add("four")

    val numbers = mutableListOf("one", "two", "three")
    println("the list elements before adding new one : $numbers")
    numbers.add("four")
}

fun example() {
    //
//    if (person != null && person.isAdult) {
//        view.showPerson(person)
//    } else {
//        view.showError()
//    }
//
//    //
//    person?.takeIf { it.isAdult }
//        ?.let(view::showPerson)
//        ?: view.showError()
}
