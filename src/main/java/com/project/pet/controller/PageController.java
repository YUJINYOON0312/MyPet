package com.project.pet.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PageController {

	@GetMapping("/dogs")
	public String cateDog() {
		
		return "board/dogs";
	}
}
