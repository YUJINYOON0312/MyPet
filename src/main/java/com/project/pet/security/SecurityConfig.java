package com.project.pet.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.firewall.DefaultHttpFirewall;
import org.springframework.security.web.firewall.HttpFirewall;
import org.springframework.web.filter.HiddenHttpMethodFilter;

@EnableWebSecurity
@Configuration
public class SecurityConfig {

	/*
	 * @Bean public HiddenHttpMethodFilter httpMethodFilter() {
	 * HiddenHttpMethodFilter hiddenHttpMethodFilter = new HiddenHttpMethodFilter();
	 * return hiddenHttpMethodFilter; }
	 */
	
	@Bean
	PasswordEncoder passEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	//DB의 인증정보를 이용해서 인증처리하는 service
	@Bean
	MyUserDetailsService myUserDetailsService() {
		return new MyUserDetailsService();
	}
	
	//spring.io -> security -> java configuration 가면 볼 수 있음
	//https://docs.spring.io/spring-security/reference/servlet/configuration/java.html#_multiple_httpsecurity_instances
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http
			.authorizeRequests(authorize -> authorize
			.antMatchers("/css/**","/img/**").permitAll()
			.antMatchers("/","/**","/sign-up").permitAll() //추가안하면 회원가입이 안됐음
			.antMatchers("/admin/**").hasRole("ADMIN")	
			.anyRequest().authenticated()
			)
			.formLogin(formLogin -> formLogin
					.loginPage("/sign-in") //로그인 페이지
					.loginProcessingUrl("/sign-in")//form안의 action 경로
					.usernameParameter("email")
					.passwordParameter("pass")
					.defaultSuccessUrl("/") //로그인 성공시 이동 url
					.failureUrl("/sign-in")//로그인 실패시 이동
					.permitAll()
					)
			.logout(logout -> logout
					.logoutSuccessUrl("/sign-in"))
			.csrf(csrf -> csrf.disable())
			;
		return http.build();
	}
	
	
}
