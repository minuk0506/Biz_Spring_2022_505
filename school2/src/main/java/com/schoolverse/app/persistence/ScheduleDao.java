package com.schoolverse.app.persistence;

import java.util.List;

import com.schoolverse.app.model.ScheduleVO;

public interface ScheduleDao extends GenericDao<ScheduleVO, String> {
	public List<ScheduleVO> findScheduleByClassCode(String class_code);
}
