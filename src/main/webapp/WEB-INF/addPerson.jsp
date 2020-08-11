<%--
  Created by IntelliJ IDEA.
  User: vahid
  Date: 8/4/2020
  Time: 11:03 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>ADD PERSON PAGE</title>
</head>
<body>
<table border="0" style="width: 100%">
    <form action="/person/save.do" method="post">
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
        <tr>
            <td>وضعیت کاربر(فعال/غیرفعال)</td>
            <td><input type="checkbox" name="c_active"/></td>
        </tr>

        <input type="submit" value="ثبت کاربر جدید"/>
    </form>
</table>
</body>
</html>
