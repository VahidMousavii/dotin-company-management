<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>بروزرسانی</title>
    <title>ADD PERSON PAGE</title>
    <link href="webjars/bootstrap/3.3.6/css/bootstrap.min.css"
          rel="stylesheet">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <link rel="stylesheet" type="text/css" href="/assets/css/menu/menu.css">
    <style>
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
    <a href="/person/findAll.do?active=1" > <img src="/assets/image/home.png" width="32" height="32">صفحه اصلی </a>
    <a href="/person/savePage.do"><img src="/assets/image/profile.jpg" width="32" height="32">ایجاد کاربر</a>
    <a href="/offRequest/offRequest.do?ID=${loadedPerson.ID}"><img src="/assets/image/offRequest.jpg" width="32" height="32">مرخصی</a>
    <a href="#" class="active"><img src="/assets/image/updatePerson.png" width="32" height="32">بروز رسانی</a>
    <a href="/email/email.do?ID=${person.ID}">ارسال ایمیل<img src="/assets/image/email/email.png " width="32" height="32"></a>
    <a href="/email/showInbox.do?ID=${loadedPerson.ID}&active=true"> <img src="/assets/image/inbox.png"width="32" height="32"> صندوق دریافت</a>
    <a href="/email/showSentBox.do?ID=${loadedPerson.ID}&active=true">صندوق ارسال <img src="/assets/image/outbox.png" width="32" height="32"></a>
</div>
<div class="center">
    <p class="pcenter">بروزرسانی کاربر</p>

    <form action="/person/saveUpdate.do">
        <table class="table-responsive">
            <tr>
                <td class="tdlable">
                    <input type="hidden" name="ID" value="${loadedPerson.ID}"/>
                </td>
            </tr>
            <tr>
                <td class="tdlable">نام</td>
                <td>
                    <input type="text" name="personName" value="${loadedPerson.personName}"/>
                </td>
            </tr>
            <tr>
                <td class="tdlable">نام خانوادگی</td>
                <td>
                    <input type="text" name="personFamily" value="${loadedPerson.personFamily}"/>
                </td>
            </tr>
            <tr>
                <td class="tdlable">کد پرسنلی</td>
                <td>
                    <input type="text" name="personnelCode" value="${loadedPerson.personnelCode}"/>
                </td>
            </tr>
            <tr>
                <td class="tdlable">کد ملی</td>
                <td>
                    <input type="text" name="nationalCode" value="${loadedPerson.nationalCode}"/>
                </td>
            </tr>
            <tr>
                <td class="tdlable">
                    <label for="role"> سمت </label>
                </td>
                <td>
                    <select id="role" name="roleSubCategory.ID" id="roleSub">
                        <option value="">---</option>
                        <c:forEach items="${roles}" var="role">
                            <option <c:if test="${role.ID == loadedPerson.roleSubCategory.ID}">selected
                                    </c:if>value="${role.ID}">${role.subCategoryFarsiName}</option>
                        </c:forEach>
                    </select>
                </td>
            </tr>

            <tr>
                <td class="tdlable">
                    <label for="directManager">مدیر مستقیم</label>
                </td>
                <td>
                    <select id="directManager" name="directManager.ID">
                        <option value="">---</option>
                        <c:forEach items="${managers}" var="manager">
                            <option <c:if test="${loadedPerson.directManager.ID==manager.ID}"> selected </c:if>
                                    value="${manager.ID}">${manager.personName}</option>
                        </c:forEach>
                    </select>
                </td>
            </tr>

            <tr>
                <td class="tdlable"> شماره تماس</td>
                <td>
                    <input type="text" name="personPhone" value="${loadedPerson.personPhone}"/>
                </td>
            </tr>
            <tr>
                <td class="tdlable">
                    <label for="active">وضعیت کاربر</label>
                </td>
                <td>
                    <input type="checkbox" name="active" id="active"
                           <c:if test="${loadedPerson.active==true}">checked</c:if>>
                </td>
            </tr>
            <tr>
                <td>
                    <input type="submit" value="بروز رسانی کاربر"/>
                </td>
            </tr>
        </table>
    </form>
</div>
</body>
</html>
