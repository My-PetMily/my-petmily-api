package com.family.mypetmily.user.controller;

import com.family.mypetmily.mail.service.inter.MailSendService;
import com.family.mypetmily.response.model.ApiResponseDto;
import com.family.mypetmily.user.model.User;
import com.family.mypetmily.user.service.inter.HelpAccountService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.mail.MessagingException;

/**
 * description    : 유저의 계정 관련 컨트롤러
 * packageName    : com.family.mypetmily.user.controller
 * fileName       : IntelliJ IDEA
 * author         : ggong
 * date           : 2023/03/25
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2023/03/25        ggong       최초 생성
 */

@Api(tags = "User Help about Account API", value = "유저 계정 찾기 및 초기화 API")
@RestController("/help")
@Slf4j
@RequiredArgsConstructor
public class HelpAccountController {

	private final MailSendService mailSendService;
	private final HelpAccountService helpAccountService;


	@ApiOperation(value = "유저 비밀번호 초기화 요청 API", notes = "비밀번호 찾기나 변경이 아닌 비밀번호 초기화와 해당 메일로 초기화된 비밀번호 전송을 한다.")
	@ApiResponses({@ApiResponse(code = 200, message = "비밀번호 초기화 및 초기화 된 비밃번호 메일 전송 완료")})
	@GetMapping("/id")
	public ResponseEntity<ApiResponseDto> findId() {
		return null;
	}


	@ApiOperation(value = "유저 비밀번호 초기화 요청 API", notes = "비밀번호 찾기나 변경이 아닌 비밀번호 초기화와 해당 메일로 초기화된 비밀번호 전송을 한다.")
	@ApiResponses({@ApiResponse(code = 200, message = "비밀번호 초기화 및 초기화 된 비밃번호 메일 전송 완료")})
	@GetMapping("/pw")
	public ResponseEntity<ApiResponseDto> initPw(@RequestParam("email") final String email) {

		ApiResponseDto response = null;
		//validation check
		User user = helpAccountService.checkUserByEmail(email);
		if (user == null) {
			response = new ApiResponseDto("400", "사용 중이지 않은 메일이거나 메일이 제대로 입력되지 않았습니다.");
			return ResponseEntity.badRequest().body(response);
		}

		// send mail ->  password init
		try {
			boolean result = helpAccountService.initPassword(user);
			if (result) {
				response = new ApiResponseDto("200", "초기화된 비밀번호 메일 전송에 성공했습니다.");
			} else {
				response = new ApiResponseDto("500", "db 업데이트 중 문제가 발생해 비밀번호 초기화가 취소되었습니다.");
			}
		} catch (MessagingException e) {
			// 발송 실패에 원인을 리턴 받을 수 없고, 발송 실패인지에 대해 정확하게 알 수 없음
			response = new ApiResponseDto("500", "초기화된 비밀번호 메일 전송 중 오류가 발생해 비밀번호 초기화가 취소되었습니다.");
		}
		return ResponseEntity.status(Integer.valueOf(response.getCode())).body(response);
	}
}
