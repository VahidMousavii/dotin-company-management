<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>مرخصی</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <link rel="stylesheet" type="text/css" href="/assets/css/menu/menu.css">
    <link type="text/css" rel="stylesheet" href="/assets/css/calendar/persianDatepicker-default.css"/>
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
            var offDescription = document.getElementById("offDescription").value;
            if (offDescription == '') {
                alert('فیلد توضیحات نمیتواند خالی باشد');
                return false;
            }
            var offStartDate = document.getElementById("offStartDate").value;
            if (offStartDate == '') {
                alert('تاریخ شروع نمیتواند خالی باشد')
                return false;
            }

            var offEndDate = document.getElementById("offEndDate").value;
            if (offEndDate == '') {
                alert('تاریخ پایان نمیتواند خالی باشد');
                return false;
            }
        }
    </script>
</head>
<body>
<div class="topnav">
    <a href="/person/findAll.do?active=1"><img src="/assets/image/home.png" width="32" height="32">صفحه اصلی</a>
    <a href="/person/savePage.do"><img src="/assets/image/profile.jpg" width="32" height="32">ایجاد کاربر</a>
    <a href="#" class="active"><img src="/assets/image/offRequest.jpg" width="32" height="32">مرخصی</a>
    <a href="/person/update.do?ID=${person.ID}"><img src="/assets/image/updatePerson.png" width="32" height="32">بروز رسانی</a>
    <a href="/email/email.do?ID=${person.ID}">ارسال ایمیل<img src="/assets/image/email/email.png " width="32" height="32"></a>
    <a href="/email/showInbox.do?ID=${person.ID}&active=true"><img src="/assets/image/inbox.png"width="32" height="32">صندوق دریافت</a>
    <a href="/email/showSentBox.do?ID=${person.ID}&active=true"><img src="/assets/image/outbox.png" width="32" height="32">صندوق ارسال</a>
</div>
<div class="center">
    <table>
    <form action="/offRequest/saveOffRequest.do" method="post" autocomplete="off" onsubmit="return check()">
        <p class="center"><b>ایجاد درخواست مرخصی جدید</b></p>
            <input type="hidden" name="requesterPerson.ID" value="${person.ID}"/>
            <tr>
                <td class="tdlable">
                    <label for="offDescription">توضیحات</label>
                    <input type="text" name="offDescription" id="offDescription"/>
                </td>
            </tr>
            <tr>
                <td class="tdlable">
                    <label for="offStartDate"> تاریخ آغاز مرخصی</label>
                    <input type="text" class="usage" name="offStartDate" id="offStartDate"/>
                </td>
            </tr>
            <tr>
                <td class="tdlable">
                    <label for="offEndDate"> تاریخ پایان مرخصی</label>
                    <input type="text" class="usage" name="offEndDate" id="offEndDate"/>
                </td>
            </tr>
            <tr>
                <td class="tdlable" >
                    <label for="typeSelect">نوع مرخصی</label>
                    <select  name="typeOfRequest.ID" id="typeSelect">
                        <c:forEach items="${offRequestType}" var="offSub">
                            <option value="${offSub.ID}">${offSub.subCategoryFarsiName}</option>
                        </c:forEach>
                    </select></td>
            </tr>
        <tr>
            <td class="tdlable">
                <input type="submit" value="ثبت درخواست جدید مرخصی">
            </td>
        </tr>

    </form>
    </table>
</div>

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
        <tr>
            <p align="center"><b>↓جدول مرخصی های شما↓</b>
            </p>
        </tr>
        <thead>
        <td>نام کاربر</td>
        <td>نوع مرخصی</td>
        <td>مدیر مرتبط</td>
        <td>شرح مرخصی</td>
        <td>زمان ایجاد درخواست مرخصی</td>
        <td>تاریخ آغاز مرخصی</td>
        <td>تاریخ پایان مرخصی</td>
        <td>وضعیت فعلی مرخصی</td>
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

        <c:if test="${pendingOffRequestsOfManager.size()!=0}">
            <table class="table table-striped table-dark" style="width: 95%; margin-left: auto;
               margin-right: auto ">

                <tr>
                    <p align="center"><b>↓جدول تایید یا رد مرخصی مخصوص مدیران↓</b>
                    </p>
                </tr>
                <thead>
                <td>نام کاربر درخواست دهنده مرخصی</td>
                <td>نوع مرخصی</td>
                <td>شرح مرخصی</td>
                <td>زمان ایجاد درخواست</td>
                <td>تاریخ آغاز مرخصی</td>
                <td>تاریخ پایان مرخصی</td>
                <td>وضعیت فعلی مرخصی</td>
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
                            <a href="/offRequest/confirmOffRequest.do?ID=${pendingOffRequestOfManager.ID}">تایید
                                مرخصی</a>
                        </td>
                        <td><a href="/offRequest/rejectOffRequest.do?ID=${pendingOffRequestOfManager.ID}">رد درخواست
                            مرخصی</a></td>
                    </tr>
                </c:forEach>
            </table>
        </c:if>

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

<script type="text/javascript" src="/assets/js/calendar/jquery-1.10.1.min.js"></script>
<script type="text/javascript" src="/assets/js/calendar/persianDatepicker.js"></script>

<script>
    $(function () {
        //usage
        $(".usage").persianDatepicker();

    });
</script>

</body>
</html>
