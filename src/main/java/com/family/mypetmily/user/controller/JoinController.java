package com.family.mypetmily.user.controller;

import com.family.mypetmily.response.model.ApiResponseDto;
import com.family.mypetmily.user.model.JoinRequestFormDto;
import com.family.mypetmily.user.service.inter.AuthService;
import com.family.mypetmily.user.service.inter.JoinService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * description      : 회원가입 관련 컨트롤러
 * packageName      : com.family.mypetmily.user.controller
 * date             : 2023-02-19
 * author           : SuJeong Gong
 * ================================================================
 * DATE             AUTHOR              NOTE
 * ----------------------------------------------------------------
 * 2023-02-19       SuJeong Gong        최초작성
 */

@Api(tags = "User Join API", description = "유저 회원가입 API")
@RestController("/join")
@RequiredArgsConstructor
public class JoinController {

	@NonNull
	private final JoinService joinService;
	@NonNull
	private final AuthService authService;


	@ApiOperation(value = "유저 회원가입 조회 API", notes = "회원가입 처리를 위한 API")
	@ApiResponses({
			@ApiResponse(code = 200, message = "회원가입 성공")
	})
	@PostMapping(value = "")
	public ResponseEntity join(@Validated @RequestBody final JoinRequestFormDto joinRequestFormDto, BindingResult bindingResult) {

		ApiResponseDto result = null;
		if (bindingResult.hasErrors()) {
			return ResponseEntity.badRequest().body(new ApiResponseDto("-400", "입력값에 오류가 있습니다.", bindingResult.getAllErrors()));
		}
		try {
			Map<String, Object> joinResult = joinService.addUser(joinRequestFormDto.toUser(), authService);
			if ("fail".equals(joinResult.get("result"))) {
				result = new ApiResponseDto("-400", "회원가입에 실패했습니다.", joinResult);
			} else {
				result = new ApiResponseDto("200", "사용해도 좋습니다.");
			}
		} catch (Exception e) {
			return ResponseEntity.badRequest().body(new ApiResponseDto("-500", e.getMessage()));
		}


		return ResponseEntity.ok().body(result);
	}

}