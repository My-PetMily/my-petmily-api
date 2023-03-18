package com.family.mypetmily.mail.service.inter;

import com.family.mypetmily.mail.model.SendMailDto;

import javax.mail.MessagingException;

/**
 * description      : 메일 관련 서비스
 * packageName      : com.family.mypetmily.mail.service.inter
 * date             : 2023-03-16
 * author           : SuJeong Gong
 * ================================================================
 * DATE             AUTHOR              NOTE
 * ----------------------------------------------------------------
 * 2023-03-16       SuJeong Gong        최초작성
 */
public interface MailSendService {
	void sendAuthMail(SendMailDto sendMail) throws MessagingException;
}