<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>UPDATE PERSON PAGE</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <link rel="stylesheet" type="text/css" href="/assets/css/menu/menu.css">
</head>
<body>
<div class="topnav">
    <a href="/person/findAll.do?active=1">صفحه اصلی</a>
    <a href="/person/savePage.do">ایجاد کاربر</a>
    <a href="/offRequest/offRequest.do?ID=${loadedPerson.ID}">مرخصی</a>
    <a href="#" class="active">بروز رسانی</a>
    <a href="/email/email.do?ID=${person.ID}" >ارسال ایمیل</a>
    <a href="/email/showInbox.do?ID=${loadedPerson.ID}&active=true">صندوق دریافت</a>
    <a href="/email/showSentBox.do?ID=${loadedPerson.ID}&active=true">صندوق ارسال</a>
</div>
<form action="/person/saveUpdate.do">
    <tr>
        <td><input type="hidden" name="ID" value="${loadedPerson.ID}"/></td>
        <br>
        <td>نام</td>
        <input type="text" name="personName" value="${loadedPerson.personName}"/>
        <br>
        <td>نام خانوادگی</td>
        <input type="text" name="personFamily" value="${loadedPerson.personFamily}"/>
        <br>
        <td> شماره تماس</td>
        <input type="text" name="personPhone" value="${loadedPerson.personPhone}"/>
        <br>
        <td>
            <p>وضعیت کاربر فعال/غیرفعال</p>
            <input type="checkbox" name="active" id="active" <c:if test="${loadedPerson.active==true}">checked</c:if>>
        </td>
        <br>
        <input type="submit" value="بروز رسانی کاربر"/>
    </tr>
</form>

</body>
</html>
