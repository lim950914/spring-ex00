package org.zerock.controller.lecture.rest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/rest02/*")
@ResponseBody // 모든 메소드에 붙인 것과 같은 효과
public class Ex02RestController {
	
	@RequestMapping("/sub01")
	public String method01() {
		return "response body1";
	}
}
