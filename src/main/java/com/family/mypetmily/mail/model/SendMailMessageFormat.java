package com.family.mypetmily.mail.model;

/**
 * description      : 메일 전송시 지정된 포맷
 * packageName      : com.family.mypetmily.mail.model
 * date             : 2023-03-16
 * author           : SuJeong Gong
 * ================================================================
 * DATE             AUTHOR              NOTE
 * ----------------------------------------------------------------
 * 2023-03-16       SuJeong Gong        최초작성
 */
public enum SendMailMessageFormat {

	JOIN_AUTH_CODE("[마이펫밀리]회원 가입 인증 코드", "회원가입 코드 : {0}"),
	JOIN_WELCOME("[마이펫밀리] 회원가입 확인", "{0}님 마이펫밀리의 회원이 되신 것을 축하드립니다");

	public final static String FOOTER = "<br/><br/>본 메일은 <a href='sujeong0.cafe24.com:3000'>마이펫밀리 사이트</a>에서 전송한 메일입니다.<br/>[마이펫밀리] 고객센터 : 0_sujeong@naver.com<br/>";
	/** 메일 제목 */
	public String title;
	/** 메일 내용 content format */
	public String contentFormat;


	private SendMailMessageFormat(String title, String format) {
		this.title = title;
		this.contentFormat = format;
	}
}