<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <c:if test="${isSent == true}">
        <title>SENT BOX</title>
    </c:if>
    <c:if test="${isSent == false}">
        <title>INBOX</title>
    </c:if>
</head>

<body>

<table class="table table-striped">
    <c:if test="${receivedEmails.size()==0}">
        <p>ایمیلی برای نمایش وجود ندارد</p>
    </c:if>
    <c:if test="${receivedEmails.size()==null}">
        <p>ایمیلی برای نمایش وجود ندارد</p>
    </c:if>
    <c:forEach items="${receivedEmails}" var="recEmail">
        <tr>
            <td>
                <label for="emailsubject">عنوان ایمیل</label>
                <input type="text" id="emailsubject" disabled value="${recEmail.emailSubject}">
            </td>
            <td>
                <label for="senderPerson">ارسال کننده</label>
                <input type="text" id="senderPerson" disabled value="${recEmail.senderPerson.personName}">
            </td>
        </tr>
        <tr>
            <td>
                <a href="/email/downloadAttached.do?ID=${recEmail.ID}">ذانلوذ</a>
            </td>
            <td>
                <textarea id="receivedEmailContent" name="emailContent" class="special-text" rows="5" cols="50">
                        ${recEmail.emailContent}
                </textarea>
            </td>
        </tr>
    </c:forEach>
</table>

<c:if test="${isSent==true}">
    <table>
        <c:if test="${sentEmails.size()==0}">
            <p>ایمیلی برای نمایش وجود ندارد</p>
        </c:if>
        <c:forEach items="${sentEmails}" var="sentEmail">
            <tr>
                <td><label for="sentEmailSubject">عنوان</label></td>
                <td>
                    <input type="text" id="sentEmailSubject" disabled value="${sentEmail.emailSubject}">
                </td>
                <td>
                   <a href="/email/downloadAttached.do?ID=${sentEmail.ID}">ذانلوذ</a>
                </td>
                <td>
                    <c:forEach items="${sentEmail.receiverPersons}" var="recPer">
                        <label for="receiverPerson">دریافت کننده:</label>
                        <input type="text" id="receiverPerson" disabled value="${recPer.personName}">

                    </c:forEach>
                </td>
            </tr>
            <tr>
                <td>
                <textarea id="sentEmailContent" name="emailContent" rows="5" cols="50">
                        ${sentEmail.emailContent}
                </textarea>
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
