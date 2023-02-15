package com.project.pet.controller;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.apache.bcel.classfile.Module.Require;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
	public String signin(@RequestParam(value = "error", required = false) String error,
			@RequestParam(value = "exception",required = false) String exception, Model model, HttpServletRequest request) {
		//에러와 예외를 모델에 담아 뷰로
		model.addAttribute("error",error);
		model.addAttribute("exception",exception);
		String uri = request.getHeader("Referer");
		if(uri != null) {
			request.getSession().setAttribute("prevPage", uri);
		}
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
