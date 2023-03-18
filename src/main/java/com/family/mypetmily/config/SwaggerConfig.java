package com.family.mypetmily.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * description      : swagger2 설정파일
 * packageName      : com.family.mypetmily.config
 * date             : 2023-02-24
 * author           : SuJeong Gong
 * ================================================================
 * DATE             AUTHOR              NOTE
 * ----------------------------------------------------------------
 * 2023-02-24       SuJeong Gong        최초작성
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {
	/**
	 * Swagger API 세팅.
	 *
	 * @return Swagger api 리턴
	 */
	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2)
				.useDefaultResponseMessages(false)
				.apiInfo(getApiInfo())
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.family.mypetmily")) // 로딩될 패키지명
				.paths(PathSelectors.any())
				.build();
	}

	/**
	 * API 정보.
	 *
	 * @return API 정보를 담은값
	 */
	public ApiInfo getApiInfo() {
		return new ApiInfoBuilder()
				.title("마이펫밀리 API")
				.description("마이펫밀리의 API 입니다.")
				.version("1.0")
				.build();
	}
}