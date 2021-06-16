package org.zerock.sample;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

// 밑에 두줄은 관용처럼 사용하면됨
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j // log 객체를 사용하게 해줌
public class HotelTests {
	
	@Setter(onMethod_ = {@Autowired}) // 주입이 됬는지 안됬는지 확인, 밑에 set코드랑 같다
	private SampleHotel hotel;
	
//	@Autowired
//	public void setHotel(SampleHotel hotel) {
//		this.hotel = hotel;
//	}
	
	@Test
	public void testExist() { // 테스트
		
		assertNotNull(hotel);
		
		log.info(hotel);
		log.info("---------------------------");
		log.info(hotel.getChef());
	}
}
