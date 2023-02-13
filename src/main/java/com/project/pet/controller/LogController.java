package com.project.pet.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.project.pet.entity.MemberRegDTO;
import com.project.pet.service.MemberService;

@Controller
public class LogController {

	@Autowired
	private MemberService service;
	
	@GetMapping("/")
	public String index() {
		return "index";
	}
	
	@GetMapping("/sign-in") //로그인
	public String signin() {
		return "sign/signin";
	}
	
	@GetMapping("/sign-up") //회원가입
	public String signup() {
		return "sign/signup";
	}
	
	/**
	 * 회원가입 
	 * @param dto 데이터 삽입
	 * @return 회원가입시 로그인창으로 이동
	 */
	
	@PostMapping("/join") //회원가입, form action에 맞춰주기
	public String memReg(MemberRegDTO dto) {
		service.registration(dto);
		return "redirect:/sign-in";
	}
}
