package com.family.mypetmily.user.service;

import com.family.mypetmily.mail.model.SendMailDto;
import com.family.mypetmily.mail.model.SendMailMessageFormat;
import com.family.mypetmily.mail.service.inter.MailSendService;
import com.family.mypetmily.user.mapper.UserMapper;
import com.family.mypetmily.user.model.User;
import com.family.mypetmily.user.service.inter.HelpAccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import java.util.UUID;

/**
 * description    : 유저의 계정 관련 서비스
 * packageName    : com.family.mypetmily.user.service
 * fileName       : IntelliJ IDEA
 * author         : ggong
 * date           : 2023/03/25
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2023/03/25        ggong       최초 생성
 */
@Service
@RequiredArgsConstructor
public class HelpAccountServiceImpl implements HelpAccountService {

	private final UserMapper userMapper;
	private final MailSendService mailSendService;

	@Override
	public User checkUserByEmail(String email) {
		if (email == null || "".equals(email)) {
			return null;
		}
		return userMapper.selectUserByEmail(email);
	}

	@Override
	public boolean initPassword(User user) throws MessagingException {

		boolean result = false;
		String password = user.getPassword();
		try {
			String newPassword = String.format("%.10s", String.valueOf(UUID.randomUUID()).replaceAll("-", ""));
			SendMailDto authCodeMail = new SendMailDto(new String[]{user.getNickname(), newPassword}, user.getEmail(), "UTF-8", SendMailMessageFormat.INIT_PASSWORD);
			mailSendService.sendMail(authCodeMail);
			// 성공하면 DB update 하기
			user.setPassword(newPassword);
			int updateCount = userMapper.updateUserPassword(user);
			if (updateCount == 1) {
				result = true;
			}
		} catch (MessagingException e) {
			// 원래 비밀번호로 update 하기
			user.setPassword(password);
			userMapper.updateUserPassword(user);

			// 발송 실패에 원인을 리턴 받을 수 없고, 발송 실패인지에 대해 정확하게 알 수 없음
			throw e;
		}
		return result;
	}
}
