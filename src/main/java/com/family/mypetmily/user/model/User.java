package com.family.mypetmily.user.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * description      : 유저 정보 관리 class
 * packageName      : com.family.mypetmily.user.model
 * date             : 2023-02-24
 * author           : SuJeong Gong
 * ================================================================
 * DATE             AUTHOR              NOTE
 * ----------------------------------------------------------------
 * 2023-02-24       SuJeong Gong        최초작성
 */
@Getter
@Setter
@AllArgsConstructor
public class User {
	/** 유저 고유번호 */
	private int userSeq;

	/** 유저 닉네임 */
	private String nickname;

	/** 유저 이메일 */
	private String email;

	/** 유저 비밀번호 */
	private String password;

	/** 유저 타입 */
	private String type;

	/** 유저 회원가입 날짜 */
	private String createDate;

	/** 유저 회원 정보 최종 수정일 */
	private String updateDate;

	/** 유저 이메일 인증 여부 */
	private boolean authEmailYn;


}