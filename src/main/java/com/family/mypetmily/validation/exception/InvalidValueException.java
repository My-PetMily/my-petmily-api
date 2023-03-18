package com.family.mypetmily.validation.exception;

import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * description      : 유효성 조건에 대한 검사를 통과하지 못했을 때
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
public class InvalidValueException extends ValueException {
	/**
	 * 리턴 코드 값
	 */
	private String code = "-4002";

	public InvalidValueException(String valueName, String invalidValue) {
		super(String.format("%s의 값이 유효성 조건을 통과하지 못했습니다. 입력값 = %s", valueName, invalidValue));
	}
}