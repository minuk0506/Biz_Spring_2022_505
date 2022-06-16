package com.schoolverse.app.persistence;

import java.util.List;

import com.schoolverse.app.model.TeacherVO;

public interface TeacherDao extends GenericDao<TeacherVO, String> {
	public List<TeacherVO> findByAcaTeacher(long aca_teacher);
}
