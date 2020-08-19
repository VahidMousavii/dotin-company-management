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
    <title>ADD PERSON PAGE</title>
    <link href="webjars/bootstrap/3.3.6/css/bootstrap.min.css"
          rel="stylesheet">
    <link href="css/custom.css"
          rel="stylesheet">
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
<div class="center">
    <p class="pcenter">افزودن کاربر</p>
    <form action="/person/save.do" method="post">
        <table class="box-table">
            <tr>
                <td class="tdlable">نام</td>
                <td>
                    <input type="text" name="personName"/>
                </td>
            </tr>
            <tr>
                <td class="tdlable">نام خانوادگی</td>
                <td>
                    <input type="text" name="personFamily"/>
                </td>
            </tr>
            <tr>
                <td class="tdlable">شماره تماس</td>
                <td><input type="text" name="personPhone"/></td>
            </tr>
            <tr>
                <td class="tdlable">کد پرسنلی</td>
                <td><input type="text" name="personnelCode"/></td>
            </tr>
            <tr>
                <td class="tdlable">کد ملی</td>
                <td><input type="text" name="nationalCode"/></td>
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
                    <input type="submit" value="ثبت کاربر جدید"/>
                </td>
            </tr>
        </table>
    </form>
    <script src="webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>
    <script src="webjars/jquery/1.9.1/jquery.min.js"></script>
    <script src="js/custom.js"></script>
</div>
</body>
</html>
