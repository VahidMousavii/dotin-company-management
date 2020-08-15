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
</head>
<div class="box-table">

    <form action="/person/save.do" method="post">
        <table class="box-table">
        <tr>
            <td>نام</td>
            <td>
                <input type="text" name="personName"/>
            </td>
        </tr>
        <tr>
            <td>نام خانوادگی</td>
            <td>
                <input type="text" name="personFamily"/>
            </td>
        </tr>
        <tr>
            <td>شماره تماس</td>
            <td> <input type="text" name="personPhone"/></td>
        </tr>
        <tr>
            <td>کد پرسنلی</td>
            <td> <input type="text" name="personnelCode"/></td>
        </tr>
        <tr>
            <td>کد ملی</td>
            <td>  <input type="text" name="nationalCode"/></td>
        </tr>
            <br>
            <tr>
                <p> سمت</p>
                <select name="roleSubCategory.ID">
                    <c:forEach items="${roles}" var="role">
                        <option value="${role.ID}">${role.subCategoryFarsiName}</option>
                    </c:forEach>
                </select>

            </tr>
            <br>
        <tr>
            <td>وضعیت کاربر(فعال/غیرفعال)</td>
            <td><input type="checkbox" name="active"/></td>
        </tr>
            <tr>
                <td>
                    <select name="directManager.ID">
                        <c:forEach items="${managers}" var="manager">
                            <option value="${manager.ID}">${manager.personName}</option>
                        </c:forEach>
                    </select>
                </td>
            </tr>

        <input type="submit" value="ثبت کاربر جدید"/>
        </table>
    </form>
    <script src="webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>
    <script src="webjars/jquery/1.9.1/jquery.min.js"></script>
    <script src="js/custom.js"></script>
</div>
</body>
</html>
