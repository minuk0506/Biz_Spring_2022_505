package com.callor.memo.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MemoVO {
	public long m_seq;
	public String m_author;
	public String m_date;
	public String m_time;
	public String m_memo;
	public String m_image;
}
