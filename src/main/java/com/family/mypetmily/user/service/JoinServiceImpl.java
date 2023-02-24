package com.family.mypetmily.user.service;

import com.family.mypetmily.user.mapper.UserMapper;
import com.family.mypetmily.user.model.User;
import com.family.mypetmily.user.service.inter.AuthService;
import com.family.mypetmily.user.service.inter.JoinService;
import com.family.mypetmily.validation.exception.ValueException;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * description      : 유저 회원가입 관련 서비스
 * packageName      : com.family.mypetmily.user.service
 * date             : 2023-02-24
 * author           : SuJeong Gong
 * ================================================================
 * DATE             AUTHOR              NOTE
 * ----------------------------------------------------------------
 * 2023-02-24       SuJeong Gong        최초작성
 */
@Service
@RequiredArgsConstructor
@Slf4j
public class JoinServiceImpl implements JoinService {

	@NonNull
	private final UserMapper userMapper;

	@Override
	public Map<String, Object> addUser(User user, AuthService authService) throws ValueException {
		Map<String, Object> result = new HashMap<>();
		if (authService.canUseNickname(user.getNickname()) == false) {
			result.put("result", "fail");
			result.put("nickname", "중복됩니다.");
			return result;
		}

		//todo 이메일 중복확인도 추가해야함

		int insertCount = userMapper.insertUser(user);
		if (insertCount != 1) {
			log.error("[ERROR] join user count is not one. join user count is [{}]", insertCount);
			throw new RuntimeException("join user count is not one");
		}
		result.put("result", "ok");

		return result;
	}
}