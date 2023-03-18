package com.family.mypetmily.config;

import com.family.mypetmily.common.RequestInterceptor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * description      : 웹 관련 설정
 * packageName      : com.family.mypetmily.config
 * date             : 2023-03-04
 * author           : SuJeong Gong
 * ================================================================
 * DATE             AUTHOR              NOTE
 * ----------------------------------------------------------------
 * 2023-03-04       SuJeong Gong        최초작성
 */
@Configuration
@RequiredArgsConstructor
public class WebConfig extends WebMvcConfigurerAdapter implements WebMvcConfigurer {

	@NonNull
	private RequestInterceptor requestInterceptor;

	@Override
	public void addCorsMappings(CorsRegistry registry) {
		registry.addMapping("/**")
				.allowedOriginPatterns("*") // 허용할 출처
//				.allowedMethods("*") // 허용할 HTTP method
				.allowCredentials(true) // 쿠키 인증 요청 허용
				.maxAge(3000);// 원하는 시간만큼 pre-flight 리퀘스트를 캐싱
	}

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(requestInterceptor);
	}
}