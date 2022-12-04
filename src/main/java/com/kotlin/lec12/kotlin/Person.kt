package com.kotlin.lec12.kotlin

import com.kotlin.lec12.Movable
import com.kotlin.lec20.PersonRepository
import kotlin.reflect.KFunction1

/**
 * static
 *  - 클래스가 인스턴스 화 될때 새로운 값이 복제되지 않고 정적으로 인스턴스끼리 값 공유
 *
 * companion object
 *  - 클래스와 동행하는 유일한 오브젝트
 *  - 동반객체도 하나의 객체로 간주됨
 *  - 이름을 붙일 수 있고, interface 를 구현할수 있음
 *  - 유틸성 함수를 넣어도 되지만 최상단 파일을 활용하는것을 추천
 *
 * val : 런타임시에 변수가 할당
 * const : 컴파일시에 변수가 할당, 상수로 기본타입과 String 에만 사용가능
 *
 * 2. kotlin 싱글톤 구현
 *  - object Singleton
 *  - 객체앞에 object 붙여주면 끝
 *  
 * 3. 익명 클래스
 *  - 
 */
fun main() {
    println(Singleton.a)
    Singleton.a += 10
    println(Singleton.a)
    
    moveSomething(object : Movable {
        override fun move() {
            println("move")
        }

        override fun fly() {
            println("fly")
        }
    })
}

fun moveSomething(movable: Movable) {
    movable.move()
    movable.fly()
}

class Person (
    var name: String,
    var age: Int,
) {
    fun run(block: KFunction1<PersonRepository, Any>): Any {
        TODO("Not yet implemented")
    }

    // static 대신 companion object 사용 ( = 동행객체 )
      // companion object Factory : Log{    // 이름을 지정하는 경우
      companion object{

        private const val MIN_AGE = 1

        // Java 코드에서 Kotlin companion object 사용하려면 @JvmStatic
        @JvmStatic
        fun newBaby(name: String): Person {
            return Person(name, MIN_AGE)
        }

//        override fun log() {
//            println("Person 클래스의 동행객체 Factory")
//        }
    }
}

object Singleton {
    var a: Int = 0
}