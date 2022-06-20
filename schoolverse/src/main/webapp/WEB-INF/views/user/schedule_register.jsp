<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<c:set value="${pageContext.request.contextPath}" var="rootPath" />    
<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
    <link rel="icon" type="image/x-icon" href="/static/img/favicon.ico">
    <title>schoolverse</title>
    <style>
        form.join {
            width: 70%;
            margin: 20px auto;
            padding: 20px;
        }

        form.join input,
        form.join button {
            margin: 5px;
        }

        form.join label {
            font-weight: bold;
        }

        div:not(:schdule-period) {
            display: flex;
            flex-direction: column;
        }
    </style>
</head>

<body>

    <form method="POST" class="w3-container w3-card-4 join">
        <h2>수업 추가하기</h2>
        <div class="class_block">
        
        <div>
    <div>
        <label class="w3-text-blue">수업이름</label>
        <input name="class_name" id="class_name" placeholder="class_name">
    </div>
    <div>
        <label class="w3-text-blue">수업과목</label>
        <input name="class_subject" id="class_subject" placeholder="class_subject">
    </div>
    <div>
        <label class="w3-text-blue">수업료</label>
        <input name="class_fee" id="class_fee" placeholder="class_fee">
    </div>
    
    <button type="button" class="schedule_add">수업시간 추가</button>
    
    <div class="schedule_block"></div>
    
    </div>
     <hr/>
        </div>
        <button id="btn-join" type="submit">등록하기</button>
    </form>



</body>
<script src="/static/js/schedule_register.js?asssssgasdsssf"></script>
</html>
