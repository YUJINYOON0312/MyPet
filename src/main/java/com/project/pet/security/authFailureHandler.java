package com.project.pet.security;


import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.stereotype.Component;



@Component
public class authFailureHandler extends SimpleUrlAuthenticationFailureHandler{

	@Override
	public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException exception) throws IOException, ServletException {
		
		String errorMessage;
		
		if(exception instanceof BadCredentialsException) {
			errorMessage = "아이디 또는 비밀번호가 다릅니다. 다시 확인해주세요.";
		}
		 else if (exception instanceof UsernameNotFoundException) {
			errorMessage = "존재하지 않는 계정입니다. 회원가입 후 로그인해주세요.";
		} else {
			errorMessage = "알 수 없는 오류입니다. 관리자에게 문의하세요.";
		}
		
		errorMessage = URLEncoder.encode(errorMessage, "UTF-8");// 한글 인코딩 깨짐 문제 방지
		setDefaultFailureUrl("/sign-in?error=true&exception="+errorMessage);
		
		super.onAuthenticationFailure(request, response, exception);
		
		//https://velog.io/@jyleedev/%ED%9A%8C%EC%9B%90-%EB%A1%9C%EA%B7%B8%EC%9D%B8-%EC%8B%A4%ED%8C%A8
	}
}
