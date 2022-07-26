package com.callor.score.persistence;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.callor.score.model.ScoreVO;

public interface ScoreDao extends GenericDao<ScoreVO, String>{

 	public List<ScoreVO> findScore(String id);
 	public int updateScore(@Param("st_num") String st_num,@Param("sb_code") String sb_code,@Param("sc_score") String sc_score);
}
