<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>صفحه اصلی</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <link rel="stylesheet" type="text/css" href="/assets/css/menu/menu.css">
    <style>
        body {
            text-align: center;
            background: #EBF0F5;
        }
        .center {
            margin: auto;
            width: 50%;
            border: 3px solid green;
            padding: 10px;
        }
        .pcenter {
            margin: auto;
            width: 50%;
        }
        .tdlable {
            text-align: right
        }
    </style>
</head>


<body>
<div class="topnav">
    <a class="active" href="/person/findAll.do?active=1"><img src="/assets/image/home.png" width="32" height="32">صفحه اصلی</a>
    <a href="/person/savePage.do"><img src="/assets/image/profile.jpg" width="32" height="32">ایجاد کاربر</a>
</div>
<div>

    <form action="/person/findAll.do">
    <table class="center">
            <tr>
                <td class="center"><p class="pcenter">نمایش کاربرهای فعال
                <input type="checkbox" name="active" checked/>

                    <input type="submit" class="center" value="نمایش"/>
                </td>
            </tr>


        </table>

    </form>

    <table class="table table-striped table-dark" style="
    width: 98%; margin-left: auto;
  margin-right: auto">

        <tr>
            <td>نام</td>
            <td>نام خانوادگی</td>
            <td>کد پرسنلی</td>
            <td>کد ملی</td>
            <td>شماره تماس</td>
            <td>مدیر مستقیم</td>
            <td>بروزرسانی</td>
            <td>حذف/بازیابی</td>
            <td>فعال/غیرفعال</td>
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
                <td>
                    <c:if test="${person.active != true}">
                        <a href="/person/active.do?ID=${person.ID}&active=0">بازیابی</a>

                    </c:if>
                    <c:if test="${person.active == true}">
                        <a href="/person/deactivate.do?ID=${person.ID}&active=1">حذف</a>
                    </c:if>
                </td>
                <td>
                    <c:if test="${person.enable != true}">
                        <a href="/person/enable.do?ID=${person.ID}&active=true">فعال کردن</a>

                    </c:if>
                    <c:if test="${person.enable == true}">
                        <a href="/person/disable.do?ID=${person.ID}&active=true">غیرفعال کردن</a>
                    </c:if>
                </td>

                <td>
                    <a href="/offRequest/offRequest.do?ID=${person.ID}">مشاهده و درخواست مرخصی</a>
                </td>
                <td>
                    <a href="/email/email.do?ID=${person.ID}&active=1">مشاهده و ارسال ایمیل</a>
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
