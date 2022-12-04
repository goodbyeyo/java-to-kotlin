package com.kotlin.lec18

data class Fruit (
    val id: Long,
    val name: String,
    val factoryPrice: Long,
    val currentPrice: Long,
) {
    fun nullOrValue() {
        TODO("Not yet implemented")
    }

    val isSamePrice: Boolean
        get() = factoryPrice == currentPrice

}
