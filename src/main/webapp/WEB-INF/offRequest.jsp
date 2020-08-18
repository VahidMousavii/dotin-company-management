<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>OFF REQUEST PAGE</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
</head>
<div class="box-table">
    <a href="/person/findAll.do?active=1">برگشت به صفحه اصلی</a>
    <br><br>
    <form action="/offRequest/saveOffRequest.do" method="post">

        <p>ایجاد درخواست مرخصی جدید</p>


        <input type="hidden" name="requesterPerson.ID" value="${person.ID}"/>
        <label class="danger" for="offDescription">توضیحات</label>
        <input type="text" name="offDescription" id="offDescription"/>
        <br>
        <label for="offStartDate"> تاریخ آغاز مرخصی</label>
        <input type="text" name="offStartDate" id="offStartDate"/>
        <br>
        <label for="offEndDate"> تاریخ پایان مرخصی</label>
        <input type="text" name="offEndDate" id="offEndDate"/>
        <br>
        <select name="typeOfRequest.ID">
            <c:forEach items="${offRequestType}" var="offSub">
                <option value="${offSub.ID}">${offSub.subCategoryFarsiName}</option>
            </c:forEach>
        </select>
        <input type="submit" value="ثبت درخواست جدید مرخصی">
    </form>

    <table class="table table-striped table-dark" style="width: 95%; margin-left: auto;
  margin-right: auto">

        <thead>
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

    <table class="table table-striped table-dark" style="width: 95%; margin-left: auto;
  margin-right: auto">
        <thead>
        <td>نام</td>
        <td>نوع مرخصی</td>
        <td>مدیر مرتبط</td>
        <td>شرح مرخصی</td>
        <td>زمان ایجاد</td>
        <td>تاریخ آغاز مرخصی</td>
        <td>تاریخ پایان مرخصی</td>
        <td>وضعیت مرخصی</td>
        </thead>

        <c:forEach items="${offRequests}" var="offrequest">
            <tr>
                <td>${offrequest.requesterPerson.personName}</td>
                <td>${offrequest.typeOfRequest.subCategoryFarsiName}</td>
                <td>${offrequest.requesterPerson.directManager.personName}</td>
                <td>${offrequest.offDescription}</td>
                <td>${offrequest.creationDate}</td>
                <td>${offrequest.offStartDate}</td>
                <td>${offrequest.offEndDate}</td>
                <td>${offrequest.statusOfRequest.subCategoryFarsiName}</td>
            </tr>
        </c:forEach>
        <br>


        <table class="table table-striped table-dark" style="width: 95%; margin-left: auto;
               margin-right: auto ">
            <thead>
            <td>نام</td>
            <td>نوع مرخصی</td>
            <td>شرح مرخصی</td>
            <td>زمان ایجاد</td>
            <td>تاریخ آغاز مرخصی</td>
            <td>تاریخ پایان مرخصی</td>
            <td>وضعیت مرخصی</td>
            </thead>
            <c:forEach items="${pendingOffRequestsOfManager}" var="pendingOffRequestOfManager">
                <tr>
                    <td>${pendingOffRequestOfManager.requesterPerson.personName}</td>
                    <td>${pendingOffRequestOfManager.typeOfRequest.subCategoryFarsiName}</td>
                    <td>${pendingOffRequestOfManager.offDescription}</td>
                    <td>${pendingOffRequestOfManager.creationDate}</td>
                    <td>${pendingOffRequestOfManager.offStartDate}</td>
                    <td>${pendingOffRequestOfManager.offEndDate}</td>
                    <td>${pendingOffRequestOfManager.statusOfRequest.subCategoryFarsiName}</td>
                    <td>
                        <a href="/offRequest/confirmOffRequest.do?ID=${pendingOffRequestOfManager.ID}">تایید</a>
                    </td>
                    <td><a href="/offRequest/rejectOffRequest.do?ID=${pendingOffRequestOfManager.ID}">رد درخواست مرخصی</a></td>
                </tr>
            </c:forEach>
        </table>

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
