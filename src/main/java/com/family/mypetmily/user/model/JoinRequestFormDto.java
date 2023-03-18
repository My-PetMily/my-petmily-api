package com.family.mypetmily.user.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

/**
 * description      : 회원가입 요청 데이터
 * packageName      : com.family.mypetmily.user.model
 * date             : 2023-02-23
 * author           : SuJeong Gong
 * ================================================================
 * DATE             AUTHOR              NOTE
 * ----------------------------------------------------------------
 * 2023-02-23       SuJeong Gong        최초작성
 */
@Getter
@Setter
@ApiModel(value = "회원가입 요청 Request Data", description = "회원가입 요청시 보내는 요청 데이터")
public class JoinRequestFormDto {

	/** 유저 닉네임 */
	@NotBlank(message = "nickname 값이 비어서는 안됩니다.")
	@ApiModelProperty(value = "유저 닉네임", example = "testNickname")
	private String nickname;

	/** 유저 타입- 일반 유저 : USER, 가게유저 : store */
	@NotBlank(message = "userType 값이 비어서는 안됩니다.")
	@Pattern(regexp = "USER|STORE", message = "userType 값은 [USER, STORE] 이 중 하나의 값이어야 합니다.")
	@ApiModelProperty(value = "유저 타입", example = "USER")
	private String userType;

	/** 유저 이메일 */
	@NotBlank(message = "userEmail 값이 비어서는 안됩니다.")
	@Email(message = "userEmail 값은 이메일 형식이어야 합니다.")
	@ApiModelProperty(value = "유저 이메일", example = "test@test.com")
	private String userEmail;

	/** 유저 비밀번호 */
	@NotBlank(message = "password 값이 비어서는 안됩니다.")
	@ApiModelProperty(value = "유저 비밀번호", example = "124sgw2#62")
	private String password;

	/** 유저 비밀번호 확인 */
	@NotBlank(message = "passwordCheck 값이 비어서는 안됩니다.")
	@ApiModelProperty(value = "유저 비밀번호 확인", example = "124sgw2#62")
	private String passwordCheck;

	/** 회원가입 일시 */
	@NotBlank(message = "joinDate 값이 비어서는 안됩니다.")
	@Pattern(regexp = "(19|20)[\\d]{2}-(0[1-9]|1[0-2])-(0[1-9]|[12][0-9]|3[0-1]) (0[0-9]|1[0-9]|2[0-3]):(0[0-9]|[1-5][0-9]):(0[0-9]|[1-5][0-9])\\.[\\d]{3}",
			 message = "joinDate 값은 yyyy-mm-dd HH:mm:ss.SSS 형식이어야 합니다.")

	@ApiModelProperty(value = "회원가입 일시(yyyy-mm-dd HH:mm:ss.SSS)", example = "2022-12-23 12:52:22.213")
	private String joinDate;


	/**
	 * User 클래스로 변환
	 *
	 * @return
	 */
	public User toUser() {
		return new User(-1, this.nickname, this.userEmail, this.password, this.userType, this.joinDate, null, false);
	}
}