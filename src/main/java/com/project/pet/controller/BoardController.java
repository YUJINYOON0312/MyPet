package com.project.pet.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BoardController {
	
	@GetMapping("/board/dogs")
	public String boardDogs() {
		return "board/dogs";
	}
	
	@GetMapping("/board/write")
	public String boardWrite() {
		return "board/write";
	}
}
