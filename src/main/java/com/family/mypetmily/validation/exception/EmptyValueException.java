package com.family.mypetmily.validation.exception;

import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * description      : 값이 빈값일때에 대한 예외
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
public class EmptyValueException extends ValueException {
	/**
	 * 리턴 코드 값
	 */
	private String code = "-4001";

	public EmptyValueException(String valueName) {
		super(String.format("%s의 값이 null이거나 비어있습니다.", valueName));
	}
}