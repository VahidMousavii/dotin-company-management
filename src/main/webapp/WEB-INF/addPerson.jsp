<%--
  Created by IntelliJ IDEA.
  User: vahid
  Date: 8/4/2020
  Time: 11:03 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>ایجاد کاربر جدید</title>
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
    <script type="text/javascript">
        function check() {
            var personName = document.getElementById("personName").value;
            if (personName == '') {
                alert('فیلد نام نمیتواند خالی باشد');
                return false;
            }
            var personFamily = document.getElementById("personFamily").value;
            if (personFamily == '') {
                alert('فیلد نام خانوادگی نمیتواند خالی باشد')
                return false;
            }

            var personPhone = document.getElementById("personPhone").value;
            if (personPhone == '') {
                alert('فیلد شماره تماس نمیتواند خالی باشد');
                return false;
            }
            var personnelCode = document.getElementById("personnelCode").value;
            if (personnelCode == '') {
                alert('فیلد کد پرسنلی نمیتواند خالی باشد');
                return false;
            }
            var nationalCode = document.getElementById("nationalCode").value;
            if (nationalCode == '') {
                alert('فیلد کد ملی نمیتواند خالی باشد');
                return false;
            }
        }
    </script>
</head>
<body>
<div class="topnav">
    <a href="/person/findAll.do?active=1"><img src="/assets/image/home.png" width="32" height="32">صفحه اصلی</a>
    <a class="active" href="/person/savePage.do"><img src="/assets/image/profile.jpg" width="32" height="32">ایجاد کاربر</a>
</div>
<div class="center">
    <p class="pcenter">افزودن کاربر</p>
    <form action='/person/save.do' method='post' onsubmit="return check();">
        <input type="hidden" name="enable" value="1"/>
        <table class="table-responsive">
            <tr>
                <td class="tdlable">نام</td>
                <td>
                    <input type="text" id="personName" name="personName" autofocus/>
                </td>
            </tr>
            <tr>
                <td class="tdlable">نام خانوادگی</td>
                <td>
                    <input type="text" id="personFamily" name="personFamily"/>
                </td>
            </tr>
            <tr>
                <td class="tdlable">شماره تماس</td>
                <td><input type="text" id="personPhone" name="personPhone"/></td>
            </tr>
            <tr>
                <td class="tdlable">کد پرسنلی</td>
                <td><input type="text" id="personnelCode" name="personnelCode"/></td>
            </tr>
            <tr>
                <td class="tdlable">کد ملی</td>
                <td><input type="text" id="nationalCode" name="nationalCode"/></td>
            </tr>
            <tr>
                <td class="tdlable">
                    <p> سمت</p>
                </td>
                <td>
                    <select name="roleSubCategory.ID">
                        <c:forEach items="${roles}" var="role">
                            <option value="${role.ID}">${role.subCategoryFarsiName}</option>
                        </c:forEach>
                    </select>
                </td>
            </tr>

            <tr>
                <td class="tdlable">
                    <label for="manager">مدیر مستقیم</label>
                </td>
                <td>
                    <select id="manager" name="directManager.ID">
                        <c:forEach items="${managers}" var="manager">
                            <option value="${manager.ID}">${manager.personName}</option>
                        </c:forEach>
                    </select>
                </td>
            </tr>
            <tr>
                <td class="tdlable">وضعیت (فعال/غیرفعال)</td>
                <td><input type="checkbox" name="active"/></td>
            </tr>
            <tr>
                <td colspan="2" align="center">
                    <input type="submit" name="submit" id="submit" value="ثبت کاربر جدید"/>
                </td>
            </tr>
        </table>
    </form>
    <script src="webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>
    <script src="webjars/jquery/1.9.1/jquery.min.js"></script>
</div>
</body>
</html>
