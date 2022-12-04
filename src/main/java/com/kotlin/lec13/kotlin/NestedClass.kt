package com.kotlin.lec13.kotlin

/**
 * 내부클래스
 *  - 1. 숨겨진 외부 클래스 정보를 가지고 있어 참조를 해지하지 못하는 경우
 *     메모리 누수가 생길 수 있고 이를 디버깅 하기 어렵다
 *  - 2. 내부 클래스의 직렬화 형태가 명확하게 정의되지 않아 직렬화에 있어 제한이 있다다
 *  - 3. 클래스 안에 클래스를 만들 때는 static 클래스를 사용 할 것
 *  - 4. 기본적으로 바깥 클래스 참조하지 않지만 참조하고 싶다면 inner 키워드를 추가
 *  */


class House (
    private val address: String,
    private val livingRoom: LivingRoom
) {
    // 권장되지 않는 클래스 안의 클래스를 만들때는 inner 키워드 직접 붙여야 함
    inner class LivingRoom(
        private val area: Double,
    ) {
        val address: String
        // 바깥 클래스 참조를 위해 this@바깥클래스 사용
            get() = this@House.address
    }
}