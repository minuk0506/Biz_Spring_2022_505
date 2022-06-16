package com.schoolverse.app.persistence;

import java.util.List;

import com.schoolverse.app.model.ClassVO;
import com.schoolverse.app.model.ScheduleVO;

public interface ClassDao extends GenericDao<ClassVO, String> {
	public List<ScheduleVO> findScheduleByClassCode(long c_code);
	public List<ClassVO> findByAcaCode(long aca_code);
}
