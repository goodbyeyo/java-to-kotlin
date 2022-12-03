package com.lannstark.lec18.kotlin

data class Fruit (
    val id: Long,
    val name: String,
    val factoryPrice: Long,
    val currentPrice: Long,
) {
    fun nullOrValue() {
        TODO("Not yet implemented")
    }

//    val List<Fruit>.samePriceFilter: List<Fruit>
//        get() = this.filter(Fruit::isSamePrice)

    val isSamePrice: Boolean
        get() = factoryPrice == currentPrice


}
