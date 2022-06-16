package com.minuk.test.persistance;

import java.util.List;

public interface TestDao<VO, PK>{

	public List<VO> selectAll();
	public VO findById();
	public int insert(VO vo);
	
}
