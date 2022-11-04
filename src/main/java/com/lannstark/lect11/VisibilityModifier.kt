package com.lannstark.lect11

/**
 * 접근지시어
 * public
 *  - java : 모든곳에서 접근가능
 *  - Kotlin : 동일
 *
 * protected
 *  - java : 같은 패키지 또는 하위 클래스에서만 접근 가능
 *  - kotlin : 선언된 클래스 또는 하위 클래스에서만 접근가능, 파일 (최상단)에는 사용 불가능
 *  - 코틀린에서는 패키지를 name space 관리하기 위한 용도로만 사용(가시성 제어에는 사용되지 않음)
 *
 * default
 *  - java : 같은 패키지에서만 접근 가능
 *  - kotlin : default 삭제, internal 사용 : 같은 모듈에서만 접근 가능
 *
 * private
 *  - java : 선언된 클래스내에서만 접근 가능
 *  - kotlin : 동일
 */

/**
 * 1. 기본 접근 지시어
 *  - java : default
 *  - kotlin : public
 * 2. 코틀린은 .kt 파일에 변수, 함수, 클래스 여러개를 만들 수 있다.
 * 3. Internal 은 바이트 코드상 public 이 된다
 *  - 따라서 Java 코드에서는 Kotlin 모듈의 internal 코드를 가져올수 있다
 * 4. Kotlin 의 protected <-> Java protected 다르다
 *  - Java 는 같은 패키지의 Kotlin protected 멤버에 접근 할 수 있다
 * 5. 생성자에 접근 지시어를 붙일때는 constructor 명시적으로 써주어야 한다
 * 6. 유틸성 함수를 만들때는 파일 최상단을 이용하면 편리함
 * 7. 프로퍼티의 custom setter 에 접근지시어를 붙일 수 있다
 */
class VisibilityModifier (

    internal val name: String,
    private var owner: String,
    _price: Int     // 생성자에 파라미터 생성
){
    // var price 는 public 이 생략되어 있으므로 -> getter 는 public
    var price = _price
    private set
}

