package org.zerock.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.zerock.mapper.TxTest1Mapper;

import lombok.Setter;

@Service
@Transactional // 메소드가 실행될때 밑에 조건 예시로 실패해도 같이 실패 성공도 같이 성공
public class TxTest1Service {
	
	@Setter(onMethod_ = @Autowired)
	private TxTest1Mapper mapper;
	
//	@Transactional
	public void insert(String name) {
		mapper.insert(name);
		mapper.insert(name + name);
	}
}
