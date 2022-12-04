package com.kotlin.lec07

/**
 * Kotlin 에서의 형변환
 * -> 타입이 뒤에 위치하고 new 를 사용하지 않는다
 *
 */
fun parseIntOrThrow(str: String): Int {
    try{
        return str.toInt()
    }catch(e: NumberFormatException){
        throw NumberFormatException("주어진 {$str}는 숫자가 아닙니다")
    }
}

/**
 * try - catch -> 하나의 expression 으로 간주되므로 return 가능
 */
fun parseIntOrThrow2(str: String): Int? {
    return try {
        str.toInt()
    } catch (e: NumberFormatException) {
        null
    }
}

