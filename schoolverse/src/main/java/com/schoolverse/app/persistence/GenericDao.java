package com.schoolverse.app.persistence;

import java.util.List;

public interface GenericDao<VO, T> {
	public List<VO> selectAll();
	public VO findById(T id);
	public int insert(VO vo);
	public int update(VO vo);
	public int delete(T id);
}
