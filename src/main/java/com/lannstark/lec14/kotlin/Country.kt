package com.lannstark.lec14.kotlin

/**
 * when
 *  - Enum class ,Sealed Class 와 함께 사용할 경우 더욱더 진가를 발휘한다
 */

fun handleCountry(country: Country){
    when(country) {
        Country.KOREA -> TODO()
        Country.AMERICA -> TODO()
    }
}
enum class Country (
    private val code: String
){
    KOREA("KO"),
    AMERICA("US"),
    JAPAN("JA");
}