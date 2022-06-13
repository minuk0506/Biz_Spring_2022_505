package com.schoolverse.app.persistence;

import java.util.List;

import com.schoolverse.app.model.ClassVO;
import com.schoolverse.app.model.ScheduleVO;

public interface ClassDao extends GenericDao<ClassVO, String> {
	public List<ScheduleVO> findScheduleByClassCode(String c_code);
	public List<ClassVO> findByAcaCode(String aca_code);
}
