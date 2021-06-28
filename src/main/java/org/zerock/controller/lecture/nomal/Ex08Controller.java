package org.zerock.controller.lecture.nomal;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.zerock.controller.lecture.domain.User;

import lombok.extern.log4j.Log4j;

@Controller
@RequestMapping("/ex08/*")
@Log4j
public class Ex08Controller {
	
	@RequestMapping("/sub01")
	public void method01(Model model) {
		log.info("ex08, sub01 method");
		
		model.addAttribute("name", "donald"); // (어트리뷰트명, 값)
		model.addAttribute("age", 22);
	}
	
	@RequestMapping("/sub02")
	public void method02(Model model) {
		log.info("ex08, sub02 method");
		
		User user = new User();
		user.setId("abc");
		user.setAge(1);
		
		model.addAttribute("user", user);
	}
	
	@RequestMapping("/sub03")
	public String method03(Model model) {
		log.info("ex08, sub03 method");
		
		User user = new User();
		user.setId("korea");
		user.setAge(5000);
		
//		model.addAttribute("user", user);
		model.addAttribute(user); 
		// ()안에 user는 class명 User에서 앞 글자만 소문자로 변경한 Attribute 값이다
		
		return "ex08/sub02";
	}
	
	// localhost:8080/controller/ex08/sub04?id=qwe&age=55
	@RequestMapping("/sub04")
	public String method04(User user, Model model) {
		log.info("ex08, sub04 method");
		
		model.addAttribute("user", user);
		
		return "ex08/sub02";
	}
	
	// 위 아래 하는 기능이 비슷하다
	
	// localhost:8080/controller/ex08/sub04?id=asd&age=5115
	@RequestMapping("/sub05")
	public String method05(@ModelAttribute("user") User user, Model model) {
		log.info("ex08, sub05 method");
		
		
		return "ex08/sub02";
	}
	

	// http://localhost:8080/controller/ex08/sub06?id=busan&age=8000
	@RequestMapping("/sub06")
	public String method06(@ModelAttribute User user, Model model) {
		log.info("ex08, sub06 method");

		return "ex08/sub02";
	}
	
	// http://localhost:8080/controller/ex08/sub07?id=usa&age=3000
	@RequestMapping("/sub07")
	public String method07(User user, Model model) {
		log.info("ex08, sub07 method");

		model.addAttribute("hello world");
		return "ex08/sub02";
	}
	
	@RequestMapping("/sub08")
	public String method08(User user) { // Model 생략해도 제 기능한다
		log.info("ex08, sub08 method");
		
		return "ex08/sub02";
	}
	
	@RequestMapping("/sub09")
	public void method09(@ModelAttribute("age") int age, @ModelAttribute("name") String name) {
		log.info("ex08, sub09 method");
		
		log.info(age);
		log.info(name);
		
	}
	
}





















