package com.family.mypetmily.response.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

/**
 * description      : API Response format 클래스
 * packageName      : com.family.mypetmily.response.model
 * date             : 2023-02-19
 * author           : SuJeong Gong
 * ================================================================
 * DATE             AUTHOR              NOTE
 * ----------------------------------------------------------------
 * 2023-02-19       SuJeong Gong        최초작성
 */
@Getter
@Setter
@Schema(name = "공통 Response", description = "모든 API의 공통적인 응답 명세")
public class ApiResponse {

	/**
	 * 결과값에 대한 코드
	 * 코드가 021이라면 앞의 0도같이 전달하기 위해 String 타입으로 정의
	 */
	@Schema(description = "결과값에 대한 코드\n코드가 021이라면 앞의 0도같이 전달하기 위해 String 타입으로 정의", example = "-401")
	private String code;

	/**
	 * 결과값에 대한 설명을 나타내는 메세지
	 * 에러시에는 에러 원인에 대한 참고 정보로써 변경될 수 있으므로, 예외 처리시에는 예외 코드를 이용할 것
	 */
	@Schema(description = "결과값에 대한 설명을 나타내는 메세지\n에러시에는 에러 원인에 대한 참고 정보로써 변경될 수 있으므로, 예외 처리시에는 예외 코드를 이용할 것", example = "토큰을 잘못 보냈습니다.")
	private String message;

	/**
	 * 요청에 대한 정보
	 * 어떤 요청 결과 값이든 참조 할 수 있도록 Object 타입으로 정의
	 */
	@Schema(description = "요청에 대한 정보\n어떤 요청 결과 값이든 참조 할 수 있도록 Object 타입으로 정의", example = "{\n\t\t\"token\": \"잘못 보낸 토큰 정보\"\n\t}")
	private Object result;

	public ApiResponse(String code, String message, Object result) {
		if (code == null || code.isEmpty()) {
			this.code = "";
		} else {
			this.code = code;
		}

		if (message == null || message.isEmpty()) {
			this.message = "";
		} else {
			this.message = message;
		}

		if (result == null) {
			this.result = new DefaultResult("");
		} else {
			this.result = result;
		}
	}

	public ApiResponse(String code, String message) {
		this.code = code;
		this.message = message;

		Map<String, String> result = new HashMap<>();
		this.result = result;
		//에러라면
		if (code.contains("-")) {
			result.put("errorMessage", message);
		} else {
			result.put("resultMessage", message);
		}
	}

	public ApiResponse() {
		this(null, null, null);
	}

}