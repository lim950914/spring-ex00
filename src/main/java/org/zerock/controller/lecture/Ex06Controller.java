package org.zerock.controller.lecture;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.log4j.Log4j;

@Controller
@Log4j
@RequestMapping("/ex06/*")
public class Ex06Controller {
	
	@RequestMapping("/sub01")
	public String method01() {
		log.info("ex06, sub01 method");
		
		return "ex06/sub01"; // 리턴 값을 지정해주면 밑에 url로 포워딩된다
		
		// 밑에와 같은 기능을 한다
		// request.getRequestDispatcher("/WEB-INF/viewsex06/sub01.jsp).forward(request, response); 
		// WEB-INF/views/ex06/sub01.jsp 으로포워딩 됨
	}
	
	@RequestMapping("/sub02")
	public void method02() {
		
		log.info("ex06, sub02 method");
		// 굳이 return 타입을 정해주지 않아도 포워딩됨
	}
	
	@RequestMapping("/sub03")
	public String method03() {
		log.info("ex06, sub03 method");
		
		return "forward:/ex06/sub02"; // 다른 곳에 포워딩 할 시
	}
	
	@RequestMapping("/sub04")
	public String method04() {
		log.info("ex06, sub04 method");
		
		// response.sendRedirect(request.getContextPath() + "/ex06/sub02");
		// 위에는 전에 프레임워크 사용 전
		
		return "redirect:/ex06/sub02"; // 리다이렉트
	}
}













