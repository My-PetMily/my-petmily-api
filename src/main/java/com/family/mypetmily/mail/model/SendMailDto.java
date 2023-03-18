package com.family.mypetmily.mail.model;

import lombok.Getter;
import lombok.Setter;

import java.text.MessageFormat;

/**
 * description      : 메일 정보를 저장하는 Dto class
 * packageName      : com.family.mypetmily.mail.model
 * date             : 2023-03-16
 * author           : SuJeong Gong
 * ================================================================
 * DATE             AUTHOR              NOTE
 * ----------------------------------------------------------------
 * 2023-03-16       SuJeong Gong        최초작성
 */
@Getter
@Setter
public class SendMailDto {
	/** 메일 제목 */
	private String title;

	/** 메일 내용 */
	private String content;

	/** 받는 이메일 주소 */
	private String toEmail;

	/** 인코딩 설정 */
	private String encoding;

	public SendMailDto(Object[] content, String toEmail, String encoding, SendMailMessageFormat contentFormat) {
		this.title = contentFormat.title;
		this.toEmail = toEmail;
		this.encoding = encoding;
		this.setContent(content, contentFormat);
	}

	private void setContent(Object[] content, SendMailMessageFormat contentFormat) {
		StringBuffer sb = new StringBuffer((int) (contentFormat.contentFormat.length() * 1.5 + SendMailMessageFormat.FOOTER.length()));
		sb.append(MessageFormat.format(contentFormat.contentFormat, content));
		sb.append(SendMailMessageFormat.FOOTER);

		this.content = sb.toString();
	}

}