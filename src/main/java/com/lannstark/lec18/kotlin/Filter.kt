package com.lannstark.lec18.kotlin

val fruits = listOf(
    Fruit(0, "사과", 1_000, 2_000),
    Fruit(1,"사과",1_000, 2_000),
    Fruit(2, "사과",1_000, 2_000),
    Fruit(3,"사과",1_000, 2_000),
    Fruit(4, "바나나",3_000, 4_000),
    Fruit(5, "바나나",3_000, 4_000),
    Fruit(6, "바나나",3_000, 4_000),
    Fruit(7, "바나나",3_000, 4_000),
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


    // 4. index in map
    val applePrices2 = fruits.filter { fruit -> fruit.name == "사과"}
        .mapIndexed{ idx, fruit ->
            println(idx)
            fruit.currentPrice
    }

    // 5. filter
    val values = fruits.filter { fruit -> fruit.name == "사과"}
        .mapNotNull { fruit -> fruit.nullOrValue() }

    // 6. all, 조건을 모두 만족하면 true 그렇지 않으면 false
    val isAllApple = fruits.all { fruit -> fruit.name == "사과"}

    // 7. none, 조건을 모두 불만족하면 true, 그렇지 않으면 false
    val isNoApple = fruits.none { fruit -> fruit.name == "사과"}

    // 8. any : 조건을 하나라도 만족하면 true, 그렇지 않으면 false
    val isNoApple2 = fruits.any { fruit -> fruit.factoryPrice >= 10_000 }

    // 9. count : 개수를 셈, list.size() 와 같음
    val fruitCount = fruits.count()

    // 10. sortedBy : (오름차순) 정렬
    val fruitSorted = fruits.sortedBy { fruit -> fruit.currentPrice}

    // 11. sortedByDescending : (내림차순) 정렬
    val fruitSortedDescending = fruits.sortedByDescending { fruit -> fruit.currentPrice }

    // 12. distinctBy : 변형된 값을 기준으로 중복 제거
    val distinctFruitNames = fruits.distinctBy { fruit -> fruit.name }
        .map { fruit -> fruit.name }

    // 13. first : 첫번째 값을 가져온다, last : 마지막 값을 가져온다 (무조건 null 아니여야)
    val fruitFirst = fruits.first() // fruits.last()

    // 14. firOrNull : 첫번째 값 또는 null 가져온다, lastOrNull : 첫번째 값 또는 null 가져온다
    val fruitFirstOrNull = fruits.firstOrNull() // fruits.lastOrNull()

    // 15. List to Map (과일이름 -> List<과일이름>
    val map: Map<String, List<Fruit>> = fruits.groupBy { fruit -> fruit.name }

    // 16. Map to List (과일 이름 -> List<출고가> Map)
    val map2: Map<String, List<Long>> = fruits
        .groupBy({fruit -> fruit.name}, {fruit -> fruit.factoryPrice })

    // 17. List to Map (id 기준 출고가 Map)
    val map3: Map<Long, Long> = fruits
        .associateBy({fruit -> fruit.id}, {fruit->fruit.factoryPrice})
}

