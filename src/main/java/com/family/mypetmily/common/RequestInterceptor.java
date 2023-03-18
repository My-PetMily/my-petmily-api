package com.family.mypetmily.common;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * description      : 모든 요청에 대한 Interceptor, 분석용
 * packageName      : com.family.mypetmily.common
 * date             : 2023-03-08
 * author           : SuJeong Gong
 * ================================================================
 * DATE             AUTHOR              NOTE
 * ----------------------------------------------------------------
 * 2023-03-08       SuJeong Gong        최초작성
 */
@Component
@Slf4j
public class RequestInterceptor implements HandlerInterceptor {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

		String ip = request.getRemoteAddr();
		int port = request.getRemotePort();
		String requestURI = request.getRequestURI();
		log.info("Request from IP:[{}] PORT:[{}] - requestURI:[{}]", ip, port, requestURI);

		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
						   ModelAndView modelAndView) throws Exception {
		// Do nothing
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// Do nothing
	}
}