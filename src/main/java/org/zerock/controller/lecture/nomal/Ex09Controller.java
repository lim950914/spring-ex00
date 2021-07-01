package org.zerock.controller.lecture.nomal;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.zerock.controller.lecture.domain.User;

import lombok.extern.log4j.Log4j;

@Controller
@Log4j
@RequestMapping("/ex09/*")
public class Ex09Controller {
	
	@RequestMapping("/sub01")
	public String method01(RedirectAttributes rttr) {
		log.info("ex09, sub01 method");
		
		rttr.addAttribute("name", "jin");
		rttr.addAttribute("id", 300);
		
		return ("redirect:sub02"); // 상대경로
//		return ("redirect:/ex09/sub02"); // 절대경로
	}
	
	@RequestMapping("/sub02")
	public void method02() {
		log.info("ex09, sub02 method");
	}
	
	@RequestMapping("/sub03")
	public String method03(RedirectAttributes rttr) {
		log.info("ex09, sub03 method");
		
//		rttr.addAttribute("user", new User()); 객체x
		
		User user = new User();
		user.setId("lim");
		user.setAge(27);
		rttr.addFlashAttribute("user", user); // 객체o
		
		return "redirect:sub04";
	}
	
	@RequestMapping("/sub04")
	public void method04(Model model) {
		log.info("ex09, sub04 method");
		
		log.info(model.asMap().get("user"));
	}
}










