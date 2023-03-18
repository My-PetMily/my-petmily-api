package com.family.mypetmily.mail.service.inter;

import com.family.mypetmily.mail.model.SendMailDto;
import com.family.mypetmily.mail.model.SendMailMessageFormat;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.mail.MessagingException;

/**
 * description      : 메일 전송 관련 테스트
 * packageName      : com.family.mypetmily.mail.service.inter
 * date             : 2023-03-16
 * author           : SuJeong Gong
 * ================================================================
 * DATE             AUTHOR              NOTE
 * ----------------------------------------------------------------
 * 2023-03-16       SuJeong Gong        최초작성
 */
@SpringBootTest
class MailSendServiceTest {

	@Autowired
	MailSendService mailSendService;

	@Test
	@DisplayName("메일 전송 테스트")
	void sendAuthMail() {
		//given
		SendMailDto sendMail = new SendMailDto(new String[]{"123456"}, "0_sujeong@naver.com", "UTF-8", SendMailMessageFormat.JOIN_AUTH_CODE);

//		//mocking
//		try {
//			given(mailSendService.sendAuthMail(any(SendMailDto.class))).willThrow();
//			given(sendMail).
//			when(mailSendService.sendAuthMail(any(SendMailDto.class))).thenThrow(MessagingException.class);
//		} catch (MessagingException e) {
//			throw new RuntimeException(e);
//		}

		//when
		MessagingException exception = null;
		try {
			mailSendService.sendAuthMail(sendMail);
		} catch (MessagingException e) {
			exception = e;
			System.out.println("메일 전송 오류");
		}
		//then
		Assertions.assertNull(exception);

	}
}