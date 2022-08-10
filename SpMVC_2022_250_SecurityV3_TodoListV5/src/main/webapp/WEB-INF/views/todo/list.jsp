<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set value="${pageContext.request.contextPath}" var="rootPath" />
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<style>
	div.todo_body{
		width: 60%;
		margin: 10px auto;
		padding: 2rem;
	}
	div.todo_content{
		cursor: pointer;
	}
</style>

<script>
document.addEventListener("DOMContentLoaded", () => {
	  const div_body = document.querySelector("div.todo_body");
	  div_body?.addEventListener("click", (e) => {
	    const target = e.target;
	    if(target.tagName == "DIV" && target.classList?.contains("todo_content")){
	    	const seq = target.dataset.seq
	    	document.location.href = "${rootPath}/todo/update?seq=" + seq
	    } else if(target.tagName == "SPAN" && target.classList?.contains("todo_content")){
		    const seq = target.dataset.seq
		    document.location.href = "${rootPath}/todo/comp?seq=" + seq
	    }
	  });
	});
</script>

<div class="todo_body w3-card-4">
	<sec:authorize access="isAuthenticated()">
		<h1 class="w3-text-blue"><sec:authentication property="principal.username" />님의 TODO LIST</h1>
		<c:forEach items="${TODOS}" var="TODO">
			<div data-seq="${TODO.seq}" title="시작 : ${TODO.date}, ${TODO.time}" class="todo_content w3-border w3-padding-16 w3-margin w3-tooltip">${TODO.todo}
			<span data-seq="${TODO.seq}" class="todo_content w3-text">(시작 : ${TODO.date}${TODO.time})</span></div>
		</c:forEach>
		<form:form>
			<input name="todo" value="${TODO.todo}" placeholder="TODO Insert" class="w3-input w3-border"/>
		</form:form>
	</sec:authorize>
</div>