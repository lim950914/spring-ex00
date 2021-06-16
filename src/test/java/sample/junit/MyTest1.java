package sample.junit;

import static org.junit.Assert.*;

import org.junit.Test;

public class MyTest1 {

	@Test // test 메소드는 public void 여야 하고 파라미터가 없어야함 메소드명은 상관없음
	public void test() {
//		fail("Not yet implemented");
		int i = 3;
		if (i != 3) {
			fail("i는 3이 아닙니다");
		}
	}
	
	@Test // 같으면 성공
	public void equals() {
		int i = 3;
		boolean b = true;
		Object c = null;
		
		assertEquals(i, 3);
		assertEquals(b, true);
		assertTrue(b);
		assertNull(c);
	}
	
	@Test // 다르면 성공
	public void notEquals() {
		int i = 5;
		boolean b = false;
		Object c = new Object();
		
		assertNotEquals(i, 3);
		assertFalse(b);
		assertNotNull(c);
	}
}
