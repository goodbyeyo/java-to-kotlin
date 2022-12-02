package com.lannstark.lec18.kotlin

val fruits = listOf(
    Fruit("사과", 1_000),
    Fruit("사과", 1_200),
    Fruit("사과", 1_200),
    Fruit("사과", 1_500),
    Fruit("바나나", 3_000),
    Fruit("바나나", 3_200),
    Fruit("바나나", 2_500),
    Fruit("수박", 10_000),
)
fun main(){
    // 1. 인덱스
    val apples = fruits.filter { fruit -> fruit.name == "사과"}

    // 2. 인덱스
    val apples2 = fruits.filterIndexed { idx, fruit ->
        println(idx)
        fruit.name == "사과"
    }

    // 3. map
    val applePrices = fruits.filter { fruit -> fruit.name == "사과" }
        .map { fruit -> fruit.currentPrice }
    
}

