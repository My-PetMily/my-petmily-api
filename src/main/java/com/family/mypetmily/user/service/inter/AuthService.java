package com.family.mypetmily.user.service.inter;

import com.family.mypetmily.validation.exception.ValueException;

/**
 * description      : 인증 관련 서비스 interface
 * packageName      : com.family.mypetmily.user.service.inter
 * date             : 2023-02-23
 * author           : SuJeong Gong
 * ================================================================
 * DATE             AUTHOR              NOTE
 * ----------------------------------------------------------------
 * 2023-02-23       SuJeong Gong        최초작성
 */

public interface AuthService {
	/**
	 * 사용 가능한 닉네임
	 *
	 * @param nickname 확인할 닉네임
	 * @return 사용 가능 여부
	 */
	boolean canUseNickname(String nickname) throws ValueException;

	/**
	 * 사용 가능한 이메일
	 *
	 * @param email 확인할 이메일
	 * @return 사용 가능 여부
	 */
	boolean canUseEmail(String email) throws ValueException;
}