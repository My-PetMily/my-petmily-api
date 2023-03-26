package com.family.mypetmily.user.service.inter;

import com.family.mypetmily.user.model.User;

import javax.mail.MessagingException;

/**
 * description    : 유저의 계정 관련 서비스
 * packageName    : com.family.mypetmily.user.service.inter
 * fileName       : IntelliJ IDEA
 * author         : ggong
 * date           : 2023/03/25
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2023/03/25        ggong       최초 생성
 */
public interface HelpAccountService {

	/**
	 * 이메일로 유저 검색
	 *
	 * @param email 대상 이메일
	 * @return 검색된 유저
	 */
	User checkUserByEmail(String email);

	boolean initPassword(User user) throws MessagingException;
}
