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

        <h2>학원등록하기</h2>
        <div class="block">
            <label class="w3-text-blue">학원이름</label>
            <input name="aca_name" id="aca_name" placeholder="aca_name">
        </div>
        <div class="block">
            <label class="w3-text-blue">학원과목</label>
            <select name="aca_subject">
                <option id="sche_day">입시</option>
                <option id="sche_day">영어</option>
                <option id="sche_day">예체능</option>
            </select>
        </div>
        <div class="block">
            <label class="w3-text-blue">교육대상</label>
            <select name="aca_age">
                <option>학생</option>
                <option>성인</option>
            </select>
        </div>
        <div class="block">
            <label class="w3-text-blue">지역</label>
            <select name="aca_region">
                <option>서구</option>
                <option>남구</option>
                <option>북구</option>
                <option>광산구</option>
            </select>
        </div>

        <div class="block">
            <label class="w3-text-blue">학원 주소</label>
            <input name="aca_addr" id="aca_addr" placeholder="aca_addr">
        </div>
        <div class="block">
            <label class="w3-text-blue">학원 소개</label>
            <textarea name="aca_info" id="aca_info"></textarea>
        </div>
        <div class="block">
            <label class="w3-text-blue">학원 이미지</label>
            <input type="file" name="aca_img" id="aca_img" placeholder="aca_img">
        </div>


        <!-- ////////////////////////////////////////////////////////////////////////////////////// -->



        <button type="button" class="teacher_add">선생님 추가</button>
        <div class="teacher_block">
        </div>
        <button id="btn-join" type="submit">등록하기</button>
    </form>



</body>
<script src="/static/js/register.js?asssssssdsssf"></script>
</html>
