package org.zerock.controller.lecture.initbinder;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.InitBinder;
import org.zerock.controller.lecture.initbinder.InitBinderEx1Controller.MyData;
import org.zerock.controller.lecture.initbinder.InitBinderEx1Controller.MyDataEditor;

import lombok.extern.log4j.Log4j;

@ControllerAdvice // 모든 컨트롤러에 먼저 일을 실행 시키는 어노테이션 initbinder 등 사용할때 주로 사용
@Log4j
public class InitBinderEx1ControllerAdvice {

//	@InitBinder
//	public void method1() {
//		log.info("advice method1");
//	}
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		log.info("init binder");
		
		binder.registerCustomEditor(MyData.class, new MyDataEditor());
		
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
	}
	
	// date 타입 변환시켜 주는 메소드
		// https://docs.spring.io/spring-framework/docs/current/reference/html/web.html#spring-web
		// InitBinder 핸들러 메소드가 일하기전 실행하는 메소드라는 개념
		// ControllerAdvice에서  실행 가능
//		@InitBinder 
//	    public void initBinder(WebDataBinder binder) {
//	        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
//	        dateFormat.setLenient(false);
//	        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true)); // true 빈것 허용 false 안 허용
//	    }
	
}
