package com.family.mypetmily.user.controller;

import com.family.mypetmily.mail.model.SendMailDto;
import com.family.mypetmily.mail.model.SendMailMessageFormat;
import com.family.mypetmily.mail.service.inter.MailSendService;
import com.family.mypetmily.response.model.ApiResponseDto;
import com.family.mypetmily.user.service.inter.AuthService;
import com.family.mypetmily.validation.exception.EmptyValueException;
import com.family.mypetmily.validation.exception.InvalidValueException;
import com.family.mypetmily.validation.exception.ValueException;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.mail.MessagingException;
import java.util.UUID;

/**
 * description      : 유저 관련 인증 컨트롤러
 * packageName      : com.family.mypetmily.user.controller
 * date             : 2023-02-19
 * author           : SuJeong Gong
 * ================================================================
 * DATE             AUTHOR              NOTE
 * ----------------------------------------------------------------
 * 2023-02-19       SuJeong Gong        최초작성
 */


@Api(tags = "User Auth API", description = "유저 관련 인증, 중복확인 API")
@RestController("/auth")
@AllArgsConstructor
@Slf4j
public class AuthController {
	private final AuthService authService;
	private final MailSendService mailSendService;

	/**
	 * 닉네임 중복 테스트
	 *
	 * @param nickname 테스트 할 닉네임
	 * @return 결과
	 */
	@ApiOperation(value = "닉네임 중복 조회 API", notes = "닉네임을 변경하기 전에 사용하는 사람이 있는지, 혹은 닉네임이 조건에 맞는지 확인 해 볼 수 있는 API")
	@ApiResponses({
			@ApiResponse(code = 200, message = "조회 성공")
	})
	@GetMapping("/nickname")
	public ResponseEntity<ApiResponseDto> checkNickname(@RequestParam("nickname") final String nickname) {
		ApiResponseDto response = null;

		try {
			if (authService.canUseNickname(nickname)) {
				response = new ApiResponseDto("200", "사용해도 좋습니다.");
				log.info("사용해도 좋은 nickname 입니다. nickname = [{}]", nickname);
			} else {
				response = new ApiResponseDto("200", "이미 사용중인 닉네임 입니다.");
				log.info("중복되는 nickname 입니다. nickname = [{}]", nickname);
			}
		} catch (ValueException e) {
			if (e.getCause() instanceof EmptyValueException) {
				EmptyValueException emptyValueException = (EmptyValueException) e.getCause();
				response = new ApiResponseDto(emptyValueException.getCode(), emptyValueException.getMessage());
			} else if (e.getCause() instanceof InvalidValueException) {
				InvalidValueException invalidValueException = (InvalidValueException) e.getCause();
				response = new ApiResponseDto(invalidValueException.getCode(), invalidValueException.getMessage());
			} else {
				response = new ApiResponseDto(e.getCode(), e.getMessage());
			}
			return ResponseEntity.badRequest().body(response);
		}

		return ResponseEntity.ok().body(response);
	}

	/**
	 * 이메일 중복 테스트
	 *
	 * @param email 테스트 할 이메일
	 * @return 결과
	 */
	@ApiOperation(value = "이메일 중복 조회 API", notes = "이메일을 변경하기 전에 사용하는 사람이 있는지 확인 해 볼 수 있는 API")
	@ApiResponses({
			@ApiResponse(code = 200, message = "조회 성공")
	})
	@GetMapping("/email")
	public ResponseEntity<ApiResponseDto> checkEmail(@RequestParam("email") final String email) {
		ApiResponseDto response = null;
		try {
			if (authService.canUseEmail(email)) {
				response = new ApiResponseDto("200", "사용해도 좋습니다.");
				log.info("사용해도 좋은 email 입니다. email = [{}]", email);
			} else {
				response = new ApiResponseDto("200", "이미 사용중인 이메일 입니다.");
				log.info("중복되는 email 입니다. email = [{}]", email);
			}
		} catch (ValueException e) {
			if (e.getCause() instanceof EmptyValueException) {
				EmptyValueException emptyValueException = (EmptyValueException) e.getCause();
				response = new ApiResponseDto(emptyValueException.getCode(), emptyValueException.getMessage());
			} else if (e.getCause() instanceof InvalidValueException) {
				InvalidValueException invalidValueException = (InvalidValueException) e.getCause();
				response = new ApiResponseDto(invalidValueException.getCode(), invalidValueException.getMessage());
			} else {
				response = new ApiResponseDto(e.getCode(), e.getMessage());
			}
			return ResponseEntity.badRequest().body(response);
		}

		return ResponseEntity.ok().body(response);
	}

	@GetMapping("/auth-code")
	public ResponseEntity<ApiResponseDto> sendAuthCodeMail(@RequestParam("email") final String email) {
		ApiResponseDto response = null;

		try {
			String code = String.format("%.6s", UUID.randomUUID());
			SendMailDto authCodeMail = new SendMailDto(new String[]{code}, email, "UTF-8", SendMailMessageFormat.JOIN_AUTH_CODE);
			mailSendService.sendAuthMail(authCodeMail);
			response = new ApiResponseDto("200", "인증 코드 메일 전송에 성공했습니다.");
		} catch (MessagingException e) {
			// 발송 실패에 원인을 리턴 받을 수 없고, 발송 실패인지에 대해 정확하게 알 수 없음
			response = new ApiResponseDto("200", "인증 코드 메일 전송 중 오류가 발생했습니다.");
		}
		return ResponseEntity.ok().body(response);
	}
}