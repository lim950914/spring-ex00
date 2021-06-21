package org.zerock.mapper;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.zerock.domain.Test1VO;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class Test1MapperTests {
	
	@Setter(onMethod_ = @Autowired)
	private Test1Mapper mapper;
	
	@Test
	public void testGetList() {
		assertNotNull(mapper);
		
		List<Test1VO> list = mapper.getList();
		
		assertTrue(list.size() > 0);
	}
	
	@Test
	public void testInsert() {
		Test1VO test1 = new Test1VO();
		test1.setName("nnnn");
		test1.setAge(88);
		
		int cnt = mapper.insert(test1);
		assertEquals(1, cnt);
	}
	
	@Test
	public void testInsertSelectKey() {
		Test1VO test1 = new Test1VO();
		test1.setName("새 이름");
		test1.setAge(44);
		
		assertEquals(0, test1.getId());
		
		int cnt = mapper.insertSelectKey(test1);
		
		assertEquals(1, cnt);
		assertNotEquals(0, test1.getId());
	}
	
	@Test
	public void testRead() {
		Test1VO vo = mapper.read(1);
		
		assertNotNull(vo);
		assertEquals(1, vo.getId());
		assertEquals("qwe", vo.getName());
		
		/* insert, 자동 증가 키값 확인 */
		Test1VO test1 = new Test1VO();
		test1.setName("새 이름");
		test1.setAge(44);

		int cnt = mapper.insertSelectKey(test1);
		
		long key = test1.getId();
		
		Test1VO newTest1 = mapper.read(key);
		
		assertNotNull(newTest1);
		assertEquals(key, newTest1.getId());
	}
	
	@Test
	public void testDelete() {
		int cnt = mapper.delete(0); // id 가 0인 레코드 삭제
		
		assertEquals(0, cnt);
		
		Test1VO test1 = new Test1VO();
		test1.setName("name");
		test1.setAge(44);
		
		mapper.insertSelectKey(test1);
		
		cnt = mapper.delete(test1.getId());
		assertEquals(1, cnt);
	}
	
	@Test
	public void testUpdate() {
		long id = 5;
		
		Test1VO test1 = new Test1VO();
		test1.setId(id);
		test1.setName("abcd");
		test1.setAge(99);
		
		int cnt = mapper.update(test1);
		
		assertEquals(1, cnt);
		
		Test1VO test15 = mapper.read(id);
		assertEquals(test1.getName(), test15.getName());
		assertEquals(test1.getAge(), test15.getAge());
	}
}






















