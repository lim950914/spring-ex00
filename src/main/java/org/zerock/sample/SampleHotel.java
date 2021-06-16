package org.zerock.sample;

import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@Component
public class SampleHotel {
	
	private Chef chef;
	
	public SampleHotel(Chef chef) {
		
		this.chef = chef;
		
	}
}
