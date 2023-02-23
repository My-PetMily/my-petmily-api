package com.family.mypetmily.validation.regex;

import org.springframework.stereotype.Component;

/**
 * description      : 정규식을 통한 유효성 검사
 * packageName      : com.family.mypetmily.validation.regex
 * date             : 2023-02-23
 * author           : SuJeong Gong
 * ================================================================
 * DATE             AUTHOR              NOTE
 * ----------------------------------------------------------------
 * 2023-02-23       SuJeong Gong        최초작성
 */
@Component
public class RegexValidUtil {
	/**
	 * 닉네임 정규식 검사
	 *
	 * @param nickname 닉네임
	 * @return
	 */
	static public boolean checkNickname(String nickname) {
		return nickname.matches("[\\d\\w\\_\\-\\.]{2,20}");
	}
}