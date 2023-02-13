package com.project.pet.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.project.pet.entity.MemberEntityRepo;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class MyUserDetailsService implements UserDetailsService{
	
	@Autowired
	MemberEntityRepo mRepo;

	//빨간줄 Add클릭하면 생성, DB의 테이블에서 인증처리를 하기 위한 메서드
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		//.orElseThrow 예외처리 해주어야함
		return new MyUserDetails(mRepo.findByEmail(username)
				.orElseThrow(()-> new UsernameNotFoundException("존재하지 않는 이메일입니다!")));
	}


}
