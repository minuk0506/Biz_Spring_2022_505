<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set value="${pageContext.request.contextPath}" var="rootPath" />
<style>
form {
	width: 95%;
}

form div {
	width: 80%;
	display: flex;
	margin: 5px auto;
}

form label, form input {
	padding: 8px;
}

form label {
	width: 30%;
	flex: 2;
	text-align: right;
}

form input {
	flex: 4;
	width: 65%;
	margin-left: 5px;
	width: 65%;
}

form div:last-of-type {
	justify-content: flex-end;
	margin: 10px auto;
}
fieldset {
	margin: 30px;
	padding: 30px;
}
form div:first-of-type div{
	flex:3;
	margin:0px;
}
form div:first-of-type input{
	flex:2;
	margin: 0;
}
form div:first-of-type button{
	margin-left: 5px;
}
</style>
<script src="${rootPath}/static/js/std_input_save.js?ver=2022-05-16-008"></script>
<script src="${rootPath}/static/js/std_input.js?ver=2022-05-16-008"></script>
<fieldset>
	<legend>학생정보등록</legend>
	<form method="post">
		<div>
			<label>학번</label> <div><input type="text" name="st_num">
			<button type="button" class="btn-green std-num-check">중복검사</button></div>
		</div>
		<div>
			<label>이름</label> <input type="text" name="st_name">
		</div>
		<div>
			<label>학과</label> <input type="text" name="st_dept">
		</div>
		<div>
			<label>학년</label> <input type="text" name="st_grade">
		</div>
		<div>
			<label>전화번호</label> <input type="text" name="st_tel">
		</div>
		<div>
			<label>주소</label> <input type="text" name="st_addr">
		</div>
		<div>
			<button type="button" class="btn-blue std-save">저장</button>
		</div>
	</form>
</fieldset>