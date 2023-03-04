package com.family.mypetmily.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
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
@EnableWebMvc
public class WebConfig extends WebMvcConfigurerAdapter {

	@Override
	public void addCorsMappings(CorsRegistry registry) {
		registry.addMapping("/**")
				.allowedOriginPatterns("http[s]{0,1}\\:\\/\\/(127\\.0\\.0\\.1|localhost)\\:3000")
				.maxAge(3600);
	}

}