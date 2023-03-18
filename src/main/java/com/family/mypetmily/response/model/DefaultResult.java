package com.family.mypetmily.response.model;

import lombok.Getter;
import lombok.Setter;

/**
 * description      : API의 기본 result
 * packageName      : com.family.mypetmily.response.model
 * date             : 2023-02-23
 * author           : SuJeong Gong
 * ================================================================
 * DATE             AUTHOR              NOTE
 * ----------------------------------------------------------------
 * 2023-02-23       SuJeong Gong        최초작성
 */
@Getter
@Setter
public class DefaultResult {
	/** 결과 */
	private String result;

	public DefaultResult(String result) {
		this.result = result;
	}
}