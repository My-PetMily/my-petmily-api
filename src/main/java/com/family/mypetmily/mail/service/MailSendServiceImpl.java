package com.family.mypetmily.mail.service;

import com.family.mypetmily.mail.model.SendMailDto;
import com.family.mypetmily.mail.service.inter.MailSendService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

/**
 * description      :
 * packageName      : com.family.mypetmily.mail.service
 * date             : 2023-03-16
 * author           : SuJeong Gong
 * ================================================================
 * DATE             AUTHOR              NOTE
 * ----------------------------------------------------------------
 * 2023-03-16       SuJeong Gong        최초작성
 */
@Service
public class MailSendServiceImpl implements MailSendService {

	private final JavaMailSender mailSender;

	@Value("${spring.mail.username}")
	private final String FROM_MAIL;

	public MailSendServiceImpl(@Value("${spring.mail.username}") String mail, JavaMailSender mailSender) {
		this.FROM_MAIL = mail;
		this.mailSender = mailSender;
	}

	@Override
	public void sendAuthMail(SendMailDto sendMail) throws MessagingException {
		MimeMessage mail = mailSender.createMimeMessage();
		mail.setHeader("Content-Type", "text/plain; charset=utf-8");
		mail.addRecipients(Message.RecipientType.TO, sendMail.getToEmail());
		mail.setSubject(sendMail.getTitle());
		mail.setText(sendMail.getContent(), sendMail.getEncoding());
		mail.setFrom(FROM_MAIL);
		mailSender.send(mail);
		return;
	}
}