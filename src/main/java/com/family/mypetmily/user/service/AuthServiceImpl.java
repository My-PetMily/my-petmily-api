package com.family.mypetmily.user.service;

import com.family.mypetmily.user.mapper.UserMapper;
import com.family.mypetmily.user.service.inter.AuthService;
import com.family.mypetmily.validation.exception.EmptyValueException;
import com.family.mypetmily.validation.exception.InvalidValueException;
import com.family.mypetmily.validation.exception.ValueException;
import com.family.mypetmily.validation.regex.RegexValidUtil;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * description      : 인증 관련 서비스 class
 * packageName      : com.family.mypetmily.user.service.inter
 * date             : 2023-02-23
 * author           : SuJeong Gong
 * ================================================================
 * DATE             AUTHOR              NOTE
 * ----------------------------------------------------------------
 * 2023-02-23       SuJeong Gong        최초작성
 */
@Service
@AllArgsConstructor
@Slf4j
public class AuthServiceImpl implements AuthService {

	private final UserMapper userMapper;

	@Override
	public boolean canUseNickname(String nickname) throws ValueException {

		if (nickname == null || nickname.length() == 0) {
			log.error("nickname EmptyValue Error. nickname = [{}]", nickname);
			ValueException error = new ValueException();
			EmptyValueException causeError = new EmptyValueException("nickname");
			error.initCause(causeError);
			throw error;
		}

		if (!RegexValidUtil.checkNickname(nickname)) {
			log.error("nickname InvalidValue Error. nickname = [{}]", nickname);
			ValueException error = new ValueException();
			InvalidValueException causeError = new InvalidValueException("nickname", nickname);
			error.initCause(causeError);
			throw error;
		}

		return userMapper.selectCountNickname(nickname) < 1;
	}

	@Override
	public boolean canUseEmail(String email) throws ValueException {

		if (email == null || email.length() == 0) {
			log.error("email EmptyValue Error. email = [{}]", email);
			ValueException error = new ValueException();
			EmptyValueException causeError = new EmptyValueException("email");
			error.initCause(causeError);
			throw error;
		}

		if (!RegexValidUtil.checkEmail(email)) {
			log.error("email InvalidValue Error. email = [{}]", email);
			ValueException error = new ValueException();
			InvalidValueException causeError = new InvalidValueException("email", email);
			error.initCause(causeError);
			throw error;
		}

		return userMapper.selectCountEmail(email) < 1;
	}
}