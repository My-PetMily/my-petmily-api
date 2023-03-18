package com.family.mypetmily.user.service.inter;

import com.family.mypetmily.user.model.User;
import com.family.mypetmily.validation.exception.ValueException;

import java.util.Map;

/**
 * description      :
 * packageName      : com.family.mypetmily.user.service.inter
 * date             : 2023-02-24
 * author           : SuJeong Gong
 * ================================================================
 * DATE             AUTHOR              NOTE
 * ----------------------------------------------------------------
 * 2023-02-24       SuJeong Gong        최초작성
 */
public interface JoinService {


	/**
	 * 유저 추가하는 서비스
	 *
	 * @param user        추가할 유저
	 * @param authService 유저에 대한 인증 서비스
	 * @return
	 */
	Map<String, Object> addUser(User user, AuthService authService) throws ValueException;
}