<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
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
            width: 20%;
        }

        .tdlable {
            text-align: right
        }
    </style>
    <c:if test="${isSent == true}">
        <title>صندوق ارسال</title>
    </c:if>
    <c:if test="${isSent == false}">
        <title>صندوق دریافت</title>
    </c:if>
</head>

<body>
<div class="topnav">
    <a href="/person/findAll.do?active=1" > <img src="/assets/image/home.png" width="32" height="32">صفحه اصلی </a>
    <a href="/person/savePage.do"><img src="/assets/image/profile.jpg" width="32" height="32">ایجاد کاربر جدید</a>
    <a href="/offRequest/offRequest.do?ID=${person.ID}"><img src="/assets/image/offRequest.jpg" width="32" height="32">مرخصی</a>
    <a href="/person/update.do?ID=${person.ID}"><img src="/assets/image/updatePerson.png" width="32" height="32">بروز رسانی</a>
    <a href="/email/email.do?ID=${person.ID}"><img src="/assets/image/email/email.png " width="32" height="32">ارسال ایمیل</a>
    <a href="/email/showInbox.do?ID=${person.ID}&active=true"<c:if test="${isSent!=true}"> class="active"</c:if>><img src="/assets/image/inbox.png"width="32" height="32">
        صندوق دریافت</a>

    <a href="/email/showSentBox.do?ID=${person.ID}&active=true" <c:if test="${isSent==true}"> class="active"</c:if> ><img src="/assets/image/outbox.png" width="32" height="32">
        صندوق ارسال</a>

</div>
<c:if test="${isSent!=true}">
    <table class=center>

        <c:if test="${receivedEmails.size()==0}">
            <p class="pcenter">ایمیلی برای نمایش وجود ندارد</p>
        </c:if>
        <c:if test="${receivedEmails.size()==null}">
            <p class="pcenter">ایمیلی برای نمایش وجود ندارد</p>
        </c:if>
        <c:forEach items="${receivedEmails}" var="recEmail">
            <tr>
                <td class="tdlable">
                    <label for="emailsubject">عنوان ایمیل</label>
                    <input type="text" id="emailsubject" disabled value="${recEmail.emailSubject}">
                </td>
                <td class="tdlable">
                    <label for="senderPerson">ارسال کننده</label>
                    <input type="text" id="senderPerson" disabled value="${recEmail.senderPerson.personName}">
                </td>
            </tr>
            <tr>
                <td>
                    <c:if test="${recEmail.emailAttachmentName != null}">
                        <a href="/email/downloadAttached.do?ID=${recEmail.ID}">دانلود فایل ضمیمه</a>
                    </c:if>
                </td>
                <td>
                <textarea id="receivedEmailContent" name="emailContent" class="special-text" rows="5" cols="50">${recEmail.emailContent}</textarea>
                </td>
            </tr>
        </c:forEach>
    </table>
</c:if>

<c:if test="${isSent==true}">
    <table class="center">
        <c:if test="${sentEmails.size()==0}">
            <p class="pcenter">ایمیلی برای نمایش وجود ندارد</p>
        </c:if>
        <c:if test="${sentEmails.size()==null}">
            <p class="pcenter">ایمیلی برای نمایش وجود ندارد</p>
        </c:if>
        <c:forEach items="${sentEmails}" var="sentEmail">
            <tr>
                <td class="tdlable">
                    <label for="sentEmailSubject">عنوان ایمیل</label>
                    <input type="text" id="sentEmailSubject" disabled value="${sentEmail.emailSubject}">
                </td>
                <td class="tdlable">
                    <c:forEach items="${sentEmail.receiverPersons}" var="recPer">
                        <label for="receiverPerson">دریافت کننده</label>
                        <input type="text" id="receiverPerson" disabled value="${recPer.personName}">
                    </c:forEach>
                </td>
            </tr>
            <tr>
                <td class="tdlable">
                    <c:if test="${sentEmail.emailAttachmentName != null}">
                        <a href="/email/downloadAttached.do?ID=${sentEmail.ID}">دانلود فایل ضمیمه شده</a>
                    </c:if>
                </td>
                <td>
                <textarea id="sentEmailContent" name="emailContent" rows="5" cols="50">${sentEmail.emailContent}</textarea>
                </td>
            </tr>
        </c:forEach>
    </table>
</c:if>
</body>
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
        integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
        crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"
        integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
        crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
        integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
        crossorigin="anonymous"></script>
</html>