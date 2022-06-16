package com.schoolverse.app.persistence;

import com.schoolverse.app.model.BelongVO;

public interface BelongDao extends GenericDao<BelongVO, String> {
	public long findAcaCodeById(String username);
}
