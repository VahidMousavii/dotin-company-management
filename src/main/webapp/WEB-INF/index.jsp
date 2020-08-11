<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>FIND ALL PAGE</title>
    <link href="webjars/bootstrap/3.3.6/css/bootstrap.min.css"
          rel="stylesheet">
    <link href="css/custom.css"
          rel="stylesheet">
</head>
<div class="box-table">
    <a href="/person/savePage.do">رفتن به صفحه ایجاد کاربر جدید</a>

    <form action="/person/findAll.do">
        <br>
        <table class="box-table">
            <tr>
                <td>نمایش کاربرهای فعال</td>
                <td><input type="checkbox" name="c_active" checked/></td>
            </tr>
            <tr>
                <td>
                    <input type="submit" value="نمایش"/>
                </td>
            </tr>
        </table>

    </form>

    <table border="1" style="width: 100%">

        <tr>
            <td>نام</td>
            <td>نام خانوادگی</td>
            <td>کد پرسنلی</td>
            <td>کد ملی</td>
            <td>شماره تماس</td>
            <td>بروزرسانی</td>
            <td>تغییر وضعیت</td>
            <td>مرخصی</td>
            <td>ایمیل</td>
        </tr>

        <c:forEach items="${persons}" var="person">
            <tr>
                <td>${person.personName}</td>
                <td>${person.personFamily}</td>
                <td>${person.personnelCode}</td>
                <td>${person.nationalCode}</td>
                <td>${person.personPhone}</td>
                <td><a href="/person/update.do?c_ID=${person.c_ID}">بروزرسانی</a></td>
                <c:if test="${person.c_active != true}">
                    <td><a href="/person/active.do?c_ID=${person.c_ID}&c_active=false">فعال کردن</a></td>

                </c:if>
                <c:if test="${person.c_active == true}">
                    <td><a href="/person/deactivate.do?c_ID=${person.c_ID}&c_active=true">غیر فعال کردن</a></td>
                </c:if>
                <td>
                    <a href="/offRequest/offRequest.do?c_ID=${person.c_ID}&personName=${person.personName}">مرخصی</a>
                </td>
                <td>
                    <a href="/email/email.do?c_ID=${person.c_ID}&c_active=1">ایمیل</a>
                </td>
            </tr>
        </c:forEach>
    </table>
    <script src="webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>
    <script src="webjars/jquery/1.9.1/jquery.min.js"></script>
    <script src="js/custom.js"></script>
</div>
</body>
</html>
