package org.zerock.mapper;

public interface TimeMapper {
	
	@Select("SELECT now()")
	public String getTime();
}
