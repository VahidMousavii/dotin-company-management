<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="C" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>OFF REQUEST PAGE</title>
</head>
<a href="/person/findAll.do">برگشت به صفحه اصلی</a>
<br><br>
<form action="/offRequest/saveOffRequest.do" method="post">
    <p>ایجاد درخواست مرخصی جدید</p>
    <input type="hidden" name="requesterPerson.c_ID" value="${person.c_ID}"/>
    <label for="offDescription">توضیحات</label>
    <input type="text" name="offDescription" id="offDescription"/>
    <br>
    <label for="offStartDate"> تاریخ آغاز مرخصی</label>
    <input type="text" name="offStartDate" id="offStartDate"/>
    <br>
    <label for="offEndDate"> تاریخ پایان مرخصی</label>
    <input type="text" name="offEndDate" id="offEndDate"/>
    <br>
    <select name="typeOfRequest.c_ID">
        <C:forEach items="${offCategory.subCategories}" var="offSub">
            <option value="${offSub.c_ID}">${offSub.subCategoryFarsiName}</option>
        </C:forEach>
    </select>
    <input type="submit" value="ثبت درخواست جدید مرخصی">
</form>

<table border="1" style="width: 100%">

    <thead style="background-color: gray;color: aliceblue">
    <td>نام</td>
    <td>نام خانوادگی</td>
    <td>کد پرسنلی</td>
    <td>کد ملی</td>
    <td>شماره تماس</td>
    </thead>

    <tr>
        <td>${person.personName}</td>
        <td>${person.personFamily}</td>
        <td>${person.personnelCode}</td>
        <td>${person.nationalCode}</td>
        <td>${person.personPhone}</td>
        </td>
    </tr>
</table>

<table border="1" style=" color: darkblue; width: 100%">
    <thead style=" color: darkblue">
    <td>نام</td>
    <td>نوع مرخصی</td>
    <td>مدیر مرتبط</td>
    <td>شرح مرخصی</td>
    <td>زمان ایجاد</td>
    <td>تاریخ آغاز مرخصی</td>
    <td>تاریخ پایان مرخصی</td>
    </thead>

    <c:forEach items="${person.offRequestList}" var="offrequest">
        <tr>
            <td>${offrequest.requesterPerson.personName}</td>
            <td>${offrequest.typeOfRequest.subCategoryFarsiName}</td>
            <td>${offrequest.receiverManagerPerson.personName}</td>
            <td>${offrequest.offDescription}</td>
            <td>${offrequest.creationDate}</td>
            <td>${offrequest.offStartDate}</td>
            <td>${offrequest.offEndDate}</td>
        </tr>
    </c:forEach>

</table>
</body>
</html>
