package com.family.mypetmily.validation.exception;

import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * description      : 유효성 검사에 대한 항목, 꼭 체크해야하는 항목이라 RuntimeException이 아닌 Exception을 상속
 * packageName      : com.family.mypetmily.validation.exception
 * date             : 2023-02-23
 * author           : SuJeong Gong
 * ================================================================
 * DATE             AUTHOR              NOTE
 * ----------------------------------------------------------------
 * 2023-02-23       SuJeong Gong        최초작성
 */

@Getter
@NoArgsConstructor
public class ValueException extends Exception {

	/**
	 * 리턴 코드 값
	 */
	private String code = "-400";

	ValueException(String value) {
		super(String.format("%s의 값이 부적절합니다.", value));
	}
}