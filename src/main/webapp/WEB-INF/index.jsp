<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>FIND ALL PAGE</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
</head>
<body>
<div>
    <a href="/person/savePage.do">رفتن به صفحه ایجاد کاربر جدید</a>

    <form action="/person/findAll.do">
        <br>
        <table class="box-table">
            <tr>
                <td>نمایش کاربرهای فعال</td>
                <td><input type="checkbox" name="active" checked/></td>
            </tr>
            <tr>
                <td>
                    <input type="submit" value="نمایش"/>
                </td>
            </tr>
        </table>

    </form>

    <table class="table table-striped table-dark" style="width: 95%; margin-left: auto;
  margin-right: auto">

        <tr>
            <td>نام</td>
            <td>نام خانوادگی</td>
            <td>کد پرسنلی</td>
            <td>کد ملی</td>
            <td>شماره تماس</td>
            <td>مدیر مستقیم</td>
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
                <td>${person.directManager.personName}</td>
                <td><a href="/person/update.do?ID=${person.ID}">بروزرسانی</a></td>
                <c:if test="${person.active != true}">
                    <td><a href="/person/active.do?ID=${person.ID}&active=false">فعال کردن</a></td>

                </c:if>
                <c:if test="${person.active == true}">
                    <td><a href="/person/deactivate.do?ID=${person.ID}&active=true">غیر فعال کردن</a></td>
                </c:if>
                <td>
                    <a href="/offRequest/offRequest.do?ID=${person.ID}">مرخصی</a>
                </td>
                <td>
                    <a href="/email/email.do?ID=${person.ID}&active=1">ایمیل</a>
                </td>
            </tr>
        </c:forEach>
    </table>
        <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
                integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
                crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"
                integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
                crossorigin="anonymous"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
            integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
            crossorigin="anonymous"></script>


</div>
</body>
</html>
