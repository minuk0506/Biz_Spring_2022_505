package com.callor.school.dbconfig;

public class DBContract {

	public static class ST { // 문자열 여러줄을 만들때 붙어버릴 수 있으니 앞뒤로 띄어쓰기
		public static final String SELECT = " SELECT st_num, "
				+ " st_name, st_dept, st_addr, st_tel, st_grade "
				+ " FROM tbl_student" ;
		public static final String INSERT = "";
	}
	public static class ST_COL {
		public static final String ST_NUM = "st_num";
		public static final String ST_NAME = "st_name";
		public static final String ST_ADDR = "st_addr";
		public static final String ST_DEPT = "st_dept";
		public static final String ST_TEL = "st_tel";
		public static final String ST_GRADE = "st_grade";
	}
}
